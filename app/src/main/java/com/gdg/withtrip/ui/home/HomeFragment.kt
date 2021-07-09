package com.gdg.withtrip.ui.home

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.gdg.withtrip.R
import com.gdg.withtrip.databinding.FragmentHomeBinding
import com.gdg.withtrip.ui.MockData
import com.gdg.withtrip.ui.detail.TripDetail
import com.gdg.withtrip.ui.popular.PopularCard
import com.gdg.withtrip.ui.popular.PopularCardAdapter
import com.gdg.withtrip.ui.popular.PopularCardEventListener
import com.gdg.withtrip.ui.trip.TripViewModel
import com.solar.universe.binding.UniverseViewFragment

class HomeFragment :
    UniverseViewFragment<FragmentHomeBinding>(R.layout.fragment_home, FragmentHomeBinding::bind),
    PopularCardEventListener {

    private val tripViewModel: TripViewModel by viewModels()

    override fun onViewCreated(bind: FragmentHomeBinding, savedInstanceState: Bundle?) {


        bind.popularListView.adapter = PopularCardAdapter(this).apply {
            submit(MockData.randomPopularMockData())
        }
    }

    override fun onClickCard(popularCard: PopularCard) {
        val tripDetail = TripDetail(
            image = popularCard.image,
            name = popularCard.title,
            location = popularCard.title,
            title = popularCard.title,
            desc = popularCard.subtitle
        )

        requireView().findNavController()
            .navigate(R.id.navigate_to_trip_detail, bundleOf("tripDetail" to tripDetail))
    }

    override fun onClickLike(popularCard: PopularCard) {
        tripViewModel.savePopularCard(popularCard)
    }
}