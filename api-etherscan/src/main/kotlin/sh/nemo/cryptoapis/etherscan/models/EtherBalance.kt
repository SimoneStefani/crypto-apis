package sh.nemo.cryptoapis.etherscan.models

import com.ionspin.kotlin.bignum.integer.BigInteger
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class EtherBalance(val account: String, @Contextual val balance: BigInteger)
