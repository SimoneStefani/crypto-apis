package sh.nemo.api.debank.apis

import sh.nemo.api.debank.DeBank
import sh.nemo.api.debank.DeBankRequester
import sh.nemo.api.debank.models.Chain
import sh.nemo.api.debank.models.Protocol
import sh.nemo.api.debank.models.Token

suspend fun DeBank.getUserChainBalance(chainId: Chain.ChainId, address: String): Chain.UserBalance =
    DeBankRequester.get(
        path = "user/chain_balance",
        queryParameters = mapOf("chain_id" to chainId.name.lowercase(), "id" to address)
    )

suspend fun DeBank.listUserComplexProtocols(chainId: Chain.ChainId, address: String): List<Protocol> =
    DeBankRequester.get(
        path = "user/complex_protocol_list",
        queryParameters = mapOf("chain_id" to chainId.name.lowercase(), "id" to address)
    )
