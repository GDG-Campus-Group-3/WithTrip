package com.gdg.withtrip.db.repository

interface UserRepository {
    suspend fun checkLoginUser(id: String): Boolean
}