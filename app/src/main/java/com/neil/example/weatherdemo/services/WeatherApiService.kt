package com.neil.example.weatherdemo.services;

import com.neil.example.weatherdemo.beans.SearchLocationListBean
import com.neil.example.weatherdemo.beans.WeatherBean
import com.neil.example.weatherdemo.network.HttpCallback

//https://api.worldweatheronline.com/premium/v1/weather.ashx?q=singapore&key=cb0a1729844e4568b2d70534191212&date=today&format=json

interface WeatherApiService {

    fun getWeather(cityName : String, callback: HttpCallback<WeatherBean>)

    fun searchLocations(cityName : String, callback: HttpCallback<SearchLocationListBean>)
}
