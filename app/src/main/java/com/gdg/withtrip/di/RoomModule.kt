package com.gdg.withtrip.di

import android.content.Context
import com.gdg.withtrip.db.AppDatabase
import com.gdg.withtrip.db.dao.PopularCardDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    fun providePopularCardDao(@ApplicationContext context: Context): PopularCardDao {
        return AppDatabase.getInstance(context).popularCardDao()
    }
}