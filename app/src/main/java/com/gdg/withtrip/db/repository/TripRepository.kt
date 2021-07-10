package com.gdg.withtrip.db.repository

import com.gdg.withtrip.ui.popular.PopularCard

interface TripRepository {
    suspend fun insertPopularTrip(popularCard: PopularCard)
    suspend fun getLikeTripCardList(): List<PopularCard>
}