package sh.nemo.cryptoapis.alchemy.models

import kotlinx.serialization.Serializable

@Serializable
data class GetNftsResponse<T: AbstractNftResonse>(
    val ownedNfts: List<T>,
    val totalCount: Long,
    val blockHash: String
)