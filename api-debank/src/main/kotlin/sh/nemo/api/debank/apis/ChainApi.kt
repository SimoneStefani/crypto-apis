package sh.nemo.api.debank.apis

import sh.nemo.api.debank.DeBank
import sh.nemo.api.debank.DeBankRequester
import sh.nemo.api.debank.models.Chain

suspend fun DeBank.getChain(id: Chain.ChainId): Chain =
    DeBankRequester.get(
        path = "chain",
        queryParameters = mapOf("id" to id.name.lowercase())
    )

suspend fun DeBank.listChains(): List<Chain> =
    DeBankRequester.get(path = "chain/list")
