package com.gdg.withtrip.di

import com.gdg.withtrip.network.NetworkClient
import com.gdg.withtrip.network.service.MapService
import com.gdg.withtrip.network.service.NotificationService
import com.gdg.withtrip.network.service.TripService
import com.gdg.withtrip.network.service.impl.MapServiceImpl
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

    @Provides
    fun provideMapService(): MapService {
        return MapServiceImpl()
    }

    @Provides
    fun provideTripService(): TripService = NetworkClient.provideService()
}