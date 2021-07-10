package com.gdg.withtrip.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gdg.withtrip.db.repository.NotificationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotificationsViewModel @Inject constructor(
    private val notificationRepository: NotificationRepository
) : ViewModel() {

    private val _notificationListLiveData = MutableLiveData<List<Notification>>()
    val notificationListLiveData: LiveData<List<Notification>> get() = _notificationListLiveData

    init {
        viewModelScope.launch {
            runCatching {
                notificationRepository.getALlNotifications()
            }.onSuccess {
                _notificationListLiveData.postValue(it)
            }.onFailure {

            }
        }
    }
}