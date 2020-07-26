package com.fpoly.assignemnt_gd1.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("user_name")
    val userName: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("role_id")
    val roleId: Int
)