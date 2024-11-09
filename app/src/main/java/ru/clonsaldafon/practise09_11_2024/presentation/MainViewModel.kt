package ru.clonsaldafon.practise09_11_2024.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(): ViewModel() {

    private val _intercoms = MutableLiveData<List<Intercom>>()
    val intercoms: LiveData<List<Intercom>>
        get() = _intercoms

    init {
        loadIntercoms()
    }

    fun loadIntercoms() {
        _intercoms.postValue(
            listOf(
                Intercom(1, "Beward"),
                Intercom(2, "Sokol"),
            )
        )
    }

}