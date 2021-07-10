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