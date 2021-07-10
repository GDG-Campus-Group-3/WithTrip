package com.gdg.withtrip.network.service

import com.gdg.withtrip.network.response.GetDuplicatedUserResponse
import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {
    @GET("gdg/checkId")
    suspend fun getUserDuplicatedCheck(
        @Query("ID") id: String
    ): GetDuplicatedUserResponse

    @GET("gdg/getUserInfo")
    suspend fun getUserInfo(
        @Query("SEQ") seq: Int
    ): UserInfoResponse
}

data class UserInfoResponse(
    @SerializedName("R") val r: R
) {
    data class R(
        @SerializedName("NICKNAME")
        val nickname: String,
        @SerializedName("EX")
        val ex: String
    )
}