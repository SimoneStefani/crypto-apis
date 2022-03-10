package sh.nemo.cryptoapis.moralis.apis

import sh.nemo.cryptoapis.moralis.Moralis
import sh.nemo.cryptoapis.moralis.MoralisRequester
import sh.nemo.cryptoapis.moralis.models.MoralisResponse
import sh.nemo.cryptoapis.moralis.models.TokenTransfer

suspend fun Moralis.getNFTTransfers(
    chain: String = "eth",
    format: String = "decimal",
    address: String,
    direction: String? = null,
    offset: Int? = null,
    limit: Int? = null,
    cursor: String? = null,
): MoralisResponse<List<TokenTransfer>> =
    MoralisRequester.get(
        path = "$address/nft/transfers",
        apiKey = apiKey,
        queryParameters = mapOf(
            "chain" to chain,
            "format" to format,
            "direction" to direction,
            "offset" to offset,
            "limit" to limit,
            "cursor" to cursor,
        )
    )
