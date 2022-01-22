package sh.nemo.api.etherscan.models

import kotlinx.serialization.Serializable

@Serializable
data class EtherscanResponse<T>(
    val status: String,
    val message: String,
    val result: T
)
