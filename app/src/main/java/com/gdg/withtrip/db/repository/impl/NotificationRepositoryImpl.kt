package com.gdg.withtrip.db.repository.impl

import com.gdg.withtrip.db.repository.NotificationRepository
import com.gdg.withtrip.network.service.NotificationService
import com.gdg.withtrip.ui.notifications.Notification
import javax.inject.Inject

class NotificationRepositoryImpl @Inject constructor(
    private val notificationService: NotificationService
) : NotificationRepository {
    override suspend fun getALlNotifications(): List<Notification> {
        return notificationService.getAllNotification()
    }
}