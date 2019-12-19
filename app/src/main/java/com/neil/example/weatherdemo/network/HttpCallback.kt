package com.neil.example.weatherdemo.network

abstract class HttpCallback<T>(t : T?) {
    var target: T? = t


    /**
     * succeed call back
     * */
    abstract fun onSucceed(t : T)

    /**
     * failed call back
     * */
    abstract fun onFailed(errCode : Int, msg: String)
}