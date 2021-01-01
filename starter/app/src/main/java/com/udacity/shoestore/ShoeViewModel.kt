package com.udacity.shoestore

import android.view.View
import androidx.appcompat.view.menu.ShowableListMenu
import androidx.databinding.BaseObservable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel()  {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    // Event which triggers the end of the game
    private val _eventAddShoe = MutableLiveData<Boolean>()
    val eventAddShoe: LiveData<Boolean>
        get() = _eventAddShoe

    init {
        _shoeList.value = mutableListOf(
            Shoe("Baby Shoe 1", 9.5, "Dinokids", "Shoe for baby"),
            Shoe("Baby Shoe 2", 10.0, "Dinokids", "Shoe for baby"),
            Shoe("Baby Shoe 3", 9.5, "Dinokids", "Shoe for baby"),
            Shoe("Baby Shoe 4", 10.0, "Dinokids", "Shoe for baby"),
            Shoe("Baby Shoe 5", 8.0, "Dinokids", "Shoe for baby"),
            Shoe("Baby Shoe 6", 9.5, "Dinokids", "Shoe for baby"),
        )
    }

    fun addShoe(v : View,shoe: Shoe) {
            _shoeList.value?.add(shoe)
        _eventAddShoe.value = true
    }

    fun onEventAddShoeComplete() {
        _eventAddShoe.value = false
    }

}
