package sh.nemo.cryptoapis.etherscan.apis

import com.ionspin.kotlin.bignum.integer.BigInteger
import sh.nemo.cryptoapis.etherscan.Etherscan
import sh.nemo.cryptoapis.etherscan.models.ERC20Transfer
import sh.nemo.cryptoapis.etherscan.models.ERC721Transfer
import sh.nemo.cryptoapis.etherscan.models.EtherBalance
import sh.nemo.cryptoapis.etherscan.models.EtherscanResponse
import sh.nemo.cryptoapis.etherscan.models.InternalTransaction
import sh.nemo.cryptoapis.etherscan.models.MinedBlock
import sh.nemo.cryptoapis.etherscan.models.Sort
import sh.nemo.cryptoapis.etherscan.models.Tag
import sh.nemo.cryptoapis.etherscan.models.Transaction

suspend fun Etherscan.getAddressEtherBalance(address: String, tag: Tag = Tag.LATEST): EtherscanResponse<BigInteger> =
    sh.nemo.cryptoapis.etherscan.EtherscanRequester.get<EtherscanResponse<String>>(
        path = "",
        queryParameters = mapOf(
            "module" to "account",
            "action" to "balance",
            "address" to address,
            "tag" to tag.name.lowercase(),
            "apikey" to this.apiKey
        )
    ).let { (status, message, result) -> EtherscanResponse(status, message, BigInteger.parseString(result)) }


suspend fun Etherscan.getAddressesEtherBalances(
    addresses: List<String>,
    tag: Tag = Tag.LATEST
): EtherscanResponse<List<EtherBalance>> =
    sh.nemo.cryptoapis.etherscan.EtherscanRequester.get(
        path = "",
        queryParameters = mapOf(
            "module" to "account",
            "action" to "balancemulti",
            "address" to addresses.joinToString(","),
            "tag" to tag.name.lowercase(),
            "apikey" to this.apiKey
        )
    )

suspend fun Etherscan.getAddressTransactions(
    address: String,
    startBlock: Int = 0,
    endBlock: Int = 99999999,
    page: Int = 1,
    offset: Int = 10,
    sort: Sort = Sort.ASC,
): EtherscanResponse<List<Transaction>> =
    sh.nemo.cryptoapis.etherscan.EtherscanRequester.get(
        path = "",
        queryParameters = mapOf(
            "module" to "account",
            "action" to "txlist",
            "address" to address,
            "startblock" to startBlock,
            "endblock" to endBlock,
            "page" to page,
            "offset" to offset,
            "sort" to sort.name.lowercase(),
            "apikey" to this.apiKey
        )
    )

suspend fun Etherscan.getAddressInternalTransactions(
    address: String,
    startBlock: Int = 0,
    endBlock: Int = 99999999,
    page: Int = 1,
    offset: Int = 10,
    sort: Sort = Sort.ASC,
): EtherscanResponse<List<InternalTransaction>> =
    sh.nemo.cryptoapis.etherscan.EtherscanRequester.get(
        path = "",
        queryParameters = mapOf(
            "module" to "account",
            "action" to "txlistinternal",
            "address" to address,
            "startblock" to startBlock,
            "endblock" to endBlock,
            "page" to page,
            "offset" to offset,
            "sort" to sort.name.lowercase(),
            "apikey" to this.apiKey
        )
    )

suspend fun Etherscan.getInternalTransactionsByHash(hash: String): EtherscanResponse<List<InternalTransaction>> =
    sh.nemo.cryptoapis.etherscan.EtherscanRequester.get<EtherscanResponse<List<InternalTransaction>>>(
        path = "",
        queryParameters = mapOf(
            "module" to "account",
            "action" to "txlistinternal",
            "txhash" to hash,
            "apikey" to this.apiKey
        )
    ).let { (status, message, result) -> EtherscanResponse(status, message, result.map { it.copy(hash = hash) }) }

suspend fun Etherscan.getInternalTransactionsByBlock(
    startBlock: Int,
    endBlock: Int,
    page: Int = 1,
    offset: Int = 10,
    sort: Sort = Sort.ASC,
): EtherscanResponse<List<InternalTransaction>> =
    sh.nemo.cryptoapis.etherscan.EtherscanRequester.get(
        path = "",
        queryParameters = mapOf(
            "module" to "account",
            "action" to "txlistinternal",
            "startblock" to startBlock,
            "endblock" to endBlock,
            "page" to page,
            "offset" to offset,
            "sort" to sort.name.lowercase(),
            "apikey" to this.apiKey
        )
    )

suspend fun Etherscan.getAddressERC20Transfers(
    address: String,
    contractAddress: String? = null,
    startBlock: Int = 0,
    endBlock: Int = 99999999,
    page: Int = 1,
    offset: Int = 10,
    sort: Sort = Sort.ASC,
): EtherscanResponse<List<ERC20Transfer>> =
    sh.nemo.cryptoapis.etherscan.EtherscanRequester.get(
        path = "",
        queryParameters = mapOf(
            "module" to "account",
            "action" to "tokentx",
            "contractaddress" to contractAddress,
            "address" to address,
            "startblock" to startBlock,
            "endblock" to endBlock,
            "page" to page,
            "offset" to offset,
            "sort" to sort.name.lowercase(),
            "apikey" to this.apiKey
        )
    )

suspend fun Etherscan.getAddressERC721Transfers(
    address: String,
    contractAddress: String? = null,
    startBlock: Int = 0,
    endBlock: Int = 99999999,
    page: Int = 1,
    offset: Int = 10,
    sort: Sort = Sort.ASC,
): EtherscanResponse<List<ERC721Transfer>> =
    sh.nemo.cryptoapis.etherscan.EtherscanRequester.get(
        path = "",
        queryParameters = mapOf(
            "module" to "account",
            "action" to "tokennfttx",
            "contractaddress" to contractAddress,
            "address" to address,
            "startblock" to startBlock,
            "endblock" to endBlock,
            "page" to page,
            "offset" to offset,
            "sort" to sort.name.lowercase(),
            "apikey" to this.apiKey
        )
    )

suspend fun Etherscan.getAddressMinedBlocks(
    address: String,
    page: Int = 1,
    offset: Int = 10,
): EtherscanResponse<List<MinedBlock>> =
    sh.nemo.cryptoapis.etherscan.EtherscanRequester.get(
        path = "",
        queryParameters = mapOf(
            "module" to "account",
            "action" to "getminedblocks",
            "blocktype" to "blocks",
            "address" to address,
            "page" to page,
            "offset" to offset,
            "apikey" to this.apiKey
        )
    )
