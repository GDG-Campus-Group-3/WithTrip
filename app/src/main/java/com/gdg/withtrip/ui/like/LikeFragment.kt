package com.gdg.withtrip.ui.like

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.gdg.withtrip.R
import com.gdg.withtrip.databinding.FragmentLikeBinding
import com.gdg.withtrip.ui.trip.TripViewModel
import com.solar.universe.binding.UniverseViewFragment

class LikeFragment : UniverseViewFragment<FragmentLikeBinding>(R.layout.fragment_like, FragmentLikeBinding::bind) {

    private val tripViewModel: TripViewModel by viewModels()

    override fun onViewCreated(bind: FragmentLikeBinding, savedInstanceState: Bundle?) {
        tripViewModel.likeTripCardListLiveData.observe(viewLifecycleOwner, { list ->
            bind.likeListView.adapter = LikeCardAdapter().apply {
                submit(list)
            }
        })
    }
}