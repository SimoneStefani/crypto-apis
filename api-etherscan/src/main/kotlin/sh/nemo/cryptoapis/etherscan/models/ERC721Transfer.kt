package sh.nemo.cryptoapis.etherscan.models

import com.ionspin.kotlin.bignum.integer.BigInteger
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ERC721Transfer(
    val hash: String,
    val timeStamp: Int,
    val blockNumber: Long,

    val nonce: Long? = null,
    val blockHash: String? = null,
    val transactionIndex: Int? = null,

    val from: String,
    val to: String,

    val input: String? = null,

    @Contextual val gasPrice: BigInteger,
    val gas: Long,
    val cumulativeGasUsed: Long,
    val gasUsed: Long,

    val contractAddress: String,
    val tokenID: Long,
    val tokenName: String,
    val tokenSymbol: String,
    val tokenDecimal: Int,

    @Contextual val confirmations: BigInteger? = null,
)
