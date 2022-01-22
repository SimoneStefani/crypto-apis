package sh.nemo.api.debank.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Chain(
    @SerialName("id")
    val id: ChainId,
    @SerialName("community_id")
    val communityId: Long,
    @SerialName("name")
    val name: String,
    @SerialName("native_token_id")
    val nativeTokenId: String,
    @SerialName("logo_url")
    val logoUrl: String,
    @SerialName("wrapped_token_id")
    val wrappedTokenId: String,
) {
    @Serializable
    enum class ChainId {
        @SerialName("eth")
        ETH,
        @SerialName("bsc")
        BSC,
        @SerialName("xdai")
        XDAI,
        @SerialName("matic")
        MATIC,
        @SerialName("ftm")
        FTM,
        @SerialName("okt")
        OKT,
        @SerialName("heco")
        HECO,
        @SerialName("avax")
        AVAX,
        @SerialName("op")
        OP,
        @SerialName("arb")
        ARB,
        @SerialName("celo")
        CELO,
        @SerialName("movr")
        MOVR,
        @SerialName("cro")
        CRO,
        @SerialName("boba")
        BOBA,
        @SerialName("metis")
        METIS,
        @SerialName("btt")
        BTT,
        @SerialName("aurora")
        AURORA,
        @SerialName("mobm")
        MOBM
    }

    @Serializable
    data class UserBalance(@SerialName("usd_value") val usdValue: Double)
}
