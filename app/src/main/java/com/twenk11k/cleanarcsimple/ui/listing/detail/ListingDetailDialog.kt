package com.twenk11k.cleanarcsimple.ui.listing.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.twenk11k.cleanarcsimple.R
import com.twenk11k.cleanarcsimple.data.model.response.Listing
import com.twenk11k.cleanarcsimple.databinding.DialogListingDetailBinding

class ListingDetailDialog : DialogFragment() {

    private var listingArg: Listing? = null

    companion object {
        fun newInstance(listing: Listing): ListingDetailDialog {
            val frag = ListingDetailDialog()
            val args = Bundle()
            args.putParcelable("listing", listing)
            frag.arguments = args
            return frag
        }
    }

    override fun getTheme(): Int {
        return R.style.DialogTheme
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listingArg = arguments?.getParcelable("listing")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return DataBindingUtil.inflate<DialogListingDetailBinding>(
            inflater,
            R.layout.dialog_listing_detail,
            container,
            false
        ).apply {
            listing = listingArg
            lifecycleOwner = viewLifecycleOwner
            imgBack.setOnClickListener { dismiss() }
        }.root
    }

}