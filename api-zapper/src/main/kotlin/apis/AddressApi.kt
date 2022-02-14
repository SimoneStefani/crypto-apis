package sh.nemo.cryptoapis.etherscan.apis

import sh.nemo.cryptoapis.etherscan.Zapper
import sh.nemo.cryptoapis.etherscan.ZapperRequester
import sh.nemo.cryptoapis.etherscan.models.AddressBalances

suspend fun Zapper.getAddressesInfo(addresses: List<String>): Map<String, AddressBalances> =
    ZapperRequester.get(
        path = "/v1/protocols/tokens/balances",
        queryParameters = mapOf(
            "addresses" to addresses,
            "api_key" to this.apiKey
        )
    )
