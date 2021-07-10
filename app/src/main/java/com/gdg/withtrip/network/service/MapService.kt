package com.gdg.withtrip.network.service

import com.gdg.withtrip.ui.map.MapMarker

interface MapService {
    suspend fun getHomeMarkerList(): List<MapMarker>
}