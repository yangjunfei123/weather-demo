package com.neil.example.weatherdemo.services;

import com.neil.example.weatherdemo.beans.SearchLocationListBean
import com.neil.example.weatherdemo.beans.WeatherBean
import com.neil.example.weatherdemo.network.HttpCallback
import com.neil.example.weatherdemo.network.HttpRequestManager

class WeatherApiServiceImpl : WeatherApiService {


    //http://api.worldweatheronline.com/premium/v1/search.ashx?q=lon&key=cb0a1729844e4568b2d70534191212&type=city&format=json
    //https://api.worldweatheronline.com/premium/v1/weather.ashx?q=singapore&key=cb0a1729844e4568b2d70534191212&date=today&format=json

    override fun getWeather(cityName : String, callback: HttpCallback<WeatherBean>) {
        var srcMap = mutableMapOf<String, Any>("q" to cityName)
        HttpRequestManager.doHttpGet(
            get_weather_url,
            srcMap,
            callback
        )
    }

    override fun searchLocations(cityName : String, callback: HttpCallback<SearchLocationListBean>) {
        var srcMap = mutableMapOf<String, Any>("q" to cityName)
        HttpRequestManager.doHttpGet(
            search_location_url,
            srcMap,
            callback
        )
    }

    companion object {
        //get weather url
        const val get_weather_url = "premium/v1/weather.ashx"
        //search location url
        const val search_location_url = "premium/v1/search.ashx"
    }
}
