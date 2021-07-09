package com.gdg.withtrip.ui.popular

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "popular_card")
data class PopularCard(
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "subtitle") val subtitle: String,
    @ColumnInfo(name = "image") val image: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)