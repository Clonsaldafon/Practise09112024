package ru.clonsaldafon.practise09_11_2024.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create
import ru.clonsaldafon.practise09_11_2024.data.network.SokolInterceptor
import ru.clonsaldafon.practise09_11_2024.data.network.SokolService

@Module
abstract class NetworkModule {

    companion object {

        @Provides
        fun provideSokolClient(): OkHttpClient =
            OkHttpClient
                .Builder()
                .addNetworkInterceptor(SokolInterceptor())
                .build()

        @Provides
        fun provideSokolService(
            client: OkHttpClient
        ): SokolService =
            Retrofit
                .Builder()
                .client(client)
                .baseUrl("http://192.168.0.104/")
                .build()
                .create()

    }

}