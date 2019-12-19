package com.neil.example.weatherdemo.services

import android.graphics.Bitmap
import android.widget.ImageView
import com.neil.example.weatherdemo.network.HttpCallback
import com.neil.example.weatherdemo.network.HttpRequestManager

object ImageLoader {

    /**
     * TODO:
     *  need to check if we call this function lots of time, image show may not correct.
     *  for now, for the single image show in demo, this issue not exist.
     *
     * */
    fun load(url: String, target: ImageView) {
        HttpRequestManager.loadBitmap(url, object : HttpCallback<Bitmap>(null) {
            override fun onSucceed(t: Bitmap) {
                if (target.isAttachedToWindow) {
                    target.setImageBitmap(t)
                }
            }

            override fun onFailed(errCode: Int, msg: String) {
            }
        })
    }
}