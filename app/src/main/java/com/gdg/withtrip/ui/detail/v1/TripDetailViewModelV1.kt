package com.gdg.withtrip.ui.detail.v1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gdg.withtrip.ui.detail.TripDetail

class TripDetailViewModelV1 : ViewModel() {

    private val _tripDetailLiveData = MutableLiveData<TripDetail>()
    val tripDetailLiveData: LiveData<TripDetail> = _tripDetailLiveData

    init {
        _tripDetailLiveData.postValue(
            TripDetail(
                seq = 0,
                image = "asdf",
                name = "name",
                location = "location",
                title = "title",
                desc = "desc",
                date = ""
            )
        )
    }
}