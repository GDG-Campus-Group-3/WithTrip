package com.gdg.withtrip.ui.map

import android.content.Intent
import android.os.Bundle
import com.gdg.withtrip.R
import com.gdg.withtrip.databinding.ActivityCenterMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.solar.universe.binding.UniverseViewActivity

class CenterMapActivity :
    UniverseViewActivity<ActivityCenterMapBinding>(ActivityCenterMapBinding::inflate),
    OnMapReadyCallback {

    lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (supportFragmentManager.findFragmentById(R.id.fragment_container) as SupportMapFragment).apply {
            getMapAsync(this@CenterMapActivity)
        }
        binding.confirm.setOnClickListener {
            val target = googleMap.cameraPosition.target
            setResult(RESULT_OK, Intent().apply {
                putExtra(KEY_LATITUDE, target.latitude)
                putExtra(KEY_LONGITUDE, target.longitude)
            })
            finish()
        }
    }

    override fun onMapReady(googleMap: GoogleMap) = with(googleMap) {
        this@CenterMapActivity.googleMap = googleMap

        moveCamera(
            CameraUpdateFactory.newLatLngZoom(
                LatLng(DEFAULT_LATITUDE, DEFAULT_LONGITUDE), 14.0f
            )
        )
    }

    companion object {
        private const val DEFAULT_LATITUDE = 37.359215
        private const val DEFAULT_LONGITUDE = 127.105103

        const val REQUEST_CODE_CENTER = 0

        const val KEY_LATITUDE = "KEY_LATITUDE"
        const val KEY_LONGITUDE = "KEY_LONGITUDE"
    }
}