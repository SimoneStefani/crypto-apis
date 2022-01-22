package sh.nemo.api.debank.apis

import sh.nemo.api.debank.DeBank
import sh.nemo.api.debank.DeBankRequester
import sh.nemo.api.debank.models.Protocol
import sh.nemo.api.debank.models.ProtocolTvl

suspend fun DeBank.getProtocol(id: String): Protocol =
    DeBankRequester.get(
        path = "protocol",
        queryParameters = mapOf("id" to id)
    )

suspend fun DeBank.listProtocols(): List<Protocol> =
    DeBankRequester.get(path = "protocol/list")

suspend fun DeBank.getProtocolTvl(id: String): List<ProtocolTvl> =
    DeBankRequester.get(
        path = "protocol/tvl",
        queryParameters = mapOf("id" to id)
    )
