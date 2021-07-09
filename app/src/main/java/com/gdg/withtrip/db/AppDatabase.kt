package com.gdg.withtrip.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gdg.withtrip.DATABASE_NAME
import com.gdg.withtrip.db.dao.PopularCardDao
import com.gdg.withtrip.ui.popular.PopularCard

@Database(
  version = 1,
  entities = [PopularCard::class]
)
abstract class AppDatabase : RoomDatabase() {
  abstract fun popularCardDao(): PopularCardDao

  companion object {
    @Volatile
    private var INSTANCE: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase =
      INSTANCE ?: synchronized(this) {
        INSTANCE
          ?: buildDatabase(
            context
          )
            .also { INSTANCE = it }
      }

    private fun buildDatabase(context: Context): AppDatabase {
      return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
        .build()
    }
  }
}