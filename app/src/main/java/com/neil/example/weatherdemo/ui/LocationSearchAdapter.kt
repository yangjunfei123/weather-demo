package com.neil.example.weatherdemo.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.neil.example.weatherdemo.R
import com.neil.example.weatherdemo.beans.SearchLocationListBean
import com.neil.example.weatherdemo.services.SearchHistoryManager

class LocationSearchAdapter(ctx: Context, locationList: SearchLocationListBean) : RecyclerView.Adapter<LocationViewHolder>() {

    private var context = ctx
    private var locationListBean = locationList

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): LocationViewHolder {
        var v = LayoutInflater.from(context).inflate(R.layout.layout_search_result_item, parent, false)
        return LocationViewHolder(v)
    }

    override fun getItemCount(): Int {
        return locationListBean?.searchResultList?.size
    }

    override fun onBindViewHolder(holder: LocationViewHolder, pos: Int) {
        var item = locationListBean.searchResultList[pos]
        var area = "${item.areaName},   ${item.region},    ${item.country}"
        holder.tvName.text = area

        holder.rootView.setOnClickListener(View.OnClickListener {
            SearchHistoryManager.insertNewHistory(item)
            WeatherDetailActivity.enterWeatherDetail(context,
                "${item.latitude},${item.longitude}",
                        area)
        })

    }
}

class LocationViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    var rootView = v
    var tvName: TextView = v.findViewById(R.id.tv_name)
}