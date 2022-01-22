package sh.nemo.api.debank.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProtocolTvl(
    @SerialName("date_at")
    val dateAt: LocalDate,
    @SerialName("value")
    val value: Double,
)
