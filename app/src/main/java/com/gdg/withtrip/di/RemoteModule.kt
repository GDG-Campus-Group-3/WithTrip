package com.gdg.withtrip.di

import com.gdg.withtrip.network.service.NotificationService
import com.gdg.withtrip.network.service.impl.NotificationServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    fun provideNotificationService(): NotificationService {
        return NotificationServiceImpl()
    }
}