package com.twenk11k.cleanarcsimple.ui.base

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel() {

    val isLoading = ObservableBoolean(false)
    val toastMessage = MutableLiveData("")

}