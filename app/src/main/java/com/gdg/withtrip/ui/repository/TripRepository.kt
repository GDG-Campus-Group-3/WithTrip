package com.gdg.withtrip.ui.repository

import com.gdg.withtrip.ui.popular.PopularCard

interface TripRepository {
    suspend fun insertPopularTrip(popularCard: PopularCard)
}