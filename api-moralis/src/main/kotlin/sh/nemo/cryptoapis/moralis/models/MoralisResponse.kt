package sh.nemo.cryptoapis.moralis.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoralisResponse<T>(
    val total: Int,
    val page: Int,
    @SerialName("page_size") val pageSize: Int,
    val cursor: String? = null,
    val result: T,
)
