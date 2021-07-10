package com.gdg.withtrip.ui.feed

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.gdg.withtrip.R
import com.gdg.withtrip.SearchToolBarHolder
import com.gdg.withtrip.databinding.FragmentFeedBinding
import com.gdg.withtrip.ui.MockData
import com.gdg.withtrip.ui.detail.TripDetail
import com.gdg.withtrip.ui.popular.PopularCard
import com.gdg.withtrip.ui.popular.PopularCardAdapter
import com.gdg.withtrip.ui.popular.PopularCardEventListener
import com.gdg.withtrip.ui.trip.TripViewModel
import com.solar.universe.binding.UniverseViewFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedFragment :
    UniverseViewFragment<FragmentFeedBinding>(R.layout.fragment_feed, FragmentFeedBinding::bind),
    PopularCardEventListener {

    lateinit var searchToolBar: SearchToolBarHolder

    private val tripViewModel: TripViewModel by viewModels()

    override fun onViewCreated(bind: FragmentFeedBinding, savedInstanceState: Bundle?) {
        tripViewModel.likeTripCardListLiveData.observe(viewLifecycleOwner, { list ->
            bind.popularListView.adapter = PopularCardAdapter(this).apply {
                submitList(list)
                //submitList(MockData.randomPopularMockData())
            }
        })
        tripViewModel.getFeedList()

        if (::searchToolBar.isInitialized && !searchToolBar.getController().searchWord.hasObservers()) {
            searchToolBar.getController().searchWord.observe(viewLifecycleOwner, {
                Log.d("검색 단어 ->", it)
            })
        }

    }

    override fun onClickCard(popularCard: PopularCard) {
        val tripDetail = TripDetail(
            image = popularCard.image,
            name = popularCard.writer,
            location = popularCard.place,
            title = popularCard.title,
            desc = "이번주 토요일에 한라산 등반하실 분 저포함 4명 구합니다! 등반 소요 시간은 약 3시간 정도구요 하산 후에 간단하게 뒷풀이 하고 헤어질 예정입니다!",
            date = popularCard.date
        )

        requireView().findNavController().navigate(
            FeedFragmentDirections.actionNavigationFeedToTripDetailFragment2(tripDetail)
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            searchToolBar = context as SearchToolBarHolder
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}