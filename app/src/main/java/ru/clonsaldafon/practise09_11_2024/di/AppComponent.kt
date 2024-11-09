package ru.clonsaldafon.practise09_11_2024.di

import dagger.Component
import ru.clonsaldafon.practise09_11_2024.presentation.MainFragment

@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {

    fun inject(fragment: MainFragment)

}