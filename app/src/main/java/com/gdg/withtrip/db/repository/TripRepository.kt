package com.gdg.withtrip.db.repository

import com.gdg.withtrip.ui.popular.PopularCard

interface TripRepository {
    suspend fun insertPopularTrip(popularCard: PopularCard)
    suspend fun getLikeTripCardList(): List<PopularCard>

    suspend fun getFeedList(): List<PopularCard>

    suspend fun postTrip(
        seq: String,
        title: String,
        personCount: Int,
        startDate: String,
        endDate: String,
        location: String,
        content: String
    )
    suspend fun getFeedDetail(seq: Int): String
}