package com.gdg.withtrip.db.repository.impl

import com.gdg.withtrip.KEY_SEQ
import com.gdg.withtrip.db.dao.PopularCardDao
import com.gdg.withtrip.db.repository.TripRepository
import com.gdg.withtrip.network.mapper.ResponseMapper
import com.gdg.withtrip.network.service.TripService
import com.gdg.withtrip.ui.popular.PopularCard
import com.gdg.withtrip.util.Prefs
import javax.inject.Inject


class TripRepositoryImpl @Inject constructor(
    private val popularCardDao: PopularCardDao,
    private val tripService: TripService,
    private val mapper: ResponseMapper
): TripRepository {
    override suspend fun insertPopularTrip(popularCard: PopularCard) {
        popularCardDao.insert(popularCard)
    }

    override suspend fun getLikeTripCardList(): List<PopularCard> {
        return popularCardDao.getPopularCardList()
    }

    override suspend fun getFeedList(): List<PopularCard> {
        return mapper.boardListToTripList(tripService.getFeedList())
    }

    override suspend fun postTrip(
        seq: String,
        title: String,
        personCount: Int,
        startDate: String,
        endDate: String,
        location: String,
        content: String
    ) {
        tripService.postTrip(
            seq = Prefs.getString(KEY_SEQ),
            title = title,
            locationName = "Unknown",
            startDate = startDate,
            endDate = endDate,
            count = personCount,
            content = content
        )
    }
}