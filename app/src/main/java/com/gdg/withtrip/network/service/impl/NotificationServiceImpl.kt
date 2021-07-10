package com.gdg.withtrip.network.service.impl

import com.gdg.withtrip.network.service.NotificationService
import com.gdg.withtrip.ui.MockData
import com.gdg.withtrip.ui.notifications.Notification

class NotificationServiceImpl : NotificationService {
    override suspend fun getAllNotification(): List<Notification> {
        return MockData.getNotificationList()
    }
}