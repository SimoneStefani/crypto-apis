package sh.nemo.cryptoapis.etherscan.models

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class AddressBalances(
    val products: List<Product> = emptyList(),
    val meta: List<Meta> = emptyList(),
) {
    @Serializable
    data class Product(
        val label: String,
        val assets: List<Asset> = emptyList(),
        val meta: List<Meta> = emptyList()
    ) {
        @Serializable
        data class Asset(
            val type: String,
            val category: String,
            val address: String,
            val symbol: String,
            val decimals: Int,
            val label: String,
            val img: String,
            val hide: Boolean,
            val canExchange: Boolean,
            val price: Double,
            val balance: Double,
            val balanceRaw: String,
            val balanceUSD: Double,
        )
    }

    @Serializable
    data class Meta(
        val label: String,
        @Contextual val value: BigDecimal,
        val type: String
    )
}
