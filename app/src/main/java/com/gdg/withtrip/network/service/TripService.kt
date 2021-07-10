package com.gdg.withtrip.network.service

import com.gdg.withtrip.network.response.GetBoardListResponse
import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Query

interface TripService {

    @GET("gdg/getBoardList")
    suspend fun getFeedList(): GetBoardListResponse

    @GET("gdg/getBoardDetail")
    suspend fun getFeedDetail(
        @Query("SEQ") seq :Int
    ) :BoardDetailResponse

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



data class BoardDetailResponse(
    @SerializedName("R")
    val r: R?
) {
    data class R(
        @SerializedName("CONTENT")
        val content: String?,
    )


}