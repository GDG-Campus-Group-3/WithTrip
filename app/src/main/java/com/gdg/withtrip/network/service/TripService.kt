package com.gdg.withtrip.network.service

import com.gdg.withtrip.network.response.GetBoardListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TripService {

    @GET("gdg/getBoardList")
    suspend fun getFeedList(): GetBoardListResponse

    @GET("gdg/newBoard")
    suspend fun postTrip(
        @Query("USER_SEQ") seq: String,
        @Query("TITLE") title: String,
        @Query("LOCATION_NAME") locationName: String,
        @Query("START_DATE") startDate: String,
        @Query("END_DATE") endDate: String,
        @Query("COUNT") count: Int,
        @Query("CONTENT") content: String,
    ): GetBoardListResponse
}