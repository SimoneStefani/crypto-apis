package sh.nemo.cryptoapis.alchemy.models

import kotlinx.serialization.Serializable

abstract class AbstractNftResonse {
    abstract val contract: Contract
    abstract val id: Id
    abstract val balance: String

    @Serializable
    data class Contract(val address: String)

    @Serializable
    abstract class Id {abstract val tokenId: String}
}