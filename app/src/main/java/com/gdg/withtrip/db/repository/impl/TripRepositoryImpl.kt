package com.gdg.withtrip.db.repository.impl

import com.gdg.withtrip.db.dao.PopularCardDao
import com.gdg.withtrip.db.repository.TripRepository
import com.gdg.withtrip.network.mapper.ResponseMapper
import com.gdg.withtrip.network.service.TripService
import com.gdg.withtrip.ui.popular.PopularCard
import javax.inject.Inject


class TripRepositoryImpl @Inject constructor(
    private val popularCardDao: PopularCardDao,
    private val tripService: TripService,
    private val mapper: ResponseMapper
) : TripRepository {
    override suspend fun insertPopularTrip(popularCard: PopularCard) {
        popularCardDao.insert(popularCard)
    }

    override suspend fun getLikeTripCardList(): List<PopularCard> {
        return popularCardDao.getPopularCardList()
    }

    override suspend fun getFeedList(): List<PopularCard> {
        return mapper.boardListToTripList(tripService.getFeedList())
    }

    override suspend fun getFeedDetail(seq: Int): String =
        tripService.getFeedDetail(seq).r?.content ?: ""
}