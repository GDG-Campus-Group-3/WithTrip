package com.gdg.withtrip.ui.mypage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyPageViewModel : ViewModel() {

    private val _loginState : MutableLiveData<LoginState> = MutableLiveData(LoginState.LOGOUT)
    val loginState : LiveData<LoginState> = _loginState

    private val _profile: MutableLiveData<UserProfileModel> = MutableLiveData(
        UserProfileModel(
            "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile7.uf.tistory.com%2Fimage%2F993745425A80274C0E0C7A",
            "3조"
        )
    )
    val profile: LiveData<UserProfileModel> = _profile

    init {
        _loginState.value = LoginState.LOGOUT
    }


}

enum class LoginState{
    LOGIN, LOGOUT
}

data class UserProfileModel(
    val profileImage: String,
    val name: String
)