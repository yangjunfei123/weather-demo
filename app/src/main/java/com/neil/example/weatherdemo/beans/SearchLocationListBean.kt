package com.neil.example.weatherdemo.beans

import android.text.TextUtils
import com.neil.example.weatherdemo.network.HttpDataConvert
import org.json.JSONArray
import org.json.JSONObject
import java.io.Serializable

/**
 *
"areaName":[
{
"value":"London"
}
],
"country":[
{
"value":"United Kingdom"
}
],
"region":[
{
"value":"City of London, Greater London"
}
],
"latitude":"51.517",
"longitude":"-0.106",
"population":"7421228",
"weatherUrl":[
{
"value":"https://www.worldweatheronline.com/v2/weather.aspx?q=51.5171,-0.1062"
}
]
},
 */
class SearchLocationListBean : HttpBaseBean {

    class SearchLocaitonItem : Serializable {
        var areaName: String? = null
        var country: String? = null
        var region: String? = null
        var latitude: String? = null
        var longitude: String? = null
        var population: String? = null
        var weatherUrl: String? = null

        override fun equals(other: Any?): Boolean {
            if (other == null || !(other is  SearchLocaitonItem)) return false

            var temp: SearchLocaitonItem = other
            return TextUtils.equals(areaName, temp.areaName)
                    &&TextUtils.equals(country, temp.country)
                    &&TextUtils.equals(region, temp.region)
                    &&TextUtils.equals(latitude, temp.latitude)
                    &&TextUtils.equals(longitude, temp.longitude)
                    &&TextUtils.equals(country, temp.country)
        }

    }

    var searchResultList = mutableListOf<SearchLocaitonItem>()

    override fun parse(obj: JSONObject) {

        var jsonObject = obj.optJSONObject("search_api")
        var result: JSONArray? = jsonObject?.optJSONArray("result")
        for (i in (0 until (result?.length()?: 0 ))) {
            var searchItem = SearchLocaitonItem()
            var searchItemObj = result?.optJSONObject(i)
            HttpDataConvert.parseObjectFiled(searchItemObj?:JSONObject(), searchItem)
            searchResultList.add(searchItem)
        }
    }
}