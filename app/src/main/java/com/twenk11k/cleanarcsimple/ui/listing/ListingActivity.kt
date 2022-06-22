package com.twenk11k.cleanarcsimple.ui.listing

import android.os.Bundle
import com.twenk11k.cleanarcsimple.R
import com.twenk11k.cleanarcsimple.databinding.ActivityListingBinding
import com.twenk11k.cleanarcsimple.ui.binding.DataBindingActivity

class ListingActivity : DataBindingActivity() {

    private val binding: ActivityListingBinding by binding(R.layout.activity_listing)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            lifecycleOwner = this@ListingActivity
        }
    }

}