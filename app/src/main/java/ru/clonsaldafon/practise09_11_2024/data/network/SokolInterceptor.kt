package ru.clonsaldafon.practise09_11_2024.data.network

import okhttp3.Interceptor
import okhttp3.Response

class SokolInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        chain
            .request()
            .newBuilder()
            .addHeader("Authorization", "Basic cm9vdDoxMjM0NTY=")
            .build()
            .apply {
                return chain.proceed(this)
            }
    }

}