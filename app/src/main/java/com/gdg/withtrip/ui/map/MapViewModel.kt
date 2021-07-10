package com.gdg.withtrip.ui.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gdg.withtrip.db.repository.MapRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MapViewModel @Inject constructor(
    private val mapRepository: MapRepository
): ViewModel() {

    private val _mapMarkerListLiveData = MutableLiveData<List<MapMarker>>()
    val mapMarkerListLiveData: LiveData<List<MapMarker>> get() = _mapMarkerListLiveData

    fun getMapMarkers() = viewModelScope.launch {
        runCatching {
            mapRepository.getHomeMarkerList()
        }.onSuccess {
            _mapMarkerListLiveData.postValue(it)
        }.onFailure {

        }
    }
}