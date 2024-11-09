package ru.clonsaldafon.practise09_11_2024.data.model

data class Intercom(
    val id: Int,
    val type: IntercomType,
    val snapshotUrl: String,
    val name: String
)

enum class IntercomType {
    SOKOL, BEWARD
}