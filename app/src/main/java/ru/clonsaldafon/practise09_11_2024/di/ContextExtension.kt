package ru.clonsaldafon.practise09_11_2024.di

import android.content.Context
import ru.clonsaldafon.practise09_11_2024.MyApplication

val Context.appComponent: AppComponent
    get() = when(this) {
        is MyApplication -> appComponent
        else -> applicationContext.appComponent
    }
