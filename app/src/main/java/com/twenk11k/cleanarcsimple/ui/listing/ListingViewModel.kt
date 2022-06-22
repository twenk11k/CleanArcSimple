package com.twenk11k.cleanarcsimple.ui.listing

import androidx.lifecycle.*
import com.twenk11k.cleanarcsimple.data.model.response.Listing
import com.twenk11k.cleanarcsimple.data.repository.ListingRepository
import com.twenk11k.cleanarcsimple.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class ListingViewModel @Inject constructor(listingRepository: ListingRepository) : BaseViewModel() {

    private val listingsLoadTrigger = MutableLiveData(Unit)
    var listingsLiveData: LiveData<List<Listing>>

    init {
        listingsLiveData = listingsLoadTrigger.switchMap {
            listingRepository.getListings(
                onStart = { isLoading.set(true) },
                onError = { toastMessage.postValue(it) },
                onComplete = { isLoading.set(false) }
            ).asLiveData(viewModelScope.coroutineContext + Dispatchers.IO)
        }
        listingsLoadTrigger.value = Unit
    }

}