package com.gdg.withtrip.db.repository

import com.gdg.withtrip.ui.mypage.UserProfileModel

interface UserRepository {
    suspend fun checkLoginUser(id: String): Boolean

    suspend fun getMyUserInfo(seq: String): UserProfileModel
}