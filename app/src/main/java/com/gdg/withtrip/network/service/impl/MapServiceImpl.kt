package com.gdg.withtrip.network.service.impl

import com.gdg.withtrip.network.service.MapService
import com.gdg.withtrip.ui.MockData
import com.gdg.withtrip.ui.map.MapMarker

class MapServiceImpl : MapService {
    override suspend fun getHomeMarkerList(): List<MapMarker> {
        return MockData.getMapMarkerList()
    }
}