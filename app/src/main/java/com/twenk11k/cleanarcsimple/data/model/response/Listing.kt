package com.twenk11k.cleanarcsimple.data.model.response

import com.google.gson.annotations.SerializedName

data class Listing(
    @SerializedName("created_at")
    val createdAt: String?,
    val price: String?,
    val name: String?,
    val uid: String?,
    @SerializedName("image_ids")
    val imageIds: List<String?>?,
    @SerializedName("image_urls")
    val imageUrls: List<String?>?,
    @SerializedName("image_urls_thumbnails")
    val imageUrlsThumbnails: List<String?>?
)
