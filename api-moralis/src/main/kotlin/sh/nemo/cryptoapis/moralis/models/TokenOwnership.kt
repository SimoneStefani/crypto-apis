package sh.nemo.cryptoapis.moralis.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TokenOwnership(
    @SerialName("token_address") val tokenAddress: String,
    @SerialName("token_id") val tokenId: String,
    @SerialName("owner_of") val owner: String,
    @SerialName("amount") val amount: Long,
)
