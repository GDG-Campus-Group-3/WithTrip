package com.gdg.withtrip.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.stream.Collectors.toList

class TripDetailViewModel : ViewModel() {

    private val _tripDetailLiveData = MutableLiveData<DetailPageModel>()
    val tripDetailLiveData: LiveData<DetailPageModel> = _tripDetailLiveData


    fun startPage(detail: TripDetail){
        _tripDetailLiveData.value = DetailPageModel(
            detail,
            RecruitmentState.values().toList().shuffled().first(),
            ApplyState.values().toList().shuffled().first()
        )
    }

    fun onClickApplyTrip(){

    }

    fun onClickCancelTrip(){

    }

}


data class DetailPageModel(
    val tripDetail: TripDetail,
    val recruitmentState: RecruitmentState,
    val applyState :ApplyState
)
enum class RecruitmentState(val text :String){
    COMPLETE("모집완료"), RECRUIT("모집"), CANCEL("모집취소")
}

enum class ApplyState{
    NOT_APPLY, APPLY_CONFIRM, APPLY_WAIT
}