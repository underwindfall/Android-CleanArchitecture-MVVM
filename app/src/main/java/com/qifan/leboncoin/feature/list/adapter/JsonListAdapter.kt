package com.qifan.leboncoin.feature.list.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.qifan.leboncoin.R
import com.qifan.leboncoin.core.extension.inflateLayout
import com.qifan.leboncoin.core.extension.loadImage
import com.qifan.leboncoin.feature.list.model.LeBonCoin
import kotlinx.android.synthetic.main.item_le_bon_coin_content.view.*

/**
 * Created by Qifan on 2019-07-13.
 */
class JsonListAdapter(private val dataSource: List<LeBonCoin>) : RecyclerView.Adapter<JsonListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflateLayout(R.layout.item_le_bon_coin_content)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSource[position]
        holder.bindView(item)
    }

    override fun getItemCount(): Int = dataSource.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: LeBonCoin) {
            with(itemView) {
                image.loadImage(item.thumbnailUrl)
                title.text = item.title
            }
        }
    }
}