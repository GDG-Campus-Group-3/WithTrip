package com.gdg.withtrip.ui.map

import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

object MapMarkerFactory {
    fun getMapMarkerList(list: List<MapMarker>): List<MarkerOptions> {
        return list.map {
            getMarkerOption(
                title = it.title,
                latitude = it.latitude,
                longitude = it.longitude,
                null
            )
        }
    }


    private fun getMarkerOption(
        title: String,
        latitude: Double,
        longitude: Double,
        icon: BitmapDescriptor?
    ) =
        MarkerOptions()
            .title(title)
            .position(LatLng(latitude, longitude))
            .icon(icon)
}