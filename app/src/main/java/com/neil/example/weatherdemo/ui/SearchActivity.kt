package com.neil.example.weatherdemo.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.neil.example.weatherdemo.R
import com.neil.example.weatherdemo.beans.SearchLocationListBean

class SearchActivity : AppCompatActivity(), SearchContract.View {

    private lateinit var etSearchInputView: EditText
    private lateinit var recyclerView: RecyclerView
    private lateinit var tvEmptyView: TextView
    private lateinit var presenter: SearchContract.Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }


    private var runSearchTask = Runnable {
        presenter.doSearch(etSearchInputView.text.toString())
    }

    private fun initView() {
        etSearchInputView = findViewById(R.id.et_search_input)
        recyclerView = findViewById(R.id.search_history_recyclerview)
        tvEmptyView = findViewById(R.id.tv_empty_tips)
        presenter = SearchPresenter(this, this)
        presenter.doSearch("")
        etSearchInputView.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                UIEventHandler.removeCallbacks(runSearchTask)
                UIEventHandler.postDelayed(runSearchTask, DELAY_FOR_SEARCH)
            }
        })
    }

    override fun isViewDestroyed(): Boolean {
        return isDestroyed
    }

    override fun onSearchSucceed(searchList: SearchLocationListBean) {
        recyclerView.visibility = View.VISIBLE
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = LocationSearchAdapter(this, searchList)
        tvEmptyView.visibility = View.GONE
    }

    override fun onSearchFailed(errorCode: Int, msg: String) {
        tvEmptyView.visibility = View.VISIBLE
        tvEmptyView.text = msg
        recyclerView.visibility = View.GONE
    }

    companion object {
        private const val DELAY_FOR_SEARCH = 2000L
    }
}
