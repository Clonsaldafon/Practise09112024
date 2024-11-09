package ru.clonsaldafon.practise09_11_2024.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.clonsaldafon.practise09_11_2024.data.IntercomsRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: IntercomsRepository
): ViewModel() {

    private val _intercoms = MutableLiveData<List<Intercom>>()
    val intercoms: LiveData<List<Intercom>>
        get() = _intercoms

    init {
        loadIntercoms()
    }

    fun loadIntercoms() {
        viewModelScope.launch {
            val intercomsList = repository.loadIntercoms()
            _intercoms.postValue(intercomsList)
        }
    }

    fun openIntercom(intercom: Intercom) {
        viewModelScope.launch {
            repository.openIntercom(intercom)
        }
    }

}