package com.neil.example.weatherdemo.beans

import com.neil.example.weatherdemo.network.HttpDataConvert
import org.json.JSONObject

class WeatherBean : HttpBaseBean {

    var current_condition: WeatherCondition? = null
    var weather: WeatherInfo? = null

    override fun parse(obj: JSONObject) {

        if (!obj.has("data")) return
        var data = obj.getJSONObject("data")
        if (data.has("current_condition")) {
            var weatherCondition = data.optJSONArray("current_condition")
            if (weatherCondition != null) {
                current_condition = WeatherCondition()
                current_condition?.parse(weatherCondition.optJSONObject(0))
            }
        }
        if (!data.has("weather")) return
        var weatherJSONObject = data.optJSONArray("weather")
        if (weatherJSONObject != null) {
            weather = WeatherInfo()
            weather?.parse(weatherJSONObject.optJSONObject(0))
        }
    }
}

class WeatherCondition {
    var observation_time: String? = null
    var temp_C: String? = null
    var temp_F: String? = null
    var FeelsLikeC: String? = null
    var FeelsLikeF: String? = null
    var windspeedMiles: String? = null
    var windspeedKmph: String? = null
    var winddirDegree: String? = null
    var winddir16Point: String? = null
    var weatherCode: String? = null
    var weatherIconUrl: String? = null
    var precipMM: String? = null
    var precipInches: String? = null
    var humidity: String? = null
    var visibility: String? = null
    var visibilityMiles: String? = null
    var pressure: String? = null
    var pressureInches: String? = null
    var cloudcover: String? = null

    fun parse(json: JSONObject) {
        HttpDataConvert.parseObjectFiled(json, this)
    }
}


class WeatherInfo {
    var date: String? = null
    var astronomy: Astronomy? = null
    var maxtempC: String? = null
    var maxtempF: String? = null
    var mintempC: String? = null
    var mintempF: String? = null
    var avgtempC: String? = null
    var avgtempF: String? = null
    var totalSnow_cm: String? = null
    var sunHour: String? = null
    var uvIndex: String? = null
    var hourly: List<WeatherPerHourInfo>? = null

    fun parse(json: JSONObject) {
        HttpDataConvert.parseObjectFiled(json, this)

        var hourlyJson = json.optJSONArray("hourly")
        if (hourlyJson != null) {
            var temp = mutableListOf<WeatherPerHourInfo>()
            for (i in 0 until hourlyJson.length()) {
                var weatherPerHourInfo = WeatherPerHourInfo()
                HttpDataConvert.parseObjectFiled(hourlyJson.optJSONObject(i), weatherPerHourInfo)
                temp.add(weatherPerHourInfo)
            }
            hourly = temp
        }

        var astronomyJson = json.optJSONArray("astronomy").optJSONObject(0)
        if (astronomyJson != null) {
            var temp = Astronomy()
            HttpDataConvert.parseObjectFiled(astronomyJson, temp)
            astronomy = temp;
        }
    }
}

class WeatherPerHourInfo {
    var time: String? = null
    var tempC: String? = null
    var tempF: String? = null
    var windspeedMiles: String? = null
    var windspeedKmph: String? = null
    var winddirDegree: String? = null
    var winddir16Point: String? = null
    var weatherCode: String? = null
    var weatherIconUrl: String? = null
    var weatherDesc: String? = null
    var precipMM: String? = null
    var humidity: String? = null
    var visibility: String? = null
    var visibilityMiles: String? = null
    var pressure: String? = null
    var pressureInches: String? = null
    var cloudcover: String? = null
    var HeatIndexC: String? = null
    var HeatIndexF: String? = null
    var DewPointC: String? = null
    var DewPointF: String? = null
    var WindChillC: String? = null
    var WindChillF: String? = null
    var WindGustMiles: String? = null
    var WindGustKmph: String? = null
    var FeelsLikeC: String? = null
    var FeelsLikeF: String? = null
    var chanceofrain: String? = null
    var chanceofremdry: String? = null
    var chanceofwindy: String? = null
    var chanceofovercast: String? = null
    var chanceofsunshine: String? = null
    var chanceoffrost: String? = null
    var chanceofhightemp: String? = null
    var chanceoffog: String? = null
    var chanceofsnow: String? = null
    var chanceofthunder: String? = null
    var uvIndex: String? = null

    fun parse(json: JSONObject) {
        HttpDataConvert.parseObjectFiled(json, this)
    }
}

class Astronomy {
    var sunrise: String? = null
    var sunset: String? = null
    var moonrise: String? = null
    var moonset: String? = null
    var moon_phase: String? = null
    var moon_illumination: String? = null

    fun parse(json: JSONObject) {
        HttpDataConvert.parseObjectFiled(json, this)
    }
}