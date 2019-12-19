package com.neil.example.weatherdemo.ui

import android.content.Context
import android.text.TextUtils
import com.neil.example.weatherdemo.beans.SearchLocationListBean
import com.neil.example.weatherdemo.network.HttpCallback
import com.neil.example.weatherdemo.services.SearchHistoryManager
import com.neil.example.weatherdemo.services.WeatherApiServiceImpl

class SearchPresenter(v: SearchContract.View, ctx: Context): SearchContract.Presenter {

    private var searchView = v
    private var context  = ctx
    private var  weatherService = WeatherApiServiceImpl()

    override fun doSearch(text: String) {
        if (TextUtils.isEmpty(text)) showSearchHistory()
        else doSearchFromInternet(text)
    }

    private fun showSearchHistory() {
        searchView.onSearchSucceed(SearchHistoryManager.getSearchHistory())
    }

    private fun doSearchFromInternet(text: String) {
        weatherService.searchLocations(text, object :HttpCallback<SearchLocationListBean>(SearchLocationListBean()) {
            override fun onSucceed(t: SearchLocationListBean) {
                if (searchView.isViewDestroyed()) return
                searchView.onSearchSucceed(t)
            }

            override fun onFailed(errCode: Int, msg: String) {
                if (searchView.isViewDestroyed()) return
                searchView.onSearchFailed(errCode, msg)
            }
        })
    }
}