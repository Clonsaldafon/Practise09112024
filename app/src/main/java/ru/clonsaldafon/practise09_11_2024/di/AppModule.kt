package ru.clonsaldafon.practise09_11_2024.di

import dagger.Module

@Module(
    includes = [
        AppBindsModule::class,
        ViewModelModule::class,
        NetworkModule::class
    ]
)
class AppModule