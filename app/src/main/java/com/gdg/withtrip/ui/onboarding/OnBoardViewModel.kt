package com.gdg.withtrip.ui.onboarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gdg.withtrip.db.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _isUserExistLiveData = MutableLiveData<Boolean>()
    val isUserExistLiveData: LiveData<Boolean> get() = _isUserExistLiveData

    fun isUserExist(id: String) = viewModelScope.launch {
        runCatching {
            userRepository.checkLoginUser(id)
        }.onSuccess {
            _isUserExistLiveData.postValue(it)
        }.onFailure {

        }
    }
}