package sh.nemo.cryptoapis.alchemy.apis

import sh.nemo.cryptoapis.alchemy.Alchemy
import sh.nemo.cryptoapis.alchemy.AlchemyRequester
import sh.nemo.cryptoapis.alchemy.models.GetNftsResponse
import sh.nemo.cryptoapis.alchemy.models.GetOwnersForCollectionResponse
import sh.nemo.cryptoapis.alchemy.models.Nft
import sh.nemo.cryptoapis.alchemy.models.NftWithMetadata


suspend fun Alchemy.getNftsWithMetadata(
    owner: String,
    contractAddresses: List<String>? = null,
    pageKey: String? = null
) =
    AlchemyRequester.get<GetNftsResponse<NftWithMetadata>>(
        path = "${this.apiKey}/getNFTs",
        queryParameters = mapOf(
            "owner" to owner,
            "withMetadata" to true,
            "contractAddresses" to contractAddresses,
            "pageKey" to pageKey
        )
    )


suspend fun Alchemy.getNfts(owner: String, contractAddresses: List<String>? = null, pageKey: String? = null) =
    AlchemyRequester.get<GetNftsResponse<Nft>>(
        path = "${this.apiKey}/getNFTs",
        queryParameters = mapOf(
            "owner" to owner,
            "withMetadata" to false,
            "contractAddresses" to contractAddresses,
            "pageKey" to pageKey
        )
    )

suspend fun Alchemy.getNftMetadata(contract: String, tokenId: String, tokenType: NftWithMetadata.TokenType) =
    AlchemyRequester.get<NftWithMetadata>(
        path = "${this.apiKey}/getNFTMetadata",
        queryParameters = mapOf(
            "contractAddress" to contract,
            "tokenId" to tokenId,
            "tokenType" to tokenType
        )
    )

suspend fun Alchemy.getOwnersForCollection(contract: String) =
    AlchemyRequester.get<GetOwnersForCollectionResponse>(
        path = "${this.apiKey}/getOwnersForCollection",
        queryParameters = mapOf(
            "contractAddress" to contract,
        )
    )
