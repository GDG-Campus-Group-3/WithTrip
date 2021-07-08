package com.gdg.withtrip.ui.home

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.gdg.withtrip.R
import com.gdg.withtrip.databinding.FragmentHomeBinding
import com.gdg.withtrip.ui.MockData
import com.gdg.withtrip.ui.detail.TripDetail
import com.gdg.withtrip.ui.popular.PopularCard
import com.gdg.withtrip.ui.popular.PopularCardAdapter
import com.solar.universe.binding.UniverseViewFragment

class HomeFragment :
    UniverseViewFragment<FragmentHomeBinding>(R.layout.fragment_home, FragmentHomeBinding::bind) {

    override fun onViewCreated(bind: FragmentHomeBinding, savedInstanceState: Bundle?) {

        val onClickCard = { model: PopularCard ->
            val tripDetail = TripDetail(
                image = model.image,
                name = model.title,
                location = model.title,
                title = model.title,
                desc = model.subtitle
            )

            val action = HomeFragmentDirections.navigateToTripDetail()
            requireView().findNavController().navigate(R.id.navigate_to_trip_detail, bundleOf("tripDetail" to tripDetail))
        }

        bind.popularListView.adapter = PopularCardAdapter(onClickCard).apply {
            submit(MockData.randomPopularMockData())
        }
    }
}