package sh.nemo.api.debank.apis

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import sh.nemo.api.debank.DeBank

class ProtocolApiTest {
    private val client = DeBank()

    @Test
    fun getProtocol() = runBlocking {
        val result = client.getProtocol("compound")
        println(result)
    }

    @Test
    fun listProtocols() = runBlocking {
        val result = client.listProtocols()
        println(result)
    }

    @Test
    fun getProtocolTvl() = runBlocking {
        val result = client.getProtocolTvl("compound")
        println(result)
    }
}
