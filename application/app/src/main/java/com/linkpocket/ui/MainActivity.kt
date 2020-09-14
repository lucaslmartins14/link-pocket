package com.linkpocket.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.linkpocket.R
import com.linkpocket.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModelMainActivity: MainViewModel by viewModel()
    private val linkKeeperAdapter = LinkKeeperAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val databindingUtil = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        databindingUtil.viewModel = viewModelMainActivity

        setupListPreview()

        viewModelMainActivity.mainViewStateLiveData.observe(this, Observer {
            linkKeeperAdapter.addList(it)
        })
    }

    private fun setupListPreview() {
        recycler_cards_links.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = linkKeeperAdapter
        }
    }
}