package sh.nemo.api.debank.apis

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import sh.nemo.api.debank.DeBank
import sh.nemo.api.debank.models.Chain

class UserApiTest {
    private val client = DeBank()

    @Test
    fun getUserChainBalance() = runBlocking {
        val result = client.getUserChainBalance(Chain.ChainId.ETH, "0x88a26a07ac1d80bb6544d85da1c1d6089bc7d39f")
        println(result)
    }

    @Test
    fun listUserComplexProtocols() = runBlocking {
        val result = client.listUserComplexProtocols(Chain.ChainId.ETH, "0x88a26a07ac1d80bb6544d85da1c1d6089bc7d39f")
        println(result)
    }
}
