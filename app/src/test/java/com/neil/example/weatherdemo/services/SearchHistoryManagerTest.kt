package com.neil.example.weatherdemo.services

import com.neil.example.weatherdemo.RoboApp
import com.neil.example.weatherdemo.beans.SearchLocationListBean
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = RoboApp::class)
class SearchHistoryManagerTest {

    @Before
    fun setup() {
        SearchHistoryManager.init(RuntimeEnvironment.application.applicationContext)
        SearchHistoryManager.reset()
    }

    @Test
    fun test_default_search_history_list() {
        assert(SearchHistoryManager.getSearchHistory().searchResultList.isEmpty())
    }

    @Test
    fun test_insert_same_element_multiple_times() {
        SearchHistoryManager.reset()
        var city = SearchLocationListBean.SearchLocaitonItem()
        city.areaName = "xian"
        city.country = "china"
        city.region = "china"

        SearchHistoryManager.insertNewHistory(city)
        assert(SearchHistoryManager.getSearchHistory().searchResultList.size ==1)

        SearchHistoryManager.insertNewHistory(city)
        assert(SearchHistoryManager.getSearchHistory().searchResultList.size ==1)
        SearchHistoryManager.insertNewHistory(city)
        assert(SearchHistoryManager.getSearchHistory().searchResultList.size ==1)
        SearchHistoryManager.reset()
    }

    @Test
    fun test_insert_different_element_multiple_times() {
        var city = SearchLocationListBean.SearchLocaitonItem()
        city.areaName = "xian"
        city.country = "china"
        city.region = "china"
        SearchHistoryManager.insertNewHistory(city)

        var city2 = SearchLocationListBean.SearchLocaitonItem()
        city2.areaName = "xian_1"
        city2.country = "china_1"
        city2.region = "china_1"
        SearchHistoryManager.insertNewHistory(city2)

        var city3 = SearchLocationListBean.SearchLocaitonItem()
        city3.areaName = "xian_2"
        city3.country = "china_2"
        city3.region = "china_2"
        SearchHistoryManager.insertNewHistory(city3)

        assert("xian_2".equals(SearchHistoryManager.getSearchHistory().searchResultList[0].areaName))
        assert("xian_1".equals(SearchHistoryManager.getSearchHistory().searchResultList[1].areaName))
        assert("xian".equals(SearchHistoryManager.getSearchHistory().searchResultList[2].areaName))

        SearchHistoryManager.insertNewHistory(city)
        assert("xian".equals(SearchHistoryManager.getSearchHistory().searchResultList[0].areaName))

        SearchHistoryManager.reset()
    }

    @Test
    fun test_load_data_from_file() {

        var city = SearchLocationListBean.SearchLocaitonItem()
        city.areaName = "xian"
        city.country = "china"
        city.region = "china"
        SearchHistoryManager.insertNewHistory(city)

        var city2 = SearchLocationListBean.SearchLocaitonItem()
        city2.areaName = "xian_1"
        city2.country = "china_1"
        city2.region = "china_1"
        SearchHistoryManager.insertNewHistory(city2)

        var city3 = SearchLocationListBean.SearchLocaitonItem()
        city3.areaName = "xian_2"
        city3.country = "china_2"
        city3.region = "china_2"
        SearchHistoryManager.insertNewHistory(city3)

        SearchHistoryManager.loadFromFile()
        assert("xian_2".equals(SearchHistoryManager.getSearchHistory().searchResultList[0].areaName))
        assert("xian_1".equals(SearchHistoryManager.getSearchHistory().searchResultList[1].areaName))
        assert("xian".equals(SearchHistoryManager.getSearchHistory().searchResultList[2].areaName))
        SearchHistoryManager.reset()
    }

    @Test
    fun test_load_data_insert_data_greater_than_10() {
        SearchHistoryManager.reset()
        for (i in 0 until 20) {
            var city = SearchLocationListBean.SearchLocaitonItem()
            city.areaName = "xian$i"
            city.country = "china$i"
            city.region = "china$i"
            SearchHistoryManager.insertNewHistory(city)
        }
        assert(SearchHistoryManager.getSearchHistory().searchResultList.size == 10)
        SearchHistoryManager.reset()
    }
}