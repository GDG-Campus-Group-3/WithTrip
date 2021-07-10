package com.gdg.withtrip.ui.map

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.viewModels
import com.gdg.withtrip.R
import com.gdg.withtrip.databinding.FragmentMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.solar.universe.binding.UniverseViewFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapFragment :
    UniverseViewFragment<FragmentMapBinding>(R.layout.fragment_map, FragmentMapBinding::bind),
    OnMapReadyCallback {

    private lateinit var mapView: MapView
    private lateinit var googleMap: GoogleMap

    private val mapViewModel: MapViewModel by viewModels()

    override fun onViewCreated(bind: FragmentMapBinding, savedInstanceState: Bundle?) {
        mapView = bind.mapView
        mapView.getMapAsync(this)
        mapViewModel.mapMarkerListLiveData.observe(viewLifecycleOwner, {
            showMarkers(it)
        })
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }


    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStart()
    }


    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mapView.onCreate(savedInstanceState)
    }

    override fun onMapReady(googleMap: GoogleMap) = with(googleMap) {
        this@MapFragment.googleMap = googleMap
        moveCamera(
            CameraUpdateFactory.newLatLngZoom(
                LatLng(DEFAULT_LATITUDE, DEFAULT_LONGITUDE), 14.0f
            )
        )

        setOnMapLoadedCallback(::onMapLoaded)
    }

    private fun onMapLoaded() {
        mapViewModel.getMapMarkers()
    }

    private fun showMarkers(list: List<MapMarker>) {
        val builder = LatLngBounds.builder()
        MapMarkerFactory.getMapMarkerList(list).forEach {
            googleMap.addMarker(it)
            builder.include(it.position)
        }

        googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 10))
    }
    companion object {
        private const val DEFAULT_LATITUDE = 37.359215
        private const val DEFAULT_LONGITUDE = 127.105103
    }
}