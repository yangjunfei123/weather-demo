package com.neil.example.weatherdemo.beans

import org.json.JSONObject
interface HttpBaseBean {

    fun parse(obj: JSONObject)
}