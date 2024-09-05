package com.rookie.firecraker.http.intercept

import okhttp3.Interceptor
import okhttp3.Response

class TokenIntercept : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        //TODO get token
        val token = ""
        if (token.isNotEmpty()) {
            val request = chain.request()
            val url = if (request.url.toString().contains("?")) {
                request.url.toString() + "&token=" + token
            } else {
                request.url.toString() + "?token=" + token
            }
            val builder = request.newBuilder()
            builder.get().url(url)
            val newRequest = builder.build()
            return chain.proceed(newRequest);
        }
        return chain.proceed(chain.request())
    }
}