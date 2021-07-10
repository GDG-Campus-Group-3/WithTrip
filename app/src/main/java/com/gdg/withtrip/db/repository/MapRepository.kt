package com.gdg.withtrip.db.repository

import com.gdg.withtrip.ui.map.MapMarker

interface MapRepository {
    suspend fun getHomeMarkerList(): List<MapMarker>
}