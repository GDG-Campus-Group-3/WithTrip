package com.gdg.withtrip.db.repository.impl

import com.gdg.withtrip.db.repository.UserRepository
import com.gdg.withtrip.network.mapper.ResponseMapper
import com.gdg.withtrip.network.service.UserService
import com.gdg.withtrip.ui.mypage.UserProfileModel
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val service: UserService,
    private val responseMapper: ResponseMapper
) : UserRepository {

    override suspend fun checkLoginUser(id: String): Boolean {
        return responseMapper.mapToUserExist(service.getUserDuplicatedCheck(id))
    }

    override suspend fun getMyUserInfo(seq: String): UserProfileModel {
        return responseMapper.mapToUserInfo(service.getMyUserInfo(seq))
    }

}