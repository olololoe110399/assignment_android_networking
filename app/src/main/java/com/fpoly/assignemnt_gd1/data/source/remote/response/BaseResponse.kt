package com.fpoly.assignemnt_gd1.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class BaseResponse<Data : Any>(
    @SerializedName("data") private val data: Data,
    @SerializedName("messages") val messages: String,
    @SerializedName("status_code") val statusCode: Int
) {
    fun unwrap(): Data {
        return if (statusCode == 200) data
        else throw Throwable(messages)
    }
}
