package com.twenk11k.cleanarcsimple.data.model

import com.google.gson.annotations.SerializedName

data class ListingResponse(
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
