package com.linkpocket.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.linkpocket.R
import com.linkpocket.databinding.ActivityMainBinding
import com.linkpocket.ui.links.adapter.LinkKeeperAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModelMainActivity: MainViewModel by viewModel()
    private val linkKeeperAdapter = LinkKeeperAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBindingUtil = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        dataBindingUtil.viewModel = viewModelMainActivity

        setupListPreview()

        viewModelMainActivity.mainViewStateLiveData.observe(this, Observer {
            linkKeeperAdapter.addList(it)
        })
    }

    private fun setupListPreview() {
//        recycler_cards_links.adapter = linkKeeperAdapter
    }
}