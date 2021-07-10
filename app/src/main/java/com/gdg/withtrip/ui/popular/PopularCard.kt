package com.gdg.withtrip.ui.popular

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gdg.withtrip.ui.detail.ApplyState


@Entity(tableName = "popular_card")
data class PopularCard(
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "writer") val writer: String,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "place") val place: String,
    @ColumnInfo(name = "people") val people: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "apply_state") val state: ApplyState,
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "subtitle") val subtitle: String = "",
)

