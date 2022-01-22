package sh.nemo.api.etherscan.models

import com.ionspin.kotlin.bignum.integer.BigInteger
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class MinedBlock(
    val blockNumber: Long,
    val timeStamp: Int,
    @Contextual val blockReward: BigInteger
)
