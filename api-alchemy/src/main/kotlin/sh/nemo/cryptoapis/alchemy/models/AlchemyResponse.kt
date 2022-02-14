package sh.nemo.cryptoapis.alchemy.models

import kotlinx.serialization.Serializable

@Serializable
data class AlchemyResponse<T>(val id: Int, val result: Result<T>, val jsonrpc: String = "2.0") {
    @Serializable
    data class Result<T>(val transfers: T, val pageKey: String? = null)
}
