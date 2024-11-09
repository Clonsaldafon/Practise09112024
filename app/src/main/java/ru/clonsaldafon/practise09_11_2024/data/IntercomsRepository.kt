package ru.clonsaldafon.practise09_11_2024.data

import kotlinx.coroutines.delay
import ru.clonsaldafon.practise09_11_2024.data.network.SokolService
import ru.clonsaldafon.practise09_11_2024.presentation.Intercom
import javax.inject.Inject
import kotlin.random.Random

interface IntercomsRepository {

    suspend fun loadIntercoms(): List<Intercom>
    suspend fun openIntercom(intercom: Intercom)

}

class IntercomsRepositoryImpl @Inject constructor(
    private val sokolService: SokolService
) : IntercomsRepository {
    override suspend fun loadIntercoms(): List<Intercom> {
        delay(Random.nextLong(1000, 5000))
        return listOf(
            Intercom(1, "Sokol"),
            Intercom(2, "Beward")
        )
    }

    override suspend fun openIntercom(intercom: Intercom) {
        sokolService.openIntercom()
    }

}