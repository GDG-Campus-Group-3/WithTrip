package com.gdg.withtrip.ui.trip.write

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gdg.withtrip.KEY_SEQ
import com.gdg.withtrip.databinding.ActivityTripWriteBinding
import com.gdg.withtrip.db.repository.TripRepository
import com.gdg.withtrip.util.Prefs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TripWriteViewModel @Inject constructor(
    private val tripRepository: TripRepository
): ViewModel() {


    private val _toastMsgLiveData = MutableLiveData<String>()
    val toastMsgLiveData: LiveData<String> get() = _toastMsgLiveData



    @MainThread
    fun writeTrip(
        bind: ActivityTripWriteBinding,
        title: String,
        personCount: Int,
        startDate: String,
        endDate: String,
        location: String
    ) {
        if (bind.feedWriteTitle.text.isNullOrEmpty()) {
            _toastMsgLiveData.postValue("제목을 입력해 주세요")
            return
        }

        if (bind.feedWriteInput.text.isNullOrEmpty()) {
            _toastMsgLiveData.postValue("내용을 입력해 주세요")
            return
        }

        viewModelScope.launch {
            runCatching {
                tripRepository.postTrip(
                    seq = Prefs.getString(KEY_SEQ),
                    title = title,
                    personCount = personCount,
                    startDate = startDate,
                    endDate = endDate,
                    location = location,
                    content = bind.feedWriteInput.text.toString()
                )
            }.onSuccess {

            }.onFailure {

            }
        }
    }
}