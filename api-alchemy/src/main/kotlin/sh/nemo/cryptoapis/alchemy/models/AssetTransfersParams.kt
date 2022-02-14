package sh.nemo.cryptoapis.alchemy.models

import kotlinx.serialization.Serializable

@Serializable
data class AssetTransfersParams(
    val fromBlock: String? = null,
    val toBlock: String? = null,
    val fromAddress: String? = null,
    val toAddress: String? = null,
    val contractAddresses: List<String>? = null,
    val category: List<String> = listOf("external", "internal", "token"),
    val maxCount: String = "0x3e8",
    val pageKey: String? = null,
) : AlchemyParams
