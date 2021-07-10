package com.gdg.withtrip.network.service

import com.gdg.withtrip.network.response.GetDuplicatedUserResponse
import com.gdg.withtrip.network.response.GetMyUserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {
    @GET("gdg/checkId")
    suspend fun getUserDuplicatedCheck(
        @Query("ID") id: String
    ): GetDuplicatedUserResponse

    @GET("gdg/getUserInfo")
    suspend fun getMyUserInfo(
        @Query("SEQ") id: String
    ): GetMyUserResponse
}