package com.neil.example.weatherdemo.beans

import com.neil.example.weatherdemo.RoboApp
import org.json.JSONObject
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = RoboApp::class)
class WeatherBeanTest {

    var test = "{\"data\":{\"request\":[{\"type\":\"City\",\"query\":\"Singapore, Singapore\"}],\"current_condition\":[{\"observation_time\":\"07:03 AM\",\"temp_C\":\"32\",\"temp_F\":\"90\",\"weatherCode\":\"116\",\"weatherIconUrl\":[{\"value\":\"http://cdn.worldweatheronline.net/images/wsymbols01_png_64/wsymbol_0002_sunny_intervals.png\"}],\"weatherDesc\":[{\"value\":\"Partly cloudy\"}],\"windspeedMiles\":\"16\",\"windspeedKmph\":\"26\",\"winddirDegree\":\"40\",\"winddir16Point\":\"NE\",\"precipMM\":\"0.3\",\"precipInches\":\"0.0\",\"humidity\":\"59\",\"visibility\":\"10\",\"visibilityMiles\":\"6\",\"pressure\":\"1009\",\"pressureInches\":\"30\",\"cloudcover\":\"75\",\"FeelsLikeC\":\"37\",\"FeelsLikeF\":\"99\",\"uvIndex\":8}],\"weather\":[{\"date\":\"2019-12-12\",\"astronomy\":[{\"sunrise\":\"06:56 AM\",\"sunset\":\"06:59 PM\",\"moonrise\":\"07:10 PM\",\"moonset\":\"06:46 AM\",\"moon_phase\":\"Full Moon\",\"moon_illumination\":\"100\"}],\"maxtempC\":\"29\",\"maxtempF\":\"83\",\"mintempC\":\"25\",\"mintempF\":\"78\",\"avgtempC\":\"27\",\"avgtempF\":\"80\",\"totalSnow_cm\":\"0.0\",\"sunHour\":\"6.0\",\"uvIndex\":\"6\",\"hourly\":[{\"time\":\"0\",\"tempC\":\"22\",\"tempF\":\"72\",\"windspeedMiles\":\"11\",\"windspeedKmph\":\"18\",\"winddirDegree\":\"240\",\"winddir16Point\":\"WSW\",\"weatherCode\":\"353\",\"weatherIconUrl\":[{\"value\":\"http://cdn.worldweatheronline.net/images/wsymbols01_png_64/wsymbol_0025_light_rain_showers_night.png\"}],\"weatherDesc\":[{\"value\":\"Light rain shower\"}],\"precipMM\":\"1.1\",\"precipInches\":\"0.0\",\"humidity\":\"87\",\"visibility\":\"10\",\"visibilityMiles\":\"6\",\"pressure\":\"1011\",\"pressureInches\":\"30\",\"cloudcover\":\"64\",\"HeatIndexC\":\"25\",\"HeatIndexF\":\"77\",\"DewPointC\":\"23\",\"DewPointF\":\"73\",\"WindChillC\":\"22\",\"WindChillF\":\"72\",\"WindGustMiles\":\"17\",\"WindGustKmph\":\"27\",\"FeelsLikeC\":\"25\",\"FeelsLikeF\":\"77\",\"chanceofrain\":\"74\",\"chanceofremdry\":\"0\",\"chanceofwindy\":\"0\",\"chanceofovercast\":\"86\",\"chanceofsunshine\":\"0\",\"chanceoffrost\":\"0\",\"chanceofhightemp\":\"99\",\"chanceoffog\":\"0\",\"chanceofsnow\":\"0\",\"chanceofthunder\":\"0\",\"uvIndex\":\"0\"},{\"time\":\"300\",\"tempC\":\"25\",\"tempF\":\"78\",\"windspeedMiles\":\"14\",\"windspeedKmph\":\"23\",\"winddirDegree\":\"13\",\"winddir16Point\":\"NNE\",\"weatherCode\":\"353\",\"weatherIconUrl\":[{\"value\":\"http://cdn.worldweatheronline.net/images/wsymbols01_png_64/wsymbol_0025_light_rain_showers_night.png\"}],\"weatherDesc\":[{\"value\":\"Light rain shower\"}],\"precipMM\":\"1.9\",\"precipInches\":\"0.1\",\"humidity\":\"87\",\"visibility\":\"10\",\"visibilityMiles\":\"6\",\"pressure\":\"1010\",\"pressureInches\":\"30\",\"cloudcover\":\"63\",\"HeatIndexC\":\"28\",\"HeatIndexF\":\"82\",\"DewPointC\":\"23\",\"DewPointF\":\"73\",\"WindChillC\":\"25\",\"WindChillF\":\"78\",\"WindGustMiles\":\"21\",\"WindGustKmph\":\"34\",\"FeelsLikeC\":\"28\",\"FeelsLikeF\":\"82\",\"chanceofrain\":\"59\",\"chanceofremdry\":\"0\",\"chanceofwindy\":\"0\",\"chanceofovercast\":\"82\",\"chanceofsunshine\":\"0\",\"chanceoffrost\":\"0\",\"chanceofhightemp\":\"98\",\"chanceoffog\":\"0\",\"chanceofsnow\":\"0\",\"chanceofthunder\":\"0\",\"uvIndex\":\"0\"},{\"time\":\"600\",\"tempC\":\"26\",\"tempF\":\"78\",\"windspeedMiles\":\"15\",\"windspeedKmph\":\"23\",\"winddirDegree\":\"16\",\"winddir16Point\":\"NNE\",\"weatherCode\":\"176\",\"weatherIconUrl\":[{\"value\":\"http://cdn.worldweatheronline.net/images/wsymbols01_png_64/wsymbol_0025_light_rain_showers_night.png\"}],\"weatherDesc\":[{\"value\":\"Patchy rain possible\"}],\"precipMM\":\"1.2\",\"precipInches\":\"0.0\",\"humidity\":\"85\",\"visibility\":\"10\",\"visibilityMiles\":\"6\",\"pressure\":\"1010\",\"pressureInches\":\"30\",\"cloudcover\":\"67\",\"HeatIndexC\":\"28\",\"HeatIndexF\":\"83\",\"DewPointC\":\"23\",\"DewPointF\":\"73\",\"WindChillC\":\"26\",\"WindChillF\":\"78\",\"WindGustMiles\":\"21\",\"WindGustKmph\":\"34\",\"FeelsLikeC\":\"28\",\"FeelsLikeF\":\"83\",\"chanceofrain\":\"71\",\"chanceofremdry\":\"0\",\"chanceofwindy\":\"0\",\"chanceofovercast\":\"87\",\"chanceofsunshine\":\"0\",\"chanceoffrost\":\"0\",\"chanceofhightemp\":\"99\",\"chanceoffog\":\"0\",\"chanceofsnow\":\"0\",\"chanceofthunder\":\"0\",\"uvIndex\":\"0\"},{\"time\":\"900\",\"tempC\":\"26\",\"tempF\":\"79\",\"windspeedMiles\":\"15\",\"windspeedKmph\":\"24\",\"winddirDegree\":\"19\",\"winddir16Point\":\"NNE\",\"weatherCode\":\"353\",\"weatherIconUrl\":[{\"value\":\"http://cdn.worldweatheronline.net/images/wsymbols01_png_64/wsymbol_0009_light_rain_showers.png\"}],\"weatherDesc\":[{\"value\":\"Light rain shower\"}],\"precipMM\":\"1.4\",\"precipInches\":\"0.1\",\"humidity\":\"81\",\"visibility\":\"9\",\"visibilityMiles\":\"5\",\"pressure\":\"1012\",\"pressureInches\":\"30\",\"cloudcover\":\"84\",\"HeatIndexC\":\"29\",\"HeatIndexF\":\"84\",\"DewPointC\":\"23\",\"DewPointF\":\"73\",\"WindChillC\":\"26\",\"WindChillF\":\"79\",\"WindGustMiles\":\"22\",\"WindGustKmph\":\"35\",\"FeelsLikeC\":\"29\",\"FeelsLikeF\":\"84\",\"chanceofrain\":\"62\",\"chanceofremdry\":\"0\",\"chanceofwindy\":\"0\",\"chanceofovercast\":\"93\",\"chanceofsunshine\":\"0\",\"chanceoffrost\":\"0\",\"chanceofhightemp\":\"98\",\"chanceoffog\":\"0\",\"chanceofsnow\":\"0\",\"chanceofthunder\":\"0\",\"uvIndex\":\"6\"},{\"time\":\"1200\",\"tempC\":\"28\",\"tempF\":\"82\",\"windspeedMiles\":\"14\",\"windspeedKmph\":\"23\",\"winddirDegree\":\"18\",\"winddir16Point\":\"NNE\",\"weatherCode\":\"176\",\"weatherIconUrl\":[{\"value\":\"http://cdn.worldweatheronline.net/images/wsymbols01_png_64/wsymbol_0009_light_rain_showers.png\"}],\"weatherDesc\":[{\"value\":\"Patchy rain possible\"}],\"precipMM\":\"0.3\",\"precipInches\":\"0.0\",\"humidity\":\"76\",\"visibility\":\"10\",\"visibilityMiles\":\"6\",\"pressure\":\"1012\",\"pressureInches\":\"30\",\"cloudcover\":\"93\",\"HeatIndexC\":\"31\",\"HeatIndexF\":\"88\",\"DewPointC\":\"23\",\"DewPointF\":\"73\",\"WindChillC\":\"28\",\"WindChillF\":\"82\",\"WindGustMiles\":\"19\",\"WindGustKmph\":\"31\",\"FeelsLikeC\":\"31\",\"FeelsLikeF\":\"88\",\"chanceofrain\":\"66\",\"chanceofremdry\":\"0\",\"chanceofwindy\":\"0\",\"chanceofovercast\":\"90\",\"chanceofsunshine\":\"0\",\"chanceoffrost\":\"0\",\"chanceofhightemp\":\"80\",\"chanceoffog\":\"0\",\"chanceofsnow\":\"0\",\"chanceofthunder\":\"0\",\"uvIndex\":\"6\"},{\"time\":\"1500\",\"tempC\":\"28\",\"tempF\":\"83\",\"windspeedMiles\":\"15\",\"windspeedKmph\":\"23\",\"winddirDegree\":\"23\",\"winddir16Point\":\"NNE\",\"weatherCode\":\"176\",\"weatherIconUrl\":[{\"value\":\"http://cdn.worldweatheronline.net/images/wsymbols01_png_64/wsymbol_0009_light_rain_showers.png\"}],\"weatherDesc\":[{\"value\":\"Patchy rain possible\"}],\"precipMM\":\"0.6\",\"precipInches\":\"0.0\",\"humidity\":\"73\",\"visibility\":\"9\",\"visibilityMiles\":\"5\",\"pressure\":\"1010\",\"pressureInches\":\"30\",\"cloudcover\":\"78\",\"HeatIndexC\":\"32\",\"HeatIndexF\":\"89\",\"DewPointC\":\"23\",\"DewPointF\":\"73\",\"WindChillC\":\"28\",\"WindChillF\":\"83\",\"WindGustMiles\":\"19\",\"WindGustKmph\":\"31\",\"FeelsLikeC\":\"32\",\"FeelsLikeF\":\"89\",\"chanceofrain\":\"73\",\"chanceofremdry\":\"0\",\"chanceofwindy\":\"0\",\"chanceofovercast\":\"85\",\"chanceofsunshine\":\"0\",\"chanceoffrost\":\"0\",\"chanceofhightemp\":\"48\",\"chanceoffog\":\"0\",\"chanceofsnow\":\"0\",\"chanceofthunder\":\"0\",\"uvIndex\":\"6\"},{\"time\":\"1800\",\"tempC\":\"28\",\"tempF\":\"82\",\"windspeedMiles\":\"15\",\"windspeedKmph\":\"24\",\"winddirDegree\":\"22\",\"winddir16Point\":\"NNE\",\"weatherCode\":\"176\",\"weatherIconUrl\":[{\"value\":\"http://cdn.worldweatheronline.net/images/wsymbols01_png_64/wsymbol_0009_light_rain_showers.png\"}],\"weatherDesc\":[{\"value\":\"Patchy rain possible\"}],\"precipMM\":\"0.7\",\"precipInches\":\"0.0\",\"humidity\":\"74\",\"visibility\":\"9\",\"visibilityMiles\":\"5\",\"pressure\":\"1009\",\"pressureInches\":\"30\",\"cloudcover\":\"81\",\"HeatIndexC\":\"31\",\"HeatIndexF\":\"87\",\"DewPointC\":\"23\",\"DewPointF\":\"73\",\"WindChillC\":\"28\",\"WindChillF\":\"82\",\"WindGustMiles\":\"21\",\"WindGustKmph\":\"33\",\"FeelsLikeC\":\"31\",\"FeelsLikeF\":\"87\",\"chanceofrain\":\"77\",\"chanceofremdry\":\"0\",\"chanceofwindy\":\"0\",\"chanceofovercast\":\"86\",\"chanceofsunshine\":\"0\",\"chanceoffrost\":\"0\",\"chanceofhightemp\":\"45\",\"chanceoffog\":\"0\",\"chanceofsnow\":\"0\",\"chanceofthunder\":\"0\",\"uvIndex\":\"6\"},{\"time\":\"2100\",\"tempC\":\"26\",\"tempF\":\"79\",\"windspeedMiles\":\"16\",\"windspeedKmph\":\"25\",\"winddirDegree\":\"17\",\"winddir16Point\":\"NNE\",\"weatherCode\":\"116\",\"weatherIconUrl\":[{\"value\":\"http://cdn.worldweatheronline.net/images/wsymbols01_png_64/wsymbol_0004_black_low_cloud.png\"}],\"weatherDesc\":[{\"value\":\"Partly cloudy\"}],\"precipMM\":\"0.5\",\"precipInches\":\"0.0\",\"humidity\":\"78\",\"visibility\":\"9\",\"visibilityMiles\":\"5\",\"pressure\":\"1011\",\"pressureInches\":\"30\",\"cloudcover\":\"75\",\"HeatIndexC\":\"29\",\"HeatIndexF\":\"84\",\"DewPointC\":\"22\",\"DewPointF\":\"72\",\"WindChillC\":\"26\",\"WindChillF\":\"79\",\"WindGustMiles\":\"23\",\"WindGustKmph\":\"36\",\"FeelsLikeC\":\"29\",\"FeelsLikeF\":\"84\",\"chanceofrain\":\"51\",\"chanceofremdry\":\"29\",\"chanceofwindy\":\"0\",\"chanceofovercast\":\"68\",\"chanceofsunshine\":\"28\",\"chanceoffrost\":\"0\",\"chanceofhightemp\":\"40\",\"chanceoffog\":\"0\",\"chanceofsnow\":\"0\",\"chanceofthunder\":\"0\",\"uvIndex\":\"0\"}]}],\"ClimateAverages\":[{\"month\":[{\"index\":\"1\",\"name\":\"January\",\"avgMinTemp\":\"24.8\",\"avgMinTemp_F\":\"76.7\",\"avgMaxTemp\":\"29.5\",\"avgMaxTemp_F\":\"85.1\",\"absMinTemp\":\"24.0\",\"absMinTemp_F\":\"75.2\",\"absMaxTemp\":\"31.00194\",\"absMaxTemp_F\":\"87.8\",\"avgTemp\":\"26.7\",\"avgTemp_F\":\"80.1\",\"maxWindSpeed_kmph\":\"12.3\",\"maxWindSpeed_mph\":\"7.6\",\"maxWindSpeed_knots\":\"6.0\",\"maxWindSpeed_ms\":\"3.4\",\"avgWindSpeed_kmph\":\"12.0\",\"avgWindSpeed_mph\":\"7.4\",\"avgWindSpeed_knots\":\"6.0\",\"avgWindSpeed_ms\":\"3.3\",\"avgWindGust_kmph\":\"17.5\",\"avgWindGust_mph\":\"10.9\",\"avgWindGust_knots\":\"9.0\",\"avgWindGust_ms\":\"4.9\",\"avgDailyRainfall\":\"4.62\",\"avgDailyRainfall_inch\":\"0.18\",\"avgMonthlyRainfall\":\"143.09\",\"avgMonthlyRainfall_inch\":\"5.63\",\"avgHumidity\":\"80.17609\",\"avgCloud\":\"47.25156\",\"avgVis_km\":\"9.4\",\"avgVis_miles\":\"5.0\",\"avgPressure_mb\":\"1010.1\",\"avgPressure_inch\":\"30.3\",\"avgDryDays\":\"3\",\"avgRainDays\":\"26\",\"avgSnowDays\":\"0\",\"avgFogDays\":\"0\",\"avgThunderDays\":\"3\",\"avgUVIndex\":\"7\",\"avgSunHour\":\"228.4\"},{\"index\":\"2\",\"name\":\"February\",\"avgMinTemp\":\"24.8\",\"avgMinTemp_F\":\"76.6\",\"avgMaxTemp\":\"30.2\",\"avgMaxTemp_F\":\"86.4\",\"absMinTemp\":\"24.2\",\"absMinTemp_F\":\"75.5\",\"absMaxTemp\":\"31.15357\",\"absMaxTemp_F\":\"88.1\",\"avgTemp\":\"27.0\",\"avgTemp_F\":\"80.6\",\"maxWindSpeed_kmph\":\"12.4\",\"maxWindSpeed_mph\":\"7.7\",\"maxWindSpeed_knots\":\"6.0\",\"maxWindSpeed_ms\":\"3.4\",\"avgWindSpeed_kmph\":\"11.9\",\"avgWindSpeed_mph\":\"7.4\",\"avgWindSpeed_knots\":\"6.0\",\"avgWindSpeed_ms\":\"3.3\",\"avgWindGust_kmph\":\"16.9\",\"avgWindGust_mph\":\"10.5\",\"avgWindGust_knots\":\"9.0\",\"avgWindGust_ms\":\"4.7\",\"avgDailyRainfall\":\"2.55\",\"avgDailyRainfall_inch\":\"0.10\",\"avgMonthlyRainfall\":\"71.54\",\"avgMonthlyRainfall_inch\":\"2.82\",\"avgHumidity\":\"78.50024\",\"avgCloud\":\"42.58316\",\"avgVis_km\":\"9.8\",\"avgVis_miles\":\"6.0\",\"avgPressure_mb\":\"1010.2\",\"avgPressure_inch\":\"30.3\",\"avgDryDays\":\"5\",\"avgRainDays\":\"21\",\"avgSnowDays\":\"0\",\"avgFogDays\":\"0\",\"avgThunderDays\":\"1\",\"avgUVIndex\":\"7\",\"avgSunHour\":\"225.5\"},{\"index\":\"3\",\"name\":\"March\",\"avgMinTemp\":\"25.3\",\"avgMinTemp_F\":\"77.5\",\"avgMaxTemp\":\"31.1\",\"avgMaxTemp_F\":\"88.0\",\"absMinTemp\":\"24.1\",\"absMinTemp_F\":\"75.3\",\"absMaxTemp\":\"32.2129\",\"absMaxTemp_F\":\"90.0\",\"avgTemp\":\"27.7\",\"avgTemp_F\":\"81.8\",\"maxWindSpeed_kmph\":\"9.6\",\"maxWindSpeed_mph\":\"5.9\",\"maxWindSpeed_knots\":\"5.0\",\"maxWindSpeed_ms\":\"2.7\",\"avgWindSpeed_kmph\":\"9.1\",\"avgWindSpeed_mph\":\"5.7\",\"avgWindSpeed_knots\":\"4.0\",\"avgWindSpeed_ms\":\"2.5\",\"avgWindGust_kmph\":\"13.1\",\"avgWindGust_mph\":\"8.1\",\"avgWindGust_knots\":\"7.0\",\"avgWindGust_ms\":\"3.6\",\"avgDailyRainfall\":\"3.82\",\"avgDailyRainfall_inch\":\"0.15\",\"avgMonthlyRainfall\":\"118.27\",\"avgMonthlyRainfall_inch\":\"4.66\",\"avgHumidity\":\"78.36234\",\"avgCloud\":\"38.07989\",\"avgVis_km\":\"9.5\",\"avgVis_miles\":\"5.0\",\"avgPressure_mb\":\"1009.9\",\"avgPressure_inch\":\"30.3\",\"avgDryDays\":\"3\",\"avgRainDays\":\"26\",\"avgSnowDays\":\"0\",\"avgFogDays\":\"1\",\"avgThunderDays\":\"2\",\"avgUVIndex\":\"7\",\"avgSunHour\":\"263.5\"},{\"index\":\"4\",\"name\":\"April\",\"avgMinTemp\":\"26.0\",\"avgMinTemp_F\":\"78.8\",\"avgMaxTemp\":\"31.6\",\"avgMaxTemp_F\":\"89.0\",\"absMinTemp\":\"25.0\",\"absMinTemp_F\":\"76.9\",\"absMaxTemp\":\"32.81\",\"absMaxTemp_F\":\"91.1\",\"avgTemp\":\"28.4\",\"avgTemp_F\":\"83.1\",\"maxWindSpeed_kmph\":\"6.9\",\"maxWindSpeed_mph\":\"4.3\",\"maxWindSpeed_knots\":\"3.0\",\"maxWindSpeed_ms\":\"1.9\",\"avgWindSpeed_kmph\":\"6.5\",\"avgWindSpeed_mph\":\"4.0\",\"avgWindSpeed_knots\":\"3.0\",\"avgWindSpeed_ms\":\"1.8\",\"avgWindGust_kmph\":\"9.4\",\"avgWindGust_mph\":\"5.8\",\"avgWindGust_knots\":\"5.0\",\"avgWindGust_ms\":\"2.6\",\"avgDailyRainfall\":\"5.00\",\"avgDailyRainfall_inch\":\"0.20\",\"avgMonthlyRainfall\":\"150.13\",\"avgMonthlyRainfall_inch\":\"5.91\",\"avgHumidity\":\"77.41489\",\"avgCloud\":\"36.18729\",\"avgVis_km\":\"9.3\",\"avgVis_miles\":\"5.0\",\"avgPressure_mb\":\"1009.1\",\"avgPressure_inch\":\"30.3\",\"avgDryDays\":\"2\",\"avgRainDays\":\"27\",\"avgSnowDays\":\"0\",\"avgFogDays\":\"0\",\"avgThunderDays\":\"5\",\"avgUVIndex\":\"7\",\"avgSunHour\":\"260.7\"},{\"index\":\"5\",\"name\":\"May\",\"avgMinTemp\":\"26.5\",\"avgMinTemp_F\":\"79.7\",\"avgMaxTemp\":\"31.9\",\"avgMaxTemp_F\":\"89.4\",\"absMinTemp\":\"25.1\",\"absMinTemp_F\":\"77.1\",\"absMaxTemp\":\"32.7842\",\"absMaxTemp_F\":\"91.0\",\"avgTemp\":\"28.9\",\"avgTemp_F\":\"84.0\",\"maxWindSpeed_kmph\":\"7.0\",\"maxWindSpeed_mph\":\"4.3\",\"maxWindSpeed_knots\":\"3.0\",\"maxWindSpeed_ms\":\"1.9\",\"avgWindSpeed_kmph\":\"6.6\",\"avgWindSpeed_mph\":\"4.1\",\"avgWindSpeed_knots\":\"3.0\",\"avgWindSpeed_ms\":\"1.8\",\"avgWindGust_kmph\":\"9.3\",\"avgWindGust_mph\":\"5.8\",\"avgWindGust_knots\":\"5.0\",\"avgWindGust_ms\":\"2.6\",\"avgDailyRainfall\":\"3.79\",\"avgDailyRainfall_inch\":\"0.15\",\"avgMonthlyRainfall\":\"117.63\",\"avgMonthlyRainfall_inch\":\"4.63\",\"avgHumidity\":\"75.90937\",\"avgCloud\":\"33.80396\",\"avgVis_km\":\"9.4\",\"avgVis_miles\":\"5.0\",\"avgPressure_mb\":\"1008.6\",\"avgPressure_inch\":\"30.3\",\"avgDryDays\":\"3\",\"avgRainDays\":\"26\",\"avgSnowDays\":\"0\",\"avgFogDays\":\"0\",\"avgThunderDays\":\"6\",\"avgUVIndex\":\"7\",\"avgSunHour\":\"274.3\"},{\"index\":\"6\",\"name\":\"June\",\"avgMinTemp\":\"26.3\",\"avgMinTemp_F\":\"79.4\",\"avgMaxTemp\":\"31.5\",\"avgMaxTemp_F\":\"88.7\",\"absMinTemp\":\"25.0\",\"absMinTemp_F\":\"77.0\",\"absMaxTemp\":\"32.43697\",\"absMaxTemp_F\":\"90.4\",\"avgTemp\":\"28.6\",\"avgTemp_F\":\"83.5\",\"maxWindSpeed_kmph\":\"8.7\",\"maxWindSpeed_mph\":\"5.4\",\"maxWindSpeed_knots\":\"4.0\",\"maxWindSpeed_ms\":\"2.4\",\"avgWindSpeed_kmph\":\"8.4\",\"avgWindSpeed_mph\":\"5.2\",\"avgWindSpeed_knots\":\"4.0\",\"avgWindSpeed_ms\":\"2.3\",\"avgWindGust_kmph\":\"11.9\",\"avgWindGust_mph\":\"7.4\",\"avgWindGust_knots\":\"6.0\",\"avgWindGust_ms\":\"3.3\",\"avgDailyRainfall\":\"3.06\",\"avgDailyRainfall_inch\":\"0.12\",\"avgMonthlyRainfall\":\"91.90\",\"avgMonthlyRainfall_inch\":\"3.62\",\"avgHumidity\":\"75.08685\",\"avgCloud\":\"33.21437\",\"avgVis_km\":\"9.7\",\"avgVis_miles\":\"6.0\",\"avgPressure_mb\":\"1008.8\",\"avgPressure_inch\":\"30.3\",\"avgDryDays\":\"4\",\"avgRainDays\":\"23\",\"avgSnowDays\":\"0\",\"avgFogDays\":\"0\",\"avgThunderDays\":\"5\",\"avgUVIndex\":\"7\",\"avgSunHour\":\"263.8\"},{\"index\":\"7\",\"name\":\"July\",\"avgMinTemp\":\"26.1\",\"avgMinTemp_F\":\"79.1\",\"avgMaxTemp\":\"31.0\",\"avgMaxTemp_F\":\"87.9\",\"absMinTemp\":\"24.7\",\"absMinTemp_F\":\"76.5\",\"absMaxTemp\":\"32.18419\",\"absMaxTemp_F\":\"89.9\",\"avgTemp\":\"28.3\",\"avgTemp_F\":\"82.9\",\"maxWindSpeed_kmph\":\"9.9\",\"maxWindSpeed_mph\":\"6.2\",\"maxWindSpeed_knots\":\"5.0\",\"maxWindSpeed_ms\":\"2.8\",\"avgWindSpeed_kmph\":\"9.7\",\"avgWindSpeed_mph\":\"6.0\",\"avgWindSpeed_knots\":\"5.0\",\"avgWindSpeed_ms\":\"2.7\",\"avgWindGust_kmph\":\"13.5\",\"avgWindGust_mph\":\"8.4\",\"avgWindGust_knots\":\"7.0\",\"avgWindGust_ms\":\"3.7\",\"avgDailyRainfall\":\"2.18\",\"avgDailyRainfall_inch\":\"0.09\",\"avgMonthlyRainfall\":\"67.56\",\"avgMonthlyRainfall_inch\":\"2.66\",\"avgHumidity\":\"75.0941\",\"avgCloud\":\"33.85191\",\"avgVis_km\":\"9.6\",\"avgVis_miles\":\"5.0\",\"avgPressure_mb\":\"1009.0\",\"avgPressure_inch\":\"30.3\",\"avgDryDays\":\"4\",\"avgRainDays\":\"24\",\"avgSnowDays\":\"0\",\"avgFogDays\":\"1\",\"avgThunderDays\":\"3\",\"avgUVIndex\":\"7\",\"avgSunHour\":\"270.6\"},{\"index\":\"8\",\"name\":\"August\",\"avgMinTemp\":\"26.2\",\"avgMinTemp_F\":\"79.2\",\"avgMaxTemp\":\"31.1\",\"avgMaxTemp_F\":\"87.9\",\"absMinTemp\":\"24.8\",\"absMinTemp_F\":\"76.6\",\"absMaxTemp\":\"32.61948\",\"absMaxTemp_F\":\"90.7\",\"avgTemp\":\"28.3\",\"avgTemp_F\":\"83.0\",\"maxWindSpeed_kmph\":\"10.2\",\"maxWindSpeed_mph\":\"6.4\",\"maxWindSpeed_knots\":\"5.0\",\"maxWindSpeed_ms\":\"2.8\",\"avgWindSpeed_kmph\":\"10.0\",\"avgWindSpeed_mph\":\"6.2\",\"avgWindSpeed_knots\":\"5.0\",\"avgWindSpeed_ms\":\"2.8\",\"avgWindGust_kmph\":\"13.8\",\"avgWindGust_mph\":\"8.6\",\"avgWindGust_knots\":\"7.0\",\"avgWindGust_ms\":\"3.8\",\"avgDailyRainfall\":\"2.57\",\"avgDailyRainfall_inch\":\"0.10\",\"avgMonthlyRainfall\":\"79.75\",\"avgMonthlyRainfall_inch\":\"3.14\",\"avgHumidity\":\"73.81284\",\"avgCloud\":\"33.56141\",\"avgVis_km\":\"9.7\",\"avgVis_miles\":\"6.0\",\"avgPressure_mb\":\"1009.3\",\"avgPressure_inch\":\"30.3\",\"avgDryDays\":\"2\",\"avgRainDays\":\"26\",\"avgSnowDays\":\"0\",\"avgFogDays\":\"0\",\"avgThunderDays\":\"2\",\"avgUVIndex\":\"7\",\"avgSunHour\":\"269.9\"},{\"index\":\"9\",\"name\":\"September\",\"avgMinTemp\":\"25.8\",\"avgMinTemp_F\":\"78.4\",\"avgMaxTemp\":\"31.2\",\"avgMaxTemp_F\":\"88.2\",\"absMinTemp\":\"24.7\",\"absMinTemp_F\":\"76.5\",\"absMaxTemp\":\"32.9179\",\"absMaxTemp_F\":\"91.3\",\"avgTemp\":\"28.3\",\"avgTemp_F\":\"82.9\",\"maxWindSpeed_kmph\":\"9.1\",\"maxWindSpeed_mph\":\"5.7\",\"maxWindSpeed_knots\":\"4.0\",\"maxWindSpeed_ms\":\"2.5\",\"avgWindSpeed_kmph\":\"8.7\",\"avgWindSpeed_mph\":\"5.4\",\"avgWindSpeed_knots\":\"4.0\",\"avgWindSpeed_ms\":\"2.4\",\"avgWindGust_kmph\":\"12.0\",\"avgWindGust_mph\":\"7.5\",\"avgWindGust_knots\":\"6.0\",\"avgWindGust_ms\":\"3.3\",\"avgDailyRainfall\":\"2.40\",\"avgDailyRainfall_inch\":\"0.09\",\"avgMonthlyRainfall\":\"71.86\",\"avgMonthlyRainfall_inch\":\"2.83\",\"avgHumidity\":\"73.06735\",\"avgCloud\":\"33.44964\",\"avgVis_km\":\"9.7\",\"avgVis_miles\":\"6.0\",\"avgPressure_mb\":\"1009.6\",\"avgPressure_inch\":\"30.3\",\"avgDryDays\":\"5\",\"avgRainDays\":\"24\",\"avgSnowDays\":\"0\",\"avgFogDays\":\"0\",\"avgThunderDays\":\"3\",\"avgUVIndex\":\"7\",\"avgSunHour\":\"265.4\"},{\"index\":\"10\",\"name\":\"October\",\"avgMinTemp\":\"26.1\",\"avgMinTemp_F\":\"79.0\",\"avgMaxTemp\":\"31.5\",\"avgMaxTemp_F\":\"88.8\",\"absMinTemp\":\"24.5\",\"absMinTemp_F\":\"76.2\",\"absMaxTemp\":\"33.09821\",\"absMaxTemp_F\":\"91.6\",\"avgTemp\":\"28.6\",\"avgTemp_F\":\"83.4\",\"maxWindSpeed_kmph\":\"8.2\",\"maxWindSpeed_mph\":\"5.1\",\"maxWindSpeed_knots\":\"4.0\",\"maxWindSpeed_ms\":\"2.3\",\"avgWindSpeed_kmph\":\"7.4\",\"avgWindSpeed_mph\":\"4.6\",\"avgWindSpeed_knots\":\"3.0\",\"avgWindSpeed_ms\":\"2.1\",\"avgWindGust_kmph\":\"10.4\",\"avgWindGust_mph\":\"6.5\",\"avgWindGust_knots\":\"5.0\",\"avgWindGust_ms\":\"2.9\",\"avgDailyRainfall\":\"4.21\",\"avgDailyRainfall_inch\":\"0.17\",\"avgMonthlyRainfall\":\"130.40\",\"avgMonthlyRainfall_inch\":\"5.13\",\"avgHumidity\":\"73.094\",\"avgCloud\":\"37.19652\",\"avgVis_km\":\"9.5\",\"avgVis_miles\":\"5.0\",\"avgPressure_mb\":\"1009.4\",\"avgPressure_inch\":\"30.3\",\"avgDryDays\":\"4\",\"avgRainDays\":\"26\",\"avgSnowDays\":\"0\",\"avgFogDays\":\"0\",\"avgThunderDays\":\"3\",\"avgUVIndex\":\"7\",\"avgSunHour\":\"263.8\"},{\"index\":\"11\",\"name\":\"November\",\"avgMinTemp\":\"25.8\",\"avgMinTemp_F\":\"78.4\",\"avgMaxTemp\":\"30.7\",\"avgMaxTemp_F\":\"87.3\",\"absMinTemp\":\"24.5\",\"absMinTemp_F\":\"76.1\",\"absMaxTemp\":\"32.2203\",\"absMaxTemp_F\":\"90.0\",\"avgTemp\":\"27.9\",\"avgTemp_F\":\"82.3\",\"maxWindSpeed_kmph\":\"8.0\",\"maxWindSpeed_mph\":\"5.0\",\"maxWindSpeed_knots\":\"4.0\",\"maxWindSpeed_ms\":\"2.2\",\"avgWindSpeed_kmph\":\"7.2\",\"avgWindSpeed_mph\":\"4.5\",\"avgWindSpeed_knots\":\"3.0\",\"avgWindSpeed_ms\":\"2.0\",\"avgWindGust_kmph\":\"10.7\",\"avgWindGust_mph\":\"6.7\",\"avgWindGust_knots\":\"5.0\",\"avgWindGust_ms\":\"3.0\",\"avgDailyRainfall\":\"6.75\",\"avgDailyRainfall_inch\":\"0.27\",\"avgMonthlyRainfall\":\"202.35\",\"avgMonthlyRainfall_inch\":\"7.97\",\"avgHumidity\":\"77.7205\",\"avgCloud\":\"48.81529\",\"avgVis_km\":\"9.3\",\"avgVis_miles\":\"5.0\",\"avgPressure_mb\":\"1008.8\",\"avgPressure_inch\":\"30.3\",\"avgDryDays\":\"1\",\"avgRainDays\":\"29\",\"avgSnowDays\":\"0\",\"avgFogDays\":\"0\",\"avgThunderDays\":\"4\",\"avgUVIndex\":\"7\",\"avgSunHour\":\"218.9\"},{\"index\":\"12\",\"name\":\"December\",\"avgMinTemp\":\"25.2\",\"avgMinTemp_F\":\"77.4\",\"avgMaxTemp\":\"29.8\",\"avgMaxTemp_F\":\"85.7\",\"absMinTemp\":\"24.3\",\"absMinTemp_F\":\"75.7\",\"absMaxTemp\":\"31.0129\",\"absMaxTemp_F\":\"87.8\",\"avgTemp\":\"27.1\",\"avgTemp_F\":\"80.9\",\"maxWindSpeed_kmph\":\"9.9\",\"maxWindSpeed_mph\":\"6.2\",\"maxWindSpeed_knots\":\"5.0\",\"maxWindSpeed_ms\":\"2.8\",\"avgWindSpeed_kmph\":\"9.6\",\"avgWindSpeed_mph\":\"6.0\",\"avgWindSpeed_knots\":\"5.0\",\"avgWindSpeed_ms\":\"2.7\",\"avgWindGust_kmph\":\"14.4\",\"avgWindGust_mph\":\"9.0\",\"avgWindGust_knots\":\"7.0\",\"avgWindGust_ms\":\"4.0\",\"avgDailyRainfall\":\"7.05\",\"avgDailyRainfall_inch\":\"0.28\",\"avgMonthlyRainfall\":\"218.65\",\"avgMonthlyRainfall_inch\":\"8.61\",\"avgHumidity\":\"81.06682\",\"avgCloud\":\"50.00068\",\"avgVis_km\":\"9.2\",\"avgVis_miles\":\"5.0\",\"avgPressure_mb\":\"1009.2\",\"avgPressure_inch\":\"30.3\",\"avgDryDays\":\"1\",\"avgRainDays\":\"30\",\"avgSnowDays\":\"0\",\"avgFogDays\":\"1\",\"avgThunderDays\":\"4\",\"avgUVIndex\":\"7\",\"avgSunHour\":\"217.8\"}]}]}}"

    @Test
    fun test_parse_weather_data_with_correct_data() {

        var json = JSONObject(test)

        var weatherBean = WeatherBean()
        weatherBean.parse(json)

        assert(weatherBean.current_condition != null)
        assert(weatherBean?.weather != null)
    }


    @Test
    fun test_parse_weather_data_with_no_weather_condition() {

        var json = JSONObject(test)
        json.optJSONObject("data").remove("current_condition")

        var weatherBean = WeatherBean()
        weatherBean.parse(json)

        assert(weatherBean.current_condition == null)
        assert(weatherBean?.weather != null)
    }


    @Test
    fun test_parse_weather_data_with_no_weather() {


        var json = JSONObject(test)
        json.optJSONObject("data").remove("weather")

        var weatherBean = WeatherBean()
        weatherBean.parse(json)

        assert(weatherBean.current_condition != null)
        assert(weatherBean?.weather == null)
    }


    @Test
    fun test_parse_weather_data_with_empty_data() {

        var test = "{}"

        var json = JSONObject(test)

        var weatherBean = WeatherBean()
        weatherBean.parse(json)

        assert(weatherBean.current_condition == null)
        assert(weatherBean?.weather == null)
    }
}