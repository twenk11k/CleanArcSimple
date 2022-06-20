package com.twenk11k.cleanarcsimple.di

import com.twenk11k.cleanarcsimple.data.model.BaseResponse
import com.twenk11k.cleanarcsimple.data.model.ListingResponse
import retrofit2.Response
import retrofit2.http.GET

interface ListingService {

    @GET("default/dynamodb-writer")
    fun getListings(): Response<BaseResponse<ListingResponse>>

}