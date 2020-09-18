package com.linkpocket.ui.links.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.domain.model.Preview
import com.linkpocket.R
import com.linkpocket.databinding.ItemCardLinkBinding

class LinkKeeperAdapter : RecyclerView.Adapter<LinkKeeperAdapter.LinkKeeperAdapterViewHolder>() {

    private val list = ArrayList<Preview>()

    fun addList(list : List<Preview>) {
        this.list.clear()
        this.list.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LinkKeeperAdapterViewHolder =
        LinkKeeperAdapterViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_card_link, parent,false))

    override fun onBindViewHolder(holder: LinkKeeperAdapterViewHolder, position: Int) = holder.bind(list[position])

    override fun getItemCount(): Int = list.size

    class LinkKeeperAdapterViewHolder(private val dataBinding: ItemCardLinkBinding) : RecyclerView.ViewHolder(dataBinding.root) {

        fun bind(preview: Preview) {
            dataBinding.preview = preview
        }
    }
}