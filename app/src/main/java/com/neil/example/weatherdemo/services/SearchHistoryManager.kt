package com.neil.example.weatherdemo.services

import android.content.Context
import com.neil.example.weatherdemo.beans.SearchLocationListBean
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.io.Serializable
import java.lang.Exception

object SearchHistoryManager {

    const val history_list_file_name = "search_history.txt"
    const val max_history_size = 10

    private lateinit var context: Context

    private var searchHistoryList = mutableListOf<SearchHistory>()
    data class SearchHistory(var cityInfo: SearchLocationListBean.SearchLocaitonItem,
                             var timeStamp: Long): Serializable

    fun init(ctx: Context) {
        context = ctx
        loadFromFile()
    }

    fun insertNewHistory(city: SearchLocationListBean.SearchLocaitonItem) {
        var iter = searchHistoryList.iterator()
        while (iter != null && iter.hasNext()) {
            var item = iter.next()
            if (item.cityInfo.equals(city)) {
                iter.remove()
                break
            }
        }
        searchHistoryList.add(0, SearchHistory(city, System.currentTimeMillis()))
        while (searchHistoryList.size > max_history_size) {
            searchHistoryList.removeAt(searchHistoryList.size - 1)
        }

        saveToFile()
    }

    fun getSearchHistory(): SearchLocationListBean {
        var locationListBean = SearchLocationListBean()
        var listBean = mutableListOf<SearchLocationListBean.SearchLocaitonItem>()
        searchHistoryList.forEach {
            listBean.add(it.cityInfo)
        }

        locationListBean.searchResultList = listBean
        return locationListBean
    }

    private fun saveToFile() {
        var oos: ObjectOutputStream? = null
        try {
            oos = ObjectOutputStream(context.openFileOutput(history_list_file_name, Context.MODE_PRIVATE))
            oos.writeObject(searchHistoryList)
        } catch (e: Exception) {
            e.printStackTrace()
        }  finally {
            oos?.close()
        }

    }

    fun loadFromFile() {
        var ooi: ObjectInputStream? = null
        try {
            if (!context.getFileStreamPath(history_list_file_name).exists()) return
            ooi = ObjectInputStream(context.openFileInput(history_list_file_name))
            var temp = ooi.readObject() as MutableList<SearchHistory>
            searchHistoryList.clear()
            searchHistoryList.addAll(temp)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            ooi?.close()
        }
    }

    fun reset() {
        searchHistoryList.clear()
    }

}