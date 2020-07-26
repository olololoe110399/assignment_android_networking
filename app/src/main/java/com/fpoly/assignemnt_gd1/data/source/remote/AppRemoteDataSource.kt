package com.fpoly.assignemnt_gd1.data.source.remote

import com.fpoly.assignemnt_gd1.data.model.User
import com.fpoly.assignemnt_gd1.data.source.AppDataSource
import com.fpoly.assignemnt_gd1.data.source.remote.api.AppService
import com.fpoly.assignemnt_gd1.data.source.remote.response.BaseResponse
import com.fpoly.assignemnt_gd1.data.source.remote.response.LoginResponse
import com.fpoly.assignemnt_gd1.data.source.remote.response.RegisterResponse

class AppRemoteDataSource private constructor(private val appService: AppService) :
    AppDataSource.Remote {
    override suspend fun login(userName: String, password: String): BaseResponse<LoginResponse> {
        return appService.login(userName, password)
    }

    override suspend fun register(user: User): BaseResponse<RegisterResponse> {
        return appService.register(user)
    }

    companion object {
        private var INSTANCE: AppRemoteDataSource? = null
        fun getInstance(appService: AppService): AppRemoteDataSource =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: AppRemoteDataSource(appService).also { INSTANCE = it }
            }
    }
}