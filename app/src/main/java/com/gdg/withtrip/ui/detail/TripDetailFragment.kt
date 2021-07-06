package com.gdg.withtrip.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.gdg.withtrip.R
import com.gdg.withtrip.databinding.FragmentTripDetailBinding
import com.solar.universe.binding.UniverseFragment

class TripDetailFragment : UniverseFragment<FragmentTripDetailBinding>(R.layout.fragment_trip_detail){

    private val tripDetailViewModel: TripDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tripDetailViewModel.tripDetailLiveData.observe(viewLifecycleOwner, {

        })
    }
}