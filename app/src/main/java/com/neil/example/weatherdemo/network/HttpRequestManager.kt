package com.neil.example.weatherdemo.network

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.text.TextUtils
import android.util.Log
import com.neil.example.weatherdemo.ui.UIEventHandler
import com.neil.example.weatherdemo.beans.HttpBaseBean
import com.neil.example.weatherdemo.beans.WeatherErrorBean
import org.json.JSONObject
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

object HttpRequestManager {

    var asynRequest = true

    private val httpThreadPool = ThreadPoolExecutor(0, 1,
        60L, TimeUnit.SECONDS,
        LinkedBlockingQueue<Runnable>(),
        ThreadFactory { Thread(it) })

    private const val TAG = "Http"
    private const val base_url = "https://api.worldweatheronline.com/"
    private const val base_network_timeout = 30 * 1000

    private const val weather_api_key = "cb0a1729844e4568b2d70534191212"
    private const val weather_api_resp_format = "json"
    private val defaultParameterMap = mapOf<String, Any>(
        "key" to weather_api_key,
        "format" to weather_api_resp_format)


    private fun createHttpUrlConnection(url: String): HttpURLConnection {
        var httpUrl = URL(url)
        var httpURLConnection = httpUrl.openConnection() as HttpURLConnection

        httpURLConnection.connectTimeout = base_network_timeout
        httpURLConnection.readTimeout = base_network_timeout
        return httpURLConnection
    }

    private fun doHttpGetReal(url:String, parameter : String, callback: HttpCallback<String>)  {
        var fullRequestUrl = "$base_url$url?$parameter"
        Log.d(TAG, fullRequestUrl)
        var httpURLConnection : HttpURLConnection? = null
        try {
            httpURLConnection = createHttpUrlConnection(fullRequestUrl)
            callback.onSucceed(httpURLConnection.getInputStream().bufferedReader().readText())
        } catch (e : Exception) {
            callback.onFailed(ErrorCode.error_network, ErrorCode.error_msg_network)
        } finally {
            httpURLConnection?.disconnect()
        }
    }

    class HttpGetRequestRunnable<T>(requestUrl : String, requestMap : MutableMap<String, Any>, requestCallBack: HttpCallback<T>) : Runnable {
        var url = requestUrl
        var srcMap = requestMap
        var callback = requestCallBack

        override fun run() {
            var map = defaultParameterMap.toMap(srcMap)
            var requestParam = HttpDataConvert.convertHttpParams(map)

            var httpCallback = object : HttpCallback<String>(String()) {
                override fun onSucceed(t: String) {
                    Log.d(TAG, "$requestParam\n$t")
                    try {

                        var jsonObject = JSONObject(t)
                        var error = WeatherErrorBean()
                        error.parse(jsonObject)

                        if (error.isError()) {
                            if (asynRequest) UIEventHandler.post(({ callback.onFailed(ErrorCode.error_return_server, "${error.errorMsg}") }))
                            else callback.onFailed(ErrorCode.error_return_server, "${error.errorMsg}")
                            return
                        }

                        val data = callback.target
                        if (data is HttpBaseBean) {
                            //parse the data
                            data.parse(JSONObject(t))
                            //send data back to ui thread
                            if (asynRequest) UIEventHandler.post(({ callback.onSucceed(data) }))
                            else callback.onSucceed(data)
                        } else {
                            if (asynRequest) UIEventHandler.post(({ callback.onFailed(ErrorCode.error_data_parse, ErrorCode.error_msg_data_parse) }))
                            else callback.onFailed(ErrorCode.error_data_parse, ErrorCode.error_msg_data_parse)
                        }
                    } catch (e: Exception) {
                        if (asynRequest) UIEventHandler.post(({ callback.onFailed(ErrorCode.error_data_parse, ErrorCode.error_msg_data_parse) }))
                        else callback.onFailed(ErrorCode.error_data_parse, ErrorCode.error_msg_data_parse)
                    }
                }

                override fun onFailed(errCode: Int, msg: String) {
                    if (asynRequest) UIEventHandler.post(({ callback.onFailed(errCode, msg) }))
                    else callback.onFailed(errCode, msg)
                }
            }
            doHttpGetReal(url, requestParam, httpCallback)
        }
    }

    fun <T> doHttpGet(url : String, srcMap : MutableMap<String, Any>, callback: HttpCallback<T>) {
        var httpRunnable = HttpGetRequestRunnable(url, srcMap, callback)
        if (asynRequest) httpThreadPool.execute(httpRunnable)
        else httpRunnable.run()
    }


    class HttpBitmapLoaderRunnable(url: String, callback: HttpCallback<Bitmap>) : Runnable {
        private var bitmapUrl = url
        private var bitmapCallback: HttpCallback<Bitmap> = callback
        var cancelTask = false

        override fun run() {
            var bitmap = doRealBitmapLoad(bitmapUrl)
            if (cancelTask) {
                if (asynRequest) UIEventHandler.post(({bitmapCallback.onFailed(ErrorCode.error_bitmap_load_canceld, ErrorCode.error_msg_bitmap_load_canceled)}))
                else bitmapCallback.onFailed(ErrorCode.error_bitmap_load_canceld, ErrorCode.error_msg_bitmap_load_canceled)
                return
            }


            if (bitmap != null) {
                if (asynRequest) UIEventHandler.post(({bitmapCallback.onSucceed(bitmap)}))
                else bitmapCallback.onSucceed(bitmap)
            } else {
                if (asynRequest) UIEventHandler.post(({bitmapCallback.onFailed(ErrorCode.error_bitmap_load, ErrorCode.error_msg_bitmap_load)}))
                else bitmapCallback.onFailed(ErrorCode.error_bitmap_load, ErrorCode.error_msg_bitmap_load)
            }
        }
    }

    private fun doRealBitmapLoad(url: String): Bitmap? {
        if (TextUtils.isEmpty(url)) return null

        var httpURLConnection : HttpURLConnection? = null
        try {
            httpURLConnection = createHttpUrlConnection(url)
            return BitmapFactory.decodeStream(httpURLConnection.inputStream)
        } catch (e : Exception) {
            e.printStackTrace()
        } finally {
            httpURLConnection?.disconnect()
        }
        return null
    }

    fun loadBitmap(url: String, callback: HttpCallback<Bitmap>): HttpBitmapLoaderRunnable{
        var bitmapRequest = HttpBitmapLoaderRunnable(url, callback)
        if (asynRequest) httpThreadPool.execute(bitmapRequest)
        else bitmapRequest.run()
        return bitmapRequest
    }
}