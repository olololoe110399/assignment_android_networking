package com.fpoly.assignemnt_gd1.data.source

import com.fpoly.assignemnt_gd1.data.model.User
import com.fpoly.assignemnt_gd1.data.source.remote.response.BaseResponse
import com.fpoly.assignemnt_gd1.data.source.remote.response.LoginResponse
import com.fpoly.assignemnt_gd1.data.source.remote.response.RegisterResponse

interface AppDataSource {
    /**
     * Remote
     */
    interface Remote {
        suspend fun login(userName: String, password: String): BaseResponse<LoginResponse>
        suspend fun register(user: User): BaseResponse<RegisterResponse>
    }
}
