package com.twenk11k.cleanarcsimple.ui.listing

import android.os.Bundle
import androidx.activity.viewModels
import com.twenk11k.cleanarcsimple.R
import com.twenk11k.cleanarcsimple.databinding.ActivityListingBinding
import com.twenk11k.cleanarcsimple.ui.binding.DataBindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListingActivity : DataBindingActivity() {

    private val binding: ActivityListingBinding by binding(R.layout.activity_listing)
    private val viewModel: ListingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            lifecycleOwner = this@ListingActivity
            vm = viewModel
            rvListing.adapter = ListingAdapter {
                // TODO display listing detail dialog
            }
        }
    }

}