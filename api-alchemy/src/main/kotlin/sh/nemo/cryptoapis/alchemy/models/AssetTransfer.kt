package sh.nemo.cryptoapis.alchemy.models

import kotlinx.serialization.Serializable

@Serializable
data class AssetTransfer(
    val blockNum: String,
    val hash: String,
    val from: String,
    val to: String? = null,
    val value: Double? = null,
    val erc721TokenId: String? = null,
    val asset: String? = null,
    val category: String,
    val rawContract: RawContract
) {
    @Serializable
    data class RawContract(val value: String? = null, val address: String? = null, val decimal: String? = null)
}
