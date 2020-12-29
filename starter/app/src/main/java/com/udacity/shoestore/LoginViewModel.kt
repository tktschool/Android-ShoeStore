package com.udacity.shoestore

import androidx.lifecycle.ViewModel
import timber.log.Timber

class LoginViewModel : ViewModel() {

    init {
        Timber.v("LoginViewModel Init")
    }



    override fun onCleared() {
        super.onCleared()
        Timber.v("LoginViewModel onCleared")
    }
}