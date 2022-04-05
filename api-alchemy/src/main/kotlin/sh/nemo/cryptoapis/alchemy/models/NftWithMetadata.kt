package sh.nemo.cryptoapis.alchemy.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class NftWithMetadata(
    override val contract: Contract,
    override val id: Id,
    override val balance: String,

    val title: String,
    val description: String,
    val tokenUri: Resource,
    val media: List<Resource>,
    val metadata: Metadata,
) : AbstractNftResonse() {

    @Serializable
    data class Id(override val tokenId: String, val tokenMetadata: TokenMetadata) : AbstractNftResonse.Id()

    @Serializable
    data class TokenMetadata(val tokenType: TokenType)

    @Serializable
    enum class TokenType {
        ERC721, ERC1155
    }

    @Serializable
    data class Resource(val raw: String, val gateway: String)

    @Serializable
    data class Metadata(
        val name: String,
        val description: String,
        val image: String,
        @SerialName("external_url")
        val externalUrl: String? = null,
        val attributes: JsonElement
    )

    @Serializable
    data class Attribute(
        @SerialName("trait_type")
        val traitType: String,
        val value: String
    )
}
