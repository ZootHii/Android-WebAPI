/*
package com.zoothii.ders1.notused.api

import com.zoothii.ders1.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance { // made it object because we are gonna use singleton

    private val retrofit by lazy { // https://kotlinlang.org/docs/delegated-properties.html#lazy-properties
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:5000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }
}*/
