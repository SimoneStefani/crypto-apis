package sh.nemo.api.debank.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Token(
    @SerialName("id")
    val id: String,
    @SerialName("chain")
    val chain: Chain.ChainId,
    @SerialName("name")
    val name: String,
    @SerialName("symbol")
    val symbol: String,
    @SerialName("display_symbol")
    val displaySymbol: String? = null,
    @SerialName("optimized_symbol")
    val optimizedSymbol: String,
    @SerialName("decimals")
    val decimals: Int,
    @SerialName("logo_url")
    val logoUrl: String,
    @SerialName("protocol_id")
    val protocolId: String,
    @SerialName("price")
    val price: Double,
    @SerialName("is_verified")
    val isVerified: Boolean,
    @SerialName("is_core")
    val isCore: Boolean,
    @SerialName("is_wallet")
    val isWallet: Boolean,
//    @SerialName("time_at")
//    val timeAt: Instant
    @SerialName("amount")
    val amount: Double? = null,
    @SerialName("claimable_amount")
    val claimableAmount: Double? = null,
)
