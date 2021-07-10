package com.gdg.withtrip.ui.map

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.gdg.withtrip.R
import com.gdg.withtrip.databinding.FragmentMapBinding
import com.gdg.withtrip.ui.MockData
import com.gdg.withtrip.ui.feed.FeedFragmentDirections
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.Marker
import com.solar.universe.binding.UniverseViewFragment
import com.solar.universe.extension.loadUrl
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
        setOnMarkerClickListener(::onMarkerClickListener)
        setInfoWindowAdapter(getInfoWindowAdapter(requireContext()))
        setOnInfoWindowClickListener(::onInfoWindowClick)
    }

    private fun onMapLoaded() {
        mapViewModel.getMapMarkers()
    }

    private fun onMarkerClickListener(marker: Marker): Boolean {
        marker.showInfoWindow()
        return true
    }

    private fun onInfoWindowClick(marker: Marker) {
        requireView().findNavController().navigate(
            MapFragmentDirections.actionNavigationHomeToTripDetailFragment(MockData.mockTripDetailData)
        )
    }

    private fun getInfoWindowAdapter(context: Context): GoogleMap.InfoWindowAdapter {
        return object: GoogleMap.InfoWindowAdapter {
            override fun getInfoContents(marker: Marker?): View? = null
            override fun getInfoWindow(marker: Marker?): View {
                val inflter = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val view = inflter.inflate(R.layout.view_map_info_window_trip, null)

                marker?.let {
                    val thumbnailUrl = (it.tag as String)
                    view.findViewById<TextView>(R.id.info_window_title).text = it.title
                    view.findViewById<AppCompatImageView>(R.id.info_window_thumb).loadUrl(thumbnailUrl)
                }

                return view
            }
        }
    }

    private fun showMarkers(list: List<MapMarker>) {
        val builder = LatLngBounds.builder()
        MapMarkerFactory.getMapMarkerList(list).forEachIndexed { index, markerOptions ->
            googleMap.addMarker(markerOptions).also {
                it?.tag = list[index].thumbnail
            }
            builder.include(markerOptions.position)
        }

        googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 10))
    }
    companion object {
        private const val DEFAULT_LATITUDE = 37.359215
        private const val DEFAULT_LONGITUDE = 127.105103
    }
}