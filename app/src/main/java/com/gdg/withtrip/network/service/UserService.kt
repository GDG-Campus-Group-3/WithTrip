package com.gdg.withtrip.network.service

import com.gdg.withtrip.network.response.GetDuplicatedUserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {
    @GET("gdg/checkId")
    suspend fun getUserDuplicatedCheck(
        @Query("ID") id: String
    ): GetDuplicatedUserResponse
}