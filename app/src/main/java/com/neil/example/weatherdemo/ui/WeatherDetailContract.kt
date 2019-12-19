package com.neil.example.weatherdemo.ui

import com.neil.example.weatherdemo.beans.WeatherPerHourInfo

interface WeatherDetailContract {
    interface View : BaseContract.BaseView {
        fun onGetWeatherInfoSucceed(weatherPerHourInfo: WeatherPerHourInfo?)

        fun onGetWeatherInfoFailed()

    }

    interface Presenter {
        fun retrieveWeatherInfo(location: String)
    }
}