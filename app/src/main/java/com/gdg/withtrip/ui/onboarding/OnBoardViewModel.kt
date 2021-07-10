package com.gdg.withtrip.ui.onboarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gdg.withtrip.base.ViewState
import com.gdg.withtrip.db.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _isUserExistLiveData = MutableLiveData<ViewState<Boolean>>()
    val isUserExistLiveData: LiveData<ViewState<Boolean>> get() = _isUserExistLiveData

    fun isUserExist(id: String) = viewModelScope.launch {
        _isUserExistLiveData.postValue(ViewState.Loading)
        runCatching {
            userRepository.checkLoginUser(id)
        }.onSuccess {
            _isUserExistLiveData.postValue(ViewState.Success(it))
        }.onFailure {
            _isUserExistLiveData.postValue(ViewState.Failure("로그인에 실패하였습니다"))
        }
    }
}