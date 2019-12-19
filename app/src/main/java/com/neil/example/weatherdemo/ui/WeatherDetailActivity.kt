package com.neil.example.weatherdemo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.neil.example.weatherdemo.R
import com.neil.example.weatherdemo.beans.WeatherPerHourInfo
import com.neil.example.weatherdemo.services.ImageLoader

class WeatherDetailActivity : AppCompatActivity(), WeatherDetailContract.View {

    private lateinit var ivWeatherIcon: ImageView
    private lateinit var tvWeatherTemperature: TextView
    private lateinit var ivWeatherDesp: TextView
    private lateinit var ivWeatherHumidity: TextView
    private lateinit var presenter: WeatherDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_detail)

        initView()
    }

    private fun initView() {
        ivWeatherIcon = findViewById(R.id.iv_weather_img)
        tvWeatherTemperature = findViewById(R.id.tv_weather_temperature)
        ivWeatherDesp = findViewById(R.id.tv_weather_desp)
        ivWeatherHumidity = findViewById(R.id.tv_humidity)

        presenter = WeatherDetailPresenter(this)
        var location = intent.getStringExtra(extra_location)
        var locationName = intent.getStringExtra(extra_location_name)
        title = locationName
        presenter.retrieveWeatherInfo(location)
    }

    override fun onGetWeatherInfoSucceed(weatherPerHourInfo: WeatherPerHourInfo?) {
        ImageLoader.load(weatherPerHourInfo?.weatherIconUrl!!, ivWeatherIcon)
        ivWeatherDesp.text = "Weather: ${weatherPerHourInfo?.weatherDesc}"
        tvWeatherTemperature.text = "Temperature: ${weatherPerHourInfo?.tempC}"
        ivWeatherHumidity.text = "Humidity: ${weatherPerHourInfo?.humidity}"
    }

    override fun onGetWeatherInfoFailed() {

    }

    override fun isViewDestroyed(): Boolean {
        return isDestroyed
    }

    companion object {
        const val extra_location = "extra_location"
        const val extra_location_name = "extra_location_name"
        fun enterWeatherDetail(ctx: Context, location: String, locationName: String) {
            var intent = Intent(ctx, WeatherDetailActivity::class.java)
            intent.putExtra(extra_location, location)
            intent.putExtra(extra_location_name, locationName)
            ctx.startActivity(intent)
        }
    }

}