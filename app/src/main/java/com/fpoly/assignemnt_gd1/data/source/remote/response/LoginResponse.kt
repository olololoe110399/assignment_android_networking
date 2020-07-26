package com.fpoly.assignemnt_gd1.data.source.remote.response

import com.fpoly.assignemnt_gd1.data.model.User
import com.google.gson.annotations.SerializedName

data class LoginResponse(@SerializedName("user") val user: User)
