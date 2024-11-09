package ru.clonsaldafon.practise09_11_2024.data.network

import okhttp3.Interceptor
import okhttp3.Response

class BewardInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        chain
            .request()
            .newBuilder()
            .addHeader("Authorization", "Basic YWRtaW46YWRtaW4=")
            .build()
            .apply {
                return chain.proceed(this)
            }
    }

}