package ru.clonsaldafon.practise09_11_2024.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BewardService {

    @GET("cgi-bin/intercom_cgi")
    suspend fun openIntercom(
        @Query("action") action: String = "maindoor"
    ): Response<Unit>

}