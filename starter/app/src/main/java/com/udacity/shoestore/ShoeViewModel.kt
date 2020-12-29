package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

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

    fun addShoe(name: String?, size: Double?, company: String?, descripton: String?) {
        _shoeList.value?.add(Shoe(name, size, company, descripton))
    }

}
