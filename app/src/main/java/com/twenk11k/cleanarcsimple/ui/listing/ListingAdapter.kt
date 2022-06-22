package com.twenk11k.cleanarcsimple.ui.listing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.twenk11k.cleanarcsimple.R
import com.twenk11k.cleanarcsimple.data.model.response.Listing
import com.twenk11k.cleanarcsimple.databinding.ItemListingBinding

class ListingAdapter : RecyclerView.Adapter<ListingAdapter.ViewHolder>() {

    private var items = ArrayList<Listing>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemListingBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_listing,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            listing = items[position]
        }
    }

    fun updateAdapter(list: List<Listing>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemListingBinding) : RecyclerView.ViewHolder(binding.root)

}