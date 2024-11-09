package ru.clonsaldafon.practise09_11_2024.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create
import ru.clonsaldafon.practise09_11_2024.data.network.BewardInterceptor
import ru.clonsaldafon.practise09_11_2024.data.network.BewardService
import ru.clonsaldafon.practise09_11_2024.data.network.SokolInterceptor
import ru.clonsaldafon.practise09_11_2024.data.network.SokolService
import javax.inject.Named

@Module
abstract class NetworkModule {

    companion object {

        @Provides
        @Named("Sokol")
        fun provideSokolClient(): OkHttpClient =
            OkHttpClient
                .Builder()
                .addNetworkInterceptor(SokolInterceptor())
                .build()

        @Provides
        fun provideSokolService(
            @Named("Sokol") client: OkHttpClient
        ): SokolService =
            Retrofit
                .Builder()
                .client(client)
                .baseUrl("http://192.168.0.104/")
                .build()
                .create()

        @Provides
        @Named("Beward")
        fun provideBewardClient(): OkHttpClient =
            OkHttpClient
                .Builder()
                .addNetworkInterceptor(BewardInterceptor())
                .build()

        @Provides
        fun provideBewardService(
            @Named("Beward") client: OkHttpClient
        ): BewardService =
            Retrofit
                .Builder()
                .client(client)
                .baseUrl("http://192.168.0.105/")
                .build()
                .create()

    }

}