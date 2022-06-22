package com.twenk11k.cleanarcsimple.data.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.twenk11k.cleanarcsimple.util.Constants.DATE_FORMAT_PATTERN
import com.twenk11k.cleanarcsimple.util.Constants.PARSE_FORMAT_PATTERN
import kotlinx.parcelize.Parcelize
import java.text.SimpleDateFormat
import java.util.*

@Parcelize
data class Listing(
    val name: String?,
    val uid: String?,
    val price: String?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("image_ids")
    val imageIds: List<String?>?,
    @SerializedName("image_urls")
    val imageUrls: List<String?>?,
    @SerializedName("image_urls_thumbnails")
    val imageUrlsThumbnails: List<String?>?
) : Parcelable {

    fun parseCreatedAt(): String? {
        val parseFormat = SimpleDateFormat(PARSE_FORMAT_PATTERN, Locale.ENGLISH)
        val dateFormat = SimpleDateFormat(DATE_FORMAT_PATTERN, Locale.ENGLISH)
        createdAt?.let {
            val dateStart = dateFormat.parse(it)
            if (dateStart != null) {
                return parseFormat.format(dateStart)
            }
        }
        return null
    }

}
