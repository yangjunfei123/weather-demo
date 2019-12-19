package com.neil.example.weatherdemo.ui


import com.neil.example.weatherdemo.beans.SearchLocationListBean

interface SearchContract {
    interface View : BaseContract.BaseView {
        fun onSearchSucceed(searchList: SearchLocationListBean)

        fun onSearchFailed(errorCode: Int, msg: String)
    }

    interface Presenter {
        fun doSearch(text: String)
    }
}