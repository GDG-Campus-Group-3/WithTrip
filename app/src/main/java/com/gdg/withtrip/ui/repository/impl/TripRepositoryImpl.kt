package com.gdg.withtrip.ui.repository.impl

import com.gdg.withtrip.db.dao.PopularCardDao
import com.gdg.withtrip.ui.popular.PopularCard
import com.gdg.withtrip.ui.repository.TripRepository
import javax.inject.Inject


class TripRepositoryImpl @Inject constructor(
    private val popularCardDao: PopularCardDao
): TripRepository {
    override suspend fun insertPopularTrip(popularCard: PopularCard) {
        popularCardDao.insert(popularCard)
    }
}