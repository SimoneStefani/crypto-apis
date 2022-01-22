package sh.nemo.api.debank.apis

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import sh.nemo.api.debank.DeBank
import sh.nemo.api.debank.models.Chain


internal class ChainApiTest {
    private val client = DeBank()

    @Test
    fun getChain() = runBlocking {
        val result = client.getChain(Chain.ChainId.OP)
        println(result)
    }

    @Test
    fun listChains() = runBlocking {
        val result = client.listChains()
        println(result)
    }
}
