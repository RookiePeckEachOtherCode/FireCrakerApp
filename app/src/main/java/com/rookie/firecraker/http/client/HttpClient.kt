package com.rookie.firecraker.http.client

import android.util.Log
import com.blankj.utilcode.util.PathUtils
import com.rookie.firecraker.http.intercept.HttpCacheIntercept
import com.rookie.firecraker.http.intercept.TokenIntercept
import com.tencent.mmkv.BuildConfig
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.util.concurrent.TimeUnit

class HttpClient {
    val okHttpClient: OkHttpClient by lazy {
        val cacheFile = File(PathUtils.getCachePathExternalFirst(), "cache_retrofit")
        val cache = Cache(cacheFile, 1024 * 1024 * 20) //20mb

        val builder = OkHttpClient.Builder()
            .connectTimeout(40, TimeUnit.SECONDS)
            .readTimeout(40, TimeUnit.SECONDS)
            .writeTimeout(40, TimeUnit.SECONDS)
            .addInterceptor(TokenIntercept())
            .cache(cache)
            .addInterceptor(HttpCacheIntercept())



        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor { message ->
                Log.d("Retrofit", "Retrofit =====> $message")
            }.apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            builder.addInterceptor(loggingInterceptor)
        }

        builder.build()
    }
}