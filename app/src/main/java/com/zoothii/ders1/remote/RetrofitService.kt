package com.zoothii.ders1.remote

import com.zoothii.ders1.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private val okHttpClient: OkHttpClient = OkHttpClient()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()


    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }

}