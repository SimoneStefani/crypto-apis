package sh.nemo.cryptoapis.moralis.apis

import sh.nemo.cryptoapis.moralis.Moralis
import sh.nemo.cryptoapis.moralis.MoralisRequester
import sh.nemo.cryptoapis.moralis.models.MoralisResponse
import sh.nemo.cryptoapis.moralis.models.TokenOwnership

suspend fun Moralis.getNFTOwners(
    chain: String = "eth",
    format: String = "decimal",
    address: String,
    offset: Int? = null,
    limit: Int? = null,
    cursor: String? = null,
): MoralisResponse<List<TokenOwnership>> =
    MoralisRequester.get(
        path = "nft/$address/owners",
        apiKey = apiKey,
        queryParameters = mapOf(
            "chain" to chain,
            "format" to format,
            "offset" to offset,
            "limit" to limit,
            "cursor" to cursor,
        )
    )
