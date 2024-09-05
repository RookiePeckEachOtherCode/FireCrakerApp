package com.rookie.firecraker.http.api

import com.rookie.firecraker.config.FcConfig
import com.rookie.firecraker.http.client.HttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FCApi {
    private val okHttpClient = HttpClient().okHttpClient

    private val retrofit = Retrofit.Builder()
        .baseUrl(FcConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}