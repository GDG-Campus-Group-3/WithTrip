package com.gdg.withtrip.db.repository

import com.gdg.withtrip.network.service.UserInfoResponse

interface UserRepository {
    suspend fun checkLoginUser(id: String): Boolean
    suspend fun getUserInfo(seq: Int): UserInfoResponse
}