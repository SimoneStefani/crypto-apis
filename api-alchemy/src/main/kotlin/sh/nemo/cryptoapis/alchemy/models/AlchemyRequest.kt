package sh.nemo.cryptoapis.alchemy.models

import kotlinx.serialization.Serializable

@Serializable
data class AlchemyRequest(
    val jsonrpc: String,
    val id: Int,
    val method: String,
    val params: List<AlchemyParams>
)
