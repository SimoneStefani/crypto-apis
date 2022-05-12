package sh.nemo.cryptoapis.alchemy.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class NftWithMetadata(
    override val contract: Contract,
    override val id: Id,
    override val balance: String? = null,

    val title: String? = null,
    val description: String? = null,
    val tokenUri: Resource,
    val media: List<Resource>,
    val metadata: Metadata,
) : AbstractNftResonse() {

    @Serializable
    data class Id(override val tokenId: String, val tokenMetadata: TokenMetadata? = null) : AbstractNftResonse.Id()

    @Serializable
    data class TokenMetadata(val tokenType: TokenType? = null)

    @Serializable
    enum class TokenType {
        ERC721, ERC1155
    }

    @Serializable
    data class Resource(val raw: String, val gateway: String? = null)

    @Serializable
    data class Metadata(
        val name: String? = null,
        val description: String? = null,
        val image: String? = null,
        @SerialName("external_url")
        val externalUrl: String? = null,
        val attributes: JsonElement? = null
    )

    @Serializable
    data class Attribute(
        @SerialName("trait_type")
        val traitType: String,
        val value: String
    )
}
