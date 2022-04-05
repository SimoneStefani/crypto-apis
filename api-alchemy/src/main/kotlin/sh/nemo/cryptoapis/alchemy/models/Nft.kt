package sh.nemo.cryptoapis.alchemy.models

import kotlinx.serialization.Serializable

@Serializable
data class Nft(
    override val contract: Contract,
    override val id: Id,
    override val balance: String,
) : AbstractNftResonse() {
    @Serializable
    data class Id(override val tokenId: String) : AbstractNftResonse.Id()
}
