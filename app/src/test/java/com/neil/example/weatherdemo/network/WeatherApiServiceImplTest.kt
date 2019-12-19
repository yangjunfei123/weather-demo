package com.neil.example.weatherdemo.network

import com.neil.example.weatherdemo.RoboApp
import com.neil.example.weatherdemo.beans.SearchLocationListBean
import com.neil.example.weatherdemo.beans.WeatherBean
import com.neil.example.weatherdemo.services.WeatherApiServiceImpl
import org.junit.After
import org.junit.Test

import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = RoboApp::class)
class WeatherApiServiceImplTest {

    var weatherApiService = WeatherApiServiceImpl();

    @Before
    fun setup() {
        HttpRequestManager.asynRequest = false
    }

    @After
    fun tearDown() {
        HttpRequestManager.asynRequest = true
    }

    @Test
    fun get_weather_with_xian() {
        weatherApiService.getWeather("xian", object : HttpCallback<WeatherBean>(WeatherBean()) {
            override fun onSucceed(t: WeatherBean) {
            }

            override fun onFailed(errCode: Int, msg: String) {
                assert(false)
            }
        })
    }

    @Test
    fun get_weather_with_empty() {
        weatherApiService.getWeather("", object : HttpCallback<WeatherBean>(WeatherBean()) {
            override fun onSucceed(t: WeatherBean) {
            }

            override fun onFailed(errCode: Int, msg: String) {
                assert(errCode == ErrorCode.error_return_server)
            }
        })
    }

    @Test
    fun search_location_with_london() {
        weatherApiService.searchLocations("london", object : HttpCallback<SearchLocationListBean>(SearchLocationListBean()) {
            override fun onSucceed(t: SearchLocationListBean) {
                assert(t.searchResultList.size > 0)
                var listSize = t.searchResultList.size

                assert(listSize == 3, ({"error data length is not 3"}))

                t.searchResultList.forEach {
                    var isCorrect = it.areaName?.contains("london", true)
                    assert(isCorrect != null && isCorrect, ({"search result is not correct ${it.areaName}"}))
                }

            }

            override fun onFailed(errCode: Int, msg: String) {
                assert(false)
            }
        })
    }


    @Test
    fun search_location_with_empty() {
        weatherApiService.searchLocations("", object : HttpCallback<SearchLocationListBean>(SearchLocationListBean()) {
            override fun onSucceed(t: SearchLocationListBean) {
                assert(false)
            }

            override fun onFailed(errCode: Int, msg: String) {
                assert(errCode == ErrorCode.error_return_server)
            }
        })
    }
}