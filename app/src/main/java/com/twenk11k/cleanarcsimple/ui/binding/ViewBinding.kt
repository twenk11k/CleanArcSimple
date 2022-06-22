package com.twenk11k.cleanarcsimple.ui.binding

import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.twenk11k.cleanarcsimple.R

object ViewBinding {

    @JvmStatic
    @BindingAdapter("gone")
    fun bindGone(view: View, isGone: Boolean) {
        view.visibility = if (isGone) {
            View.GONE
        } else {
            View.VISIBLE
        }
    }

    @JvmStatic
    @BindingAdapter("toast")
    fun bindToast(view: View, text: String) {
        if (text.isNotBlank()) {
            Toast.makeText(view.context, text, Toast.LENGTH_SHORT).show()
        }
    }

    @JvmStatic
    @BindingAdapter("loadImage")
    fun bindLoadImage(
        view: ImageView,
        url: String?
    ) {
        Glide.with(view.context)
            .load(url)
            .placeholder(R.drawable.placeholder)
            .centerCrop()
            .into(view)
    }

}