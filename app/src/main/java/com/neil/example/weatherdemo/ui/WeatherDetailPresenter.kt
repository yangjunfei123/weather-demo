package com.neil.example.weatherdemo.ui

import com.neil.example.weatherdemo.beans.WeatherBean
import com.neil.example.weatherdemo.network.HttpCallback
import com.neil.example.weatherdemo.services.WeatherApiServiceImpl
import java.util.*

class WeatherDetailPresenter(v: WeatherDetailContract.View) : WeatherDetailContract.Presenter {
    private var weatherDetailView = v
    private var weatherApiService = WeatherApiServiceImpl()

    override fun retrieveWeatherInfo(location: String) {
        weatherApiService.getWeather(location, object: HttpCallback<WeatherBean>(WeatherBean()){
            override fun onSucceed(t: WeatherBean) {
                if (weatherDetailView.isViewDestroyed()) return
                var date = Date()
                var index = date.hours / 3
                weatherDetailView.onGetWeatherInfoSucceed(t.weather?.hourly?.get(index))
            }

            override fun onFailed(errCode: Int, msg: String) {
                if (weatherDetailView.isViewDestroyed()) return
            }
        })
    }
}