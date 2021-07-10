package com.gdg.withtrip.db.repository.impl

import com.gdg.withtrip.db.repository.MapRepository
import com.gdg.withtrip.network.service.MapService
import com.gdg.withtrip.ui.map.MapMarker
import javax.inject.Inject

class MapRepositoryImpl @Inject constructor(
    private val mapService: MapService
) : MapRepository {
    override suspend fun getHomeMarkerList(): List<MapMarker> {
        return mapService.getHomeMarkerList()
    }
}