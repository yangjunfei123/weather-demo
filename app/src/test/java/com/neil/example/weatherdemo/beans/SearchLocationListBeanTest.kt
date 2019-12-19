package com.neil.example.weatherdemo.beans

import com.neil.example.weatherdemo.RoboApp
import com.neil.example.weatherdemo.network.HttpDataConvert
import org.json.JSONObject
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = RoboApp::class)
class SearchLocationListBeanTest {

    @Test
    fun test_parse_data_from_array_with_one_value_in_array() {
        var test = "{\"areaName\":[\n" +
                "{\n" +
                "\"value\":\"London\"\n" +
                "}\n" +
                "]}"

        var obj = JSONObject(test)

        var searchResultBean = SearchLocationListBean()
        var result = HttpDataConvert.parseDataFromArray(obj, "areaName", "value")
        assert(result.equals("London"))
    }

    @Test
    fun test_parse_data_from_array_with_no_value_in_array() {
        var test = "{\"areaName\":[\n" +
                "{\n" +
                "}\n" +
                "]}"

        var obj = JSONObject(test)

        var searchResultBean = SearchLocationListBean()
        var result = HttpDataConvert.parseDataFromArray(obj, "areaName", "value")
        assert(result.isEmpty())
    }

    @Test
    fun test_parse_data_from_array_with_two_value_in_array() {
        var test = "{\"areaName\":[\n" +
                "{\n" +
                "\"value\":\"London2\",\n" +
                "\"value\":\"fewfwfewfwe\"\n" +
                "}\n" +
                "]}"

        var obj = JSONObject(test)

        var searchResultBean = SearchLocationListBean()
        var result = HttpDataConvert.parseDataFromArray(obj, "areaName", "value")
        assert(result.equals("fewfwfewfwe"))
    }

    @Test
    fun test_parse_data_from_array_with_two_value_in_array_with_diff_key() {
        var test = "{\"areaName\":[\n" +
                "{\n" +
                "\"msg\":\"London2\",\n" +
                "\"value\":\"fewfwfewfwe\"\n" +
                "}\n" +
                "]}"

        var obj = JSONObject(test)

        var searchResultBean = SearchLocationListBean()
        var result = HttpDataConvert.parseDataFromArray(obj, "areaName", "msg")
        assert(result.equals("London2"))
    }

    @Test
    fun test_parse_data_from_array_with_object() {
        var test = "{\"areaName\":\"London\"}"

        var obj = JSONObject(test)

        var searchResultBean = SearchLocationListBean()
        var result = HttpDataConvert.parseDataFromArray(obj, "areaName", "value")
        assert(result.equals("London"))
    }

    @Test
    fun test_parse_data_from_array_with_wrong_value() {
        var test = "{\"areaName\":\"London\"}"

        var obj = JSONObject(test)

        var searchResultBean = SearchLocationListBean()
        var result = HttpDataConvert.parseDataFromArray(obj, "areaName111", "value")
        assert(result.isEmpty())
    }

    @Test
    fun test_parse_search_result_list() {
        var test = "{\"search_api\":{\"result\":[{\"areaName\":[{\"value\":\"London\"}],\"country\":[{\"value\":\"United Kingdom\"}],\"region\":[{\"value\":\"City of London, Greater London\"}],\"latitude\":\"51.517\",\"longitude\":\"-0.106\",\"population\":\"7421228\",\"weatherUrl\":[{\"value\":\"https://www.worldweatheronline.com/v2/weather.aspx?q=51.5171,-0.1062\"}]},{\"areaName\":[{\"value\":\"London\"}],\"country\":[{\"value\":\"Canada\"}],\"region\":[{\"value\":\"Ontario\"}],\"latitude\":\"42.983\",\"longitude\":\"-81.250\",\"population\":\"346765\",\"weatherUrl\":[{\"value\":\"https://www.worldweatheronline.com/v2/weather.aspx?q=42.9833,-81.25\"}]},{\"areaName\":[{\"value\":\"Londonderry\"}],\"country\":[{\"value\":\"United States of America\"}],\"region\":[{\"value\":\"New Hampshire\"}],\"latitude\":\"42.865\",\"longitude\":\"-71.374\",\"population\":\"24474\",\"weatherUrl\":[{\"value\":\"https://www.worldweatheronline.com/v2/weather.aspx?q=42.865,-71.3744\"}]}]}}"

        var json = JSONObject(test);
        var searchResultBean = SearchLocationListBean()
        searchResultBean.parse(json)
        assert(searchResultBean.searchResultList.size ==3)
    }

    @Test
    fun test_parse_search_result_list_without_result() {
        var test = "{\"search_api\":{\"resultaaaa\":[{\"areaName\":[{\"value\":\"London\"}],\"country\":[{\"value\":\"United Kingdom\"}],\"region\":[{\"value\":\"City of London, Greater London\"}],\"latitude\":\"51.517\",\"longitude\":\"-0.106\",\"population\":\"7421228\",\"weatherUrl\":[{\"value\":\"https://www.worldweatheronline.com/v2/weather.aspx?q=51.5171,-0.1062\"}]},{\"areaName\":[{\"value\":\"London\"}],\"country\":[{\"value\":\"Canada\"}],\"region\":[{\"value\":\"Ontario\"}],\"latitude\":\"42.983\",\"longitude\":\"-81.250\",\"population\":\"346765\",\"weatherUrl\":[{\"value\":\"https://www.worldweatheronline.com/v2/weather.aspx?q=42.9833,-81.25\"}]},{\"areaName\":[{\"value\":\"Londonderry\"}],\"country\":[{\"value\":\"United States of America\"}],\"region\":[{\"value\":\"New Hampshire\"}],\"latitude\":\"42.865\",\"longitude\":\"-71.374\",\"population\":\"24474\",\"weatherUrl\":[{\"value\":\"https://www.worldweatheronline.com/v2/weather.aspx?q=42.865,-71.3744\"}]}]}}"

        var json = JSONObject(test);
        var searchResultBean = SearchLocationListBean()
        searchResultBean.parse(json)
        assert(searchResultBean.searchResultList.size ==0)
    }
}