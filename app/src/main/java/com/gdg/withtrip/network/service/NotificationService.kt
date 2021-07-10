package com.gdg.withtrip.network.service

import com.gdg.withtrip.ui.notifications.Notification

interface NotificationService {
    suspend fun getAllNotification(): List<Notification>
}