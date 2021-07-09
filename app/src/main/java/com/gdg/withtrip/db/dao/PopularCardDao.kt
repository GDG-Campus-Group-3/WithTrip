package com.gdg.withtrip.db.dao

import androidx.room.*
import com.gdg.withtrip.ui.popular.PopularCard

@Dao
interface PopularCardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: PopularCard)

    @Delete
    suspend fun delete(entity: PopularCard)

    @Query("SELECT * FROM popular_card")
    suspend fun getPopularCardList(): List<PopularCard>
}