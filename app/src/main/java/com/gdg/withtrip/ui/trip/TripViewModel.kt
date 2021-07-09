package com.gdg.withtrip.ui.trip

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gdg.withtrip.ui.popular.PopularCard

import com.gdg.withtrip.ui.repository.TripRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TripViewModel @Inject constructor(
    val tripRepository: TripRepository
): ViewModel() {



    fun savePopularCard(popularCard: PopularCard) = viewModelScope.launch {
        runCatching {
            tripRepository.insertPopularTrip(popularCard)
        }.onSuccess {

        }.onFailure {

        }
    }
}