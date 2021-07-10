package com.gdg.withtrip.ui.detail

import android.graphics.Color
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.gdg.withtrip.R
import com.gdg.withtrip.databinding.FragmentTripDetailBinding
import com.solar.universe.binding.UniverseViewFragment
import com.solar.universe.extension.loadUrl

class TripDetailFragment : UniverseViewFragment<FragmentTripDetailBinding>(
    R.layout.fragment_trip_detail,
    FragmentTripDetailBinding::bind
) {

    //private val tripDetail: TripDetail? by lazy { arguments?.getParcelable(KEY_TRIP_DETAIL) }
    private val args: TripDetailFragmentArgs by navArgs()

    private val tripDetailViewModel: TripDetailViewModel by viewModels()

    override fun onViewCreated(bind: FragmentTripDetailBinding, savedInstanceState: Bundle?) {
        render(args.tripDetail)

        tripDetailViewModel.startPage(args.tripDetail)
        tripDetailViewModel.tripDetailLiveData.observe(viewLifecycleOwner, {
            render(it.tripDetail)
            updateRecruitState(it.recruitmentState)
            updateApplyState(it.applyState)
        })
    }

    private fun render(tripDetail: TripDetail) = with(binding) {
        tripDetailImage.loadUrl(tripDetail.image)
        tripDetailName.text = tripDetail.title
        tvWriter.text = tripDetail.name
        tvMarker.text = tripDetail.location
        tripDetailDesc.text = tripDetail.desc
        tvCalender.text = tripDetail.date
        btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun updateRecruitState(state: RecruitmentState) {
        binding.tvRecruitment.text = state.text
    }

    private fun updateApplyState(state: ApplyState) {
        with(binding.btnApply) {
            when (state) {
                ApplyState.APPLY_CONFIRM -> {
                    text = "참여확정"
                    setTextColor(Color.parseColor("#2F80ED"))
                    background =
                        ResourcesCompat.getDrawable(resources, R.drawable.btn_apply_confirm, null)
                }
                ApplyState.APPLYING -> {
                    text = "참여취소"
                    setTextColor(Color.parseColor("#FFFFFF"))
                    background =
                        ResourcesCompat.getDrawable(resources, R.drawable.btn_apply_cancel, null)
                    setOnClickListener {
                        tripDetailViewModel.onClickCancelTrip()
                    }
                }
                ApplyState.NOT_APPLY -> {
                    text = "참여"
                    setTextColor(Color.parseColor("#FFFFFF"))
                    background = ResourcesCompat.getDrawable(resources, R.drawable.btn_apply, null)
                    setOnClickListener {
                        tripDetailViewModel.onClickApplyTrip()
                    }
                }
                ApplyState.CANCEL -> {
                    with(binding) {
                        btnApply.text = "취소"
                        btnApply.setTextColor(Color.parseColor("#BDBDBD"))
                        tripDetailName.setTextColor(Color.parseColor("#BDBDBD"))
                        tvWriter.setTextColor(Color.parseColor("#BDBDBD"))
                        tvMarker.setTextColor(Color.parseColor("#BDBDBD"))
                        tripDetailDesc.setTextColor(Color.parseColor("#BDBDBD"))
                        tvCalender.setTextColor(Color.parseColor("#BDBDBD"))
                        ivCalender.alpha = 0.5f
                        ivMarker.alpha = 0.5f
                        ivRecruitment.alpha = 0.5f
                        ivWriter.alpha = 0.5f
                        tvRecruitment.setTextColor(Color.parseColor("#BDBDBD"))
                        btnApply.background =
                            ResourcesCompat.getDrawable(resources, R.drawable.btn_apply_close, null)
                    }
                }
            }
        }
    }

}