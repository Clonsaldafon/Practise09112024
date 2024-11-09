package ru.clonsaldafon.practise09_11_2024.data

import kotlinx.coroutines.delay
import ru.clonsaldafon.practise09_11_2024.data.model.Intercom
import ru.clonsaldafon.practise09_11_2024.data.model.IntercomType
import ru.clonsaldafon.practise09_11_2024.data.network.BewardService
import ru.clonsaldafon.practise09_11_2024.data.network.SokolService
import javax.inject.Inject
import kotlin.random.Random

interface IntercomsRepository {

    suspend fun loadIntercoms(): List<Intercom>
    suspend fun openIntercom(intercom: Intercom)
    suspend fun callIntercom(intercom: Intercom)
    suspend fun snapshotIntercom(intercom: Intercom)

}

class IntercomsRepositoryImpl @Inject constructor(
    private val sokolService: SokolService,
    private val bewardService: BewardService
) : IntercomsRepository {
    override suspend fun loadIntercoms(): List<Intercom> {
        delay(Random.nextLong(1000, 5000))
        return listOf(
            Intercom(
                1,
                IntercomType.SOKOL,
                "http://192.168.0.104/camera/snapshot",
                "Sokol"
            ),
            Intercom(
                2,
                IntercomType.BEWARD,
                "http://192.168.0.105/cgi-bin/images_cgi",
                "Beward"
            )
        )
    }

    override suspend fun openIntercom(intercom: Intercom) {
        when(intercom.type) {
            IntercomType.SOKOL -> sokolService.openIntercom()
            IntercomType.BEWARD -> bewardService.openIntercom()
        }
    }

    override suspend fun callIntercom(intercom: Intercom) {
        when(intercom.type) {
            IntercomType.SOKOL -> sokolService.makeCall()
            IntercomType.BEWARD -> TODO()
        }
    }

    override suspend fun snapshotIntercom(intercom: Intercom) {
        when(intercom.type) {
            IntercomType.SOKOL -> sokolService.snapshotIntercom()
            IntercomType.BEWARD -> TODO()
        }
    }

}