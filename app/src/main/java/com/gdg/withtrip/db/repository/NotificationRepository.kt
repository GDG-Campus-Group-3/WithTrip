package com.gdg.withtrip.db.repository

import com.gdg.withtrip.ui.notifications.Notification

interface NotificationRepository {
    suspend fun getALlNotifications(): List<Notification>
}