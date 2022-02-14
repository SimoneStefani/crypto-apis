package sh.nemo.cryptoapis.etherscan.models

import com.ionspin.kotlin.bignum.integer.BigInteger
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Transaction(
    val blockNumber: Long,
    val timeStamp: Int,
    val hash: String,
    val nonce: Long? = null,
    val blockHash: String? = null,
    val transactionIndex: Int? = null,
    val from: String,
    val to: String,
    @Contextual val value: BigInteger,
    @Contextual val gasPrice: BigInteger? = null,
    val gas: Long,
    val cumulativeGasUsed: Long? = null,
    val gasUsed: Long,
    val input: String? = null,
    val contractAddress: String?,
    val isError: String,
    @Contextual val confirmations: BigInteger? = null,
    @SerialName("txreceipt_status") val txreceiptStatus: String? = null
)
