package com.gdg.withtrip.ui.trip

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gdg.withtrip.ui.popular.PopularCard

import com.gdg.withtrip.ui.repository.TripRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TripViewModel @Inject constructor(
    private val tripRepository: TripRepository
): ViewModel() {

    private val _likeTripCardListLiveData = MutableLiveData<List<PopularCard>>()
    val likeTripCardListLiveData: LiveData<List<PopularCard>> get() = _likeTripCardListLiveData

    fun getLikeTripCardList() = viewModelScope.launch {
        runCatching {
            tripRepository.getLikeTripCardList()
        }.onSuccess {
            _likeTripCardListLiveData.postValue(it)
        }.onFailure {

        }
    }

    fun savePopularCard(popularCard: PopularCard) = viewModelScope.launch {
        runCatching {
            tripRepository.insertPopularTrip(popularCard)
        }.onSuccess {

        }.onFailure {

        }
    }
}