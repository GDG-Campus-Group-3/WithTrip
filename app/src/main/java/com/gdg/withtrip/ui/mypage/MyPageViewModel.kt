package com.gdg.withtrip.ui.mypage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gdg.withtrip.KEY_SEQ
import com.gdg.withtrip.base.ViewState
import com.gdg.withtrip.db.repository.UserRepository
import com.gdg.withtrip.util.Prefs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _loginState : MutableLiveData<LoginState> = MutableLiveData(LoginState.LOGOUT)
    val loginState : LiveData<LoginState> = _loginState

    private val _profile: MutableLiveData<ViewState<UserProfileModel>> = MutableLiveData(
        /*UserProfileModel(
            "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile7.uf.tistory.com%2Fimage%2F993745425A80274C0E0C7A",
            "3조"
        )*/
    )
    val profile: LiveData<ViewState<UserProfileModel>> = _profile

    init {
        _loginState.value = LoginState.LOGIN

        viewModelScope.launch {
            runCatching {
                userRepository.getMyUserInfo(Prefs.getString(KEY_SEQ))
            }.onSuccess {
                _profile.postValue(ViewState.Success(it))
            }.onFailure {
                _profile.postValue(ViewState.Failure(it.message ?: ""))
            }
        }
    }
}

enum class LoginState{
    LOGIN, LOGOUT
}

data class UserProfileModel(
    val profileImage: String,
    val name: String
)