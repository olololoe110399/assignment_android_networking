package com.fpoly.assignemnt_gd1.data.repository

import com.fpoly.assignemnt_gd1.data.model.User
import com.fpoly.assignemnt_gd1.data.source.AppDataSource
import com.fpoly.assignemnt_gd1.data.source.remote.response.BaseResponse
import com.fpoly.assignemnt_gd1.data.source.remote.response.LoginResponse
import com.fpoly.assignemnt_gd1.data.source.remote.response.RegisterResponse

class AppRepository private constructor(
    private val remote: AppDataSource.Remote
) {
    suspend fun login(userName: String, password: String): BaseResponse<LoginResponse> {
        return remote.login(userName, password)
    }

    suspend fun register(user: User): BaseResponse<RegisterResponse> {
        return remote.register(user)
    }

    companion object {
        private var INSTANCE: AppRepository? = null
        fun getInstance(remote: AppDataSource.Remote) =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: AppRepository(remote).also { INSTANCE = it }
            }
    }
}