package com.linkpocket.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.linkpocket.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by inject()
    private val linkKeeperAdapter = LinkKeeperAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupListPreview()

        viewModel.mainViewStateLiveData.observe(this, Observer {
            handlerState(it)
        })
    }

    private fun setupListPreview() {
        recycler_cards_links.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = linkKeeperAdapter
        }
    }

    private fun handlerState(state: MainUiState) {
        when (state) {
            is MainUiState.Loading -> showLoading()
            is MainUiState.Success -> {
                hideLoading()
                linkKeeperAdapter.addList(state.list)
            }
            is MainUiState.Error -> {
                hideLoading()
                showError()
            }
        }
    }

    private fun showLoading() {
        loading.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        loading.visibility = View.GONE
    }

    private fun showError() {
        state_error.visibility = View.VISIBLE
    }
}