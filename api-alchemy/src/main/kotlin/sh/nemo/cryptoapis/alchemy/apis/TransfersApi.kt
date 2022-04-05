package sh.nemo.cryptoapis.alchemy.apis

import sh.nemo.cryptoapis.alchemy.Alchemy
import sh.nemo.cryptoapis.alchemy.AlchemyRequester
import sh.nemo.cryptoapis.alchemy.models.AlchemyResponse
import sh.nemo.cryptoapis.alchemy.models.AssetTransfer
import sh.nemo.cryptoapis.alchemy.models.AssetTransfersParams

suspend fun Alchemy.getAssetTransfers(
    fromBlock: String = "0x1",
    fromAddress: String,
    toAddress: String,
    contractAddresses: List<String>,
    category: List<String> = listOf("token"),
): AlchemyResponse.Result<List<AssetTransfer>> =
    AlchemyRequester.rpcCall<AlchemyResponse<List<AssetTransfer>>>(
        path = "${this.apiKey}",
        rpcMethod = "alchemy_getAssetTransfers",
        params = listOf(
            AssetTransfersParams(
                fromBlock = fromBlock,
                fromAddress = fromAddress,
                toAddress = toAddress,
                contractAddresses = contractAddresses,
                category = category,
            )
        )
    ).result
