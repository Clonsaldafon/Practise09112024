package ru.clonsaldafon.practise09_11_2024.data.network

import retrofit2.Response
import retrofit2.http.PUT

interface SokolService {

    @PUT("relay/1/open")
    suspend fun openIntercom(): Response<Unit>

    @PUT("sip/test/analog/1")
    suspend fun makeCall(): Response<Unit>

}