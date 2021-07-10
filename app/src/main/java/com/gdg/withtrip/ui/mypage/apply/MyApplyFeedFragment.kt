package com.gdg.withtrip.ui.mypage.apply

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.gdg.withtrip.R
import com.gdg.withtrip.databinding.FragmentMyApplyTripFeedBinding
import com.gdg.withtrip.ui.MockData
import com.gdg.withtrip.ui.detail.ApplyState
import com.gdg.withtrip.ui.detail.TripDetail
import com.gdg.withtrip.ui.popular.PopularCard
import com.gdg.withtrip.ui.popular.PopularCardEventListener
import com.solar.universe.binding.UniverseViewFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyApplyFeedFragment :
    UniverseViewFragment<FragmentMyApplyTripFeedBinding>(
        R.layout.fragment_my_apply_trip_feed,
        FragmentMyApplyTripFeedBinding::bind
    ),
    PopularCardEventListener {

    private val tripViewModelApply: MyApplyFeedViewModel by viewModels()

    override fun onClickCard(popularCard: PopularCard) {
        val tripDetail = TripDetail(
            seq = popularCard.id,
            image = popularCard.image,
            name = popularCard.writer,
            location = popularCard.place,
            title = popularCard.title,
            desc = "이번주 토요일에 한라산 등반하실 분 저포함 4명 구합니다! 등반 소요 시간은 약 3시간 정도구요 하산 후에 간단하게 뒷풀이 하고 헤어질 예정입니다!",
            date = popularCard.date
        )

        requireView().findNavController().navigate(
            MyApplyFeedFragmentDirections.actionMyApplyFeedFragmentToTripDetailFragment2(tripDetail)
        )
    }

    override fun onViewCreated(bind: FragmentMyApplyTripFeedBinding, savedInstanceState: Bundle?) {
        bind.popularListView.adapter = ApplyTripCardAdapter(this).apply {
            submitList(MockData.randomPopularMockData().filter { it.state != ApplyState.NOT_APPLY })
        }
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}