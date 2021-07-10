package com.gdg.withtrip.network.service

import com.gdg.withtrip.network.response.GetBoardListResponse
import retrofit2.http.GET

interface TripService {

    @GET("gdg/getBoardList")
    suspend fun getFeedList(): GetBoardListResponse
}