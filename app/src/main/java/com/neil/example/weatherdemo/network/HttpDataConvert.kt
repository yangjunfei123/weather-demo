package com.neil.example.weatherdemo.network

import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception

object  HttpDataConvert {

    fun convertHttpParams(map : Map<String, Any>) : String {
        var stringBuffer = StringBuffer()
        for ((key, v) in map) stringBuffer.append("$key=$v&")
        return stringBuffer.toString()
    }


    /**
     * "country":[
    {
    "value":"United Kingdom"
    }
    ],
     * */
    fun parseDataFromArray(json: JSONObject, name: String, value: String): String {
        if (json.has(name)) {
            var array = json.optJSONArray(name)
            if (array is JSONArray) return array.optJSONObject(0).optString(value)
            return json.optString(name)
        }
        return ""
    }

    fun parseObjectFiled(json: JSONObject, obj: Any) {
        obj.javaClass.declaredFields.forEach {
            var fieldName = it.name
            if (it.type == String::class.java) {
                try {
                    var capital = fieldName.first().toUpperCase()
                    var methodSuffix = fieldName.replaceFirst(fieldName[0], capital)
                    var methodName = "set$methodSuffix"
                    var method = obj.javaClass.getDeclaredMethod(methodName, String::class.java)
                    if (method != null && obj != null) {
                        var value = parseDataFromArray(json, fieldName, "value")
                        method.invoke(obj, value)
                    }
                } catch (e : Exception) {
                    e.printStackTrace()
                }
            }

        }
    }

}