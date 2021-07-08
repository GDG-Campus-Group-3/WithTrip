package com.gdg.withtrip.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.gdg.withtrip.R
import com.gdg.withtrip.databinding.FragmentHomeBinding
import com.gdg.withtrip.ui.MockData
import com.gdg.withtrip.ui.detail.TripDetail
import com.gdg.withtrip.ui.detail.TripDetailFragmentArgs
import com.gdg.withtrip.ui.popular.PopularCard
import com.gdg.withtrip.ui.popular.PopularCardAdapter
import com.solar.universe.binding.UniverseViewFragment

class HomeFragment :
    UniverseViewFragment<FragmentHomeBinding>(R.layout.fragment_home, FragmentHomeBinding::bind) {

    override fun onViewCreated(bind: FragmentHomeBinding, savedInstanceState: Bundle?) {

        val onClickCard = { model: PopularCard ->

            val action = HomeFragmentDirections.navigateToTripDetail(TripDetail(
                image = model.image,
                name = model.title,
                location = model.title,
                title = model.title,
                desc = model.subtitle
            ))

            findNavController().navigate(action)
        }

        bind.popularListView.adapter = PopularCardAdapter(onClickCard).apply {
            submit(MockData.randomPopularMockData())
        }
    }
}