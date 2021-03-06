package com.fpoly.assignemnt_gd1.data.source.remote.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class AppFactory {
    companion object {
        val instance: AppService by lazy {
            retrofitBuilder().create(AppService::class.java)
        }
        private const val TIME_OUT = 15000L
        private fun client() = OkHttpClient.Builder()
            .readTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
            .writeTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
            .connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
        private fun retrofitBuilder() = Retrofit.Builder()
            .baseUrl("http://192.168.1.5:5000")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client())
            .build()
    }
}
