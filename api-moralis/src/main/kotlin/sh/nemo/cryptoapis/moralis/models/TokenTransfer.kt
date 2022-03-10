package sh.nemo.cryptoapis.moralis.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TokenTransfer(
    @SerialName("transaction_hash") val transactionHash: String,
    @SerialName("token_id") val tokenId: String,
    @SerialName("from_address") val fromAddress: String,
    @SerialName("to_address") val toAddress: String,
    @SerialName("amount") val amount: Long,
)
