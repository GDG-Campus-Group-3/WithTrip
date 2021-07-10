package com.gdg.withtrip.di

import com.gdg.withtrip.db.repository.NotificationRepository
import com.gdg.withtrip.db.repository.TripRepository
import com.gdg.withtrip.db.repository.impl.NotificationRepositoryImpl
import com.gdg.withtrip.db.repository.impl.TripRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindTripRepository(impl: TripRepositoryImpl): TripRepository

    @Binds
    @Singleton
    abstract fun bindNotificationRepository(impl: NotificationRepositoryImpl): NotificationRepository
}