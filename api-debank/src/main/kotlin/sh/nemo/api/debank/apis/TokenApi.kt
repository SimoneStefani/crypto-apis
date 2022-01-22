package sh.nemo.api.debank.apis

import sh.nemo.api.debank.DeBank
import sh.nemo.api.debank.DeBankRequester
import sh.nemo.api.debank.models.Chain
import sh.nemo.api.debank.models.Token

suspend fun DeBank.getToken(chainId: Chain.ChainId, address: String): Token =
    DeBankRequester.get(
        path = "token",
        queryParameters = mapOf("chain_id" to chainId.name.lowercase(), "id" to address)
    )

suspend fun DeBank.listTokensByIds(chainId: Chain.ChainId, addresses: List<String>): List<Token> =
    DeBankRequester.get(
        path = "token/list_by_ids",
        queryParameters = mapOf("chain_id" to chainId.name.lowercase(), "ids" to addresses.joinToString(","))
    )
