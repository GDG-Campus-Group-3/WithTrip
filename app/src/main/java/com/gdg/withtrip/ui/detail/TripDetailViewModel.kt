package com.gdg.withtrip.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TripDetailViewModel : ViewModel() {

    private val _tripDetailLiveData = MutableLiveData<TripDetail>()
    val tripDetailLiveData: LiveData<TripDetail> = _tripDetailLiveData

    init {
        _tripDetailLiveData.postValue(
            TripDetail(
                image = "asdf",
                name = "name",
                location = "location",
                title = "title",
                desc = "desc"
            )
        )
    }
}