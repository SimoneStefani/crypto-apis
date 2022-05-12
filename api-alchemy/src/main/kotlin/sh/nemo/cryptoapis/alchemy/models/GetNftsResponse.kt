package sh.nemo.cryptoapis.alchemy.models

import kotlinx.serialization.Serializable

@Serializable
data class GetNftsResponse<T: AbstractNftResonse>(
    val ownedNfts: List<T> = emptyList(),
    val totalCount: Long,
    val blockHash: String? = null,
    val pageKey: String? = null
)
