package com.neil.example.weatherdemo.beans

import com.neil.example.weatherdemo.network.HttpDataConvert
import org.json.JSONObject

class WeatherErrorBean : HttpBaseBean {
    var errorMsg: String? = null

    fun  isError(): Boolean {
        return !errorMsg.isNullOrEmpty()
    }

    override fun parse(obj: JSONObject) {
        if (obj.has("data")) {
            var dataObject = obj.optJSONObject("data")
            errorMsg = HttpDataConvert.parseDataFromArray(dataObject?:JSONObject(), "error", "msg")
        }
    }
}