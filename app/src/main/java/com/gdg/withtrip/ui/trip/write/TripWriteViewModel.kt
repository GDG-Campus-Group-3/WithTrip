package com.gdg.withtrip.ui.trip.write

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gdg.withtrip.databinding.ActivityTripWriteBinding
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TripWriteViewModel @Inject constructor(): ViewModel() {


    private val _toastMsgLiveData = MutableLiveData<String>()
    val toastMsgLiveData: LiveData<String> get() = _toastMsgLiveData

    @MainThread
    fun writeTrip(bind: ActivityTripWriteBinding) {
        if (bind.feedWriteTitle.text.isNullOrEmpty()) {
            _toastMsgLiveData.postValue("제목을 입력해 주세요")
            return
        }

        if (bind.feedWriteInput.text.isNullOrEmpty()) {
            _toastMsgLiveData.postValue("내용을 입력해 주세요")
        }
    }
}