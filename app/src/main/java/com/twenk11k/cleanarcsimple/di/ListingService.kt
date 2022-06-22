package com.twenk11k.cleanarcsimple.di

import com.twenk11k.cleanarcsimple.data.model.response.BaseResponse
import com.twenk11k.cleanarcsimple.data.model.response.Listing
import retrofit2.Response
import retrofit2.http.GET

interface ListingService {

    @GET("default/dynamodb-writer")
    suspend fun getListings(): Response<BaseResponse<Listing>>

}