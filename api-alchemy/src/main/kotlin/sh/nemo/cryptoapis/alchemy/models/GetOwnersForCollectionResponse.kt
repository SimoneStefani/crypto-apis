package sh.nemo.cryptoapis.alchemy.models

import kotlinx.serialization.Serializable

@Serializable
data class GetOwnersForCollectionResponse(
    val contractAddress: List<String>
)