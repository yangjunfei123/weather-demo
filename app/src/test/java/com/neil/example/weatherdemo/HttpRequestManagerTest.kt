package com.neil.example.weatherdemo

import android.graphics.Bitmap
import com.neil.example.weatherdemo.beans.WeatherBean
import com.neil.example.weatherdemo.network.ErrorCode
import com.neil.example.weatherdemo.network.HttpCallback
import com.neil.example.weatherdemo.network.HttpRequestManager
import com.neil.example.weatherdemo.services.WeatherApiServiceImpl
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = RoboApp::class)
class HttpRequestManagerTest {

    @Before
    fun setup() {
        HttpRequestManager.asynRequest = false
    }

    @Test
    fun testHttpRequestQueryparameterNotfound() {
        var mutableMap = mutableMapOf<String, Any>("q" to "teset")
        HttpRequestManager.doHttpGet(WeatherApiServiceImpl.get_weather_url, mutableMap, object :HttpCallback<WeatherBean>(WeatherBean()) {
            override fun onSucceed(t: WeatherBean) {
                assert(false)
            }

            override fun onFailed(errCode: Int, msg: String) {
                assert(errCode == ErrorCode.error_return_server)
                assert(msg.equals("Unable to find any matching weather location to the query submitted!"))
            }
        })
    }

    @Test
    fun testHttpRequestUrlNotfound() {
        var mutableMap = mutableMapOf<String, Any>("q" to "teset")
        HttpRequestManager.doHttpGet("/abc/def", mutableMap, object :HttpCallback<WeatherBean>(WeatherBean()) {
            override fun onSucceed(t: WeatherBean) {
                assert(false)
            }

            override fun onFailed(errCode: Int, msg: String) {
                assert(errCode == ErrorCode.error_network)
                assert(msg.equals(ErrorCode.error_msg_network))
            }
        })
    }

    @Test
    fun test_http_request_succeed() {
        var mutableMap = mutableMapOf<String, Any>("q" to "singapore")
        HttpRequestManager.doHttpGet(WeatherApiServiceImpl.get_weather_url, mutableMap, object :HttpCallback<WeatherBean>(WeatherBean()) {
            override fun onSucceed(t: WeatherBean) {
                assert(t.current_condition != null)

                assert(!"".equals(t.weather?.avgtempC))
            }

            override fun onFailed(errCode: Int, msg: String) {
                assert(false)
            }
        })
    }

    @Test
    fun test_load_bitmap_from_internet_failed() {
        HttpRequestManager.loadBitmap("", object : HttpCallback<Bitmap>(null) {
            override fun onSucceed(t: Bitmap) {
                assert(t == null)
            }

            override fun onFailed(errCode: Int, msg: String) {
                assert(errCode == ErrorCode.error_bitmap_load)
            }
        })
    }

    @Test
    fun test_load_bitmap_from_internet_succeed() {
        HttpRequestManager.loadBitmap("https://x0.ifengimg.com/ucms/2019_51/B9C1B1D312CD49C32887C5BDD3F80D099D5A6EAA_w440_h293.jpg", object : HttpCallback<Bitmap>(null) {
            override fun onSucceed(t: Bitmap) {
                assert(t != null)
            }

            override fun onFailed(errCode: Int, msg: String) {
                assert(errCode == ErrorCode.error_bitmap_load)
            }
        })
    }
}