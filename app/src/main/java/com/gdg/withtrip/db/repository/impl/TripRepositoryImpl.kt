package com.gdg.withtrip.db.repository.impl

import com.gdg.withtrip.db.dao.PopularCardDao
import com.gdg.withtrip.db.repository.TripRepository
import com.gdg.withtrip.ui.popular.PopularCard
import javax.inject.Inject


class TripRepositoryImpl @Inject constructor(
    private val popularCardDao: PopularCardDao
): TripRepository {
    override suspend fun insertPopularTrip(popularCard: PopularCard) {
        popularCardDao.insert(popularCard)
    }

    override suspend fun getLikeTripCardList(): List<PopularCard> {
        return popularCardDao.getPopularCardList()
    }
}