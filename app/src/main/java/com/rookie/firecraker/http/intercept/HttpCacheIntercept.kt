package com.rookie.firecraker.http.intercept

import okhttp3.Interceptor
import okhttp3.Response

class HttpCacheIntercept : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        var cacheTime = request.header("cache");
        val cacheControl = request.header("Cache-Control");

        if (cacheControl == null && cacheTime.isNullOrEmpty()) {
            cacheTime = "${30}" //30s
        }

        return response.newBuilder()
            .header("Cache-Control", "public, max-age=$cacheTime")
            .removeHeader("Pragma")
            .build()
    }
}