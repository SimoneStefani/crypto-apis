package sh.nemo.api.debank.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Protocol(
    @SerialName("id")
    val id: String,
    @SerialName("chain")
    val chain: Chain.ChainId,
    @SerialName("name")
    val name: String,
    @SerialName("logo_url")
    val logoUrl: String? = null,
    @SerialName("site_url")
    val siteUrl: String,
    @SerialName("has_supported_portfolio")
    val hasSupportedPortfolio: Boolean,
    @SerialName("tvl")
    val tvl: Double,
    @SerialName("portfolio_item_list")
    val portfolioItemList: List<Item>? = null
) {
    @Serializable
    data class Item(
        @SerialName("name")
        val name: String,
        @SerialName("stats")
        val stats: Stats,
//        @SerialName("update_at")
//        val updateAt: Double, // FIXME
        @SerialName("detail_types")
        val detailTypes: List<String>,
        @SerialName("detail")
        val detail: Detail,
    ) {
        @Serializable
        data class Stats(
            @SerialName("asset_usd_value")
            val assetUsdValue: Double,
            @SerialName("debt_usd_value")
            val debtUsdValue: Double,
            @SerialName("net_usd_value")
            val netUsdValue: Double,
        )

        @Serializable
        data class Detail(
            @SerialName("token_list")
            val tokenList: List<Token>? = null,
            @SerialName("supply_token_list")
            val supplyTokenList: List<Token>? = null,
            @SerialName("reward_token_list")
            val rewardTokenList: List<Token>? = null,
            @SerialName("token")
            val token: Token? = null,
            @SerialName("description")
            val description: String? = null,
            @SerialName("daily_unlock_amount")
            val dailyUnlockAmount: Double? = null,
            @SerialName("end_at")
            val endAt: Double? = null,
        )
    }
}
