package com.twenk11k.cleanarcsimple.data.repository

import androidx.annotation.WorkerThread
import com.twenk11k.cleanarcsimple.di.ListingService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import timber.log.Timber
import javax.inject.Inject

class ListingRepository @Inject constructor(private val listingService: ListingService) {

    @WorkerThread
    fun getListings(
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ) = flow {
        try {
            val response = listingService.getListings()
            if (response.isSuccessful) {
                response.body()?.results?.let {
                    emit(it)
                }
            }
        } catch (e: Exception) {
            Timber.e(e.message)
            onError(e.message)
        }
    }.onStart { onStart() }.onCompletion { onComplete() }.flowOn(Dispatchers.IO)

}