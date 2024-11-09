package ru.clonsaldafon.practise09_11_2024.di

import dagger.Binds
import dagger.Module
import ru.clonsaldafon.practise09_11_2024.data.IntercomsRepository
import ru.clonsaldafon.practise09_11_2024.data.IntercomsRepositoryImpl

@Module
interface AppBindsModule {

    @Binds
    fun bindIntercomRepository(repositoryImpl: IntercomsRepositoryImpl): IntercomsRepository

}