package com.fpoly.assignemnt_gd1.data.source.remote.api

import com.fpoly.assignemnt_gd1.data.model.User
import com.fpoly.assignemnt_gd1.data.source.remote.response.BaseResponse
import com.fpoly.assignemnt_gd1.data.source.remote.response.LoginResponse
import com.fpoly.assignemnt_gd1.data.source.remote.response.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AppService {
    @FormUrlEncoded
    @POST("api/user/login")
    suspend fun login(
        @Field("user_name") userName: String,
        @Field("password") password: String
    ): BaseResponse<LoginResponse>
    @POST("api/user/register")
    suspend fun register(@Body user: User): BaseResponse<RegisterResponse>
}
