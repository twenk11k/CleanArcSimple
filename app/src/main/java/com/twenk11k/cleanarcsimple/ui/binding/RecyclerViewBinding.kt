package com.twenk11k.cleanarcsimple.ui.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.twenk11k.cleanarcsimple.data.model.response.Listing
import com.twenk11k.cleanarcsimple.ui.listing.ListingAdapter

object RecyclerViewBinding {

    @JvmStatic
    @BindingAdapter("listingAdapter")
    fun bindListingAdapter(
        view: RecyclerView,
        list: List<Listing>?
    ) {
        list?.let {
            if(view.adapter is ListingAdapter) {
                (view.adapter as? ListingAdapter)?.updateAdapter(it)
            }
        }
    }

}