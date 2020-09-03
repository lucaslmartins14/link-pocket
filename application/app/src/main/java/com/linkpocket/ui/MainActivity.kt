package com.linkpocket.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.domain.model.Preview
import com.linkpocket.PreviewCache
import com.linkpocket.R
import com.linkpocket.entity.PreviewEntity
import com.linkpocket.ext.setup
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by inject()

    private val previewCache by lazy { PreviewCache(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.mainViewStateLiveData.observe(this, Observer {
            handlerState(it)
        })

    }

    private fun handlerState(state: MainUiState) {
        when (state) {
            is MainUiState.Loading -> showLoading()
            is MainUiState.Success -> {
                hideLoading()
                setupListPreview(state.list)

                val previewEntity = state.list.map { transform(it) }

                previewCache.addAll(*previewEntity.toTypedArray())
                getList()
            }
            is MainUiState.Error -> showError()
        }
    }

    private fun transform(preview: Preview) : PreviewEntity {
        return PreviewEntity(name = preview.name, description = preview.description, image = preview.image)
    }

    private fun setupListPreview(list: List<Preview>) {
        recycler_cards_links.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            setup<LinkKeeperAdapter>(list)
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

    private fun getList(){
        previewCache.getAll { list ->
            list.size
        }
        previewCache.getAllWithThread { list->
            runOnUiThread {
                list.size
            }
        }
    }
}