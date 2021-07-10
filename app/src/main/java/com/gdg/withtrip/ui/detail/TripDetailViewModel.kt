package com.gdg.withtrip.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gdg.withtrip.db.repository.TripRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.stream.Collectors.toList
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class TripDetailViewModel @Inject constructor(
    private val tripRepository: TripRepository
) : ViewModel() {

    private val _tripDetailLiveData = MutableLiveData<DetailPageModel>()
    val tripDetailLiveData: LiveData<DetailPageModel> = _tripDetailLiveData


    fun startPage(detail: TripDetail) {
        viewModelScope.launch {
            runCatching {
                tripRepository.getFeedDetail(detail.seq)
            }.onSuccess {
                val tripDetail = detail.run {
                    TripDetail(
                        seq, image, name, location, title, it, date
                    )
                }
                _tripDetailLiveData.value = DetailPageModel(
                    tripDetail,
                    RecruitmentState.values().toList().shuffled().first(),
                    ApplyState.values().toList().shuffled().first()
                )
            }.onFailure {

            }
        }
    }

    fun onClickApplyTrip() {

    }

    fun onClickCancelTrip() {

    }

}


data class DetailPageModel(
    val tripDetail: TripDetail,
    val recruitmentState: RecruitmentState,
    val applyState: ApplyState
)

enum class RecruitmentState(val text: String) {
    COMPLETE("모집완료"), RECRUIT("모집")
}

enum class ApplyState(val text: String) {
    NOT_APPLY(""), APPLY_CONFIRM("참여확정"), APPLYING("진행중"), CANCEL("취소")
}