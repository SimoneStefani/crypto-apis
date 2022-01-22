package sh.nemo.api.debank.apis

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import sh.nemo.api.debank.DeBank
import sh.nemo.api.debank.models.Chain

class TokenApiTest {
    private val client = DeBank()

    @Test
    fun getToken() = runBlocking {
        val result = client.getToken(Chain.ChainId.ETH, "0x6f80310ca7f2c654691d1383149fa1a57d8ab1f8")
        println(result)
    }

    @Test
    fun listTokensByIds() = runBlocking {
        val tokens = listOf("0x6f80310ca7f2c654691d1383149fa1a57d8ab1f8", "0xdac17f958d2ee523a2206206994597c13d831ec7")
        val result = client.listTokensByIds(Chain.ChainId.ETH, tokens)
        println(result)
    }
}
