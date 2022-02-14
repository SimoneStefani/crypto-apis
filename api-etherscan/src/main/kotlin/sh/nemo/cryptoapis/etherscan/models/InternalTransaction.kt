package sh.nemo.cryptoapis.etherscan.models

import com.ionspin.kotlin.bignum.integer.BigInteger
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InternalTransaction(
    val blockNumber: Long,
    val timeStamp: Int,
    val hash: String? = null,
    val from: String,
    val to: String,
    @Contextual val value: BigInteger,
    val gas: Long,
    val gasUsed: Long,
    val input: String? = null,
    val type: String,
    val contractAddress: String?,
    val traceId: String? = null,
    val isError: String,
    val errCode: String,
)
