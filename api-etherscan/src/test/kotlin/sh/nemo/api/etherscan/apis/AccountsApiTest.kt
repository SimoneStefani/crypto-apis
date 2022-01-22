package sh.nemo.api.etherscan.apis

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import sh.nemo.api.etherscan.Etherscan

internal class AccountsApiTest {
    private val client = Etherscan("")

    @Test
    fun getAddressEtherBalance() = runBlocking {
        val result = client.getAddressEtherBalance("0xde0b295669a9fd93d5f28d9ec85e40f4cb697bae")
        println(result)
    }

    @Test
    fun getAddressesEtherBalances() = runBlocking {
        val result = client.getAddressesEtherBalances(
            listOf(
                "0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a",
                "0x63a9975ba31b0b9626b34300f7f627147df1f526",
                "0x198ef1ec325a96cc354c7266a038be8b5c558f67"
            )
        )
        println(result)
    }

    @Test
    fun getAddressTransactions() = runBlocking {
        val result = client.getAddressTransactions("0xde0b295669a9fd93d5f28d9ec85e40f4cb697bae")
        println(result)
    }

    @Test
    fun getAddressInternalTransactions() = runBlocking {
        val result = client.getAddressInternalTransactions("0x2c1ba59d6f58433fb1eaee7d20b26ed83bda51a3")
        println(result)
    }

    @Test
    fun getInternalTransactionsByHash() = runBlocking {
        val result =
            client.getInternalTransactionsByHash("0x40eb908387324f2b575b4879cd9d7188f69c8fc9d87c901b9e2daaea4b442170")
        println(result)
    }

    @Test
    fun getInternalTransactionsByBlock() = runBlocking {
        val result = client.getInternalTransactionsByBlock(13481773, 13491773)
        println(result)
    }

    @Test
    fun getAddressERC20Transfers() = runBlocking {
        val result = client.getAddressERC20Transfers(
            "0x4e83362442b8d1bec281594cea3050c8eb01311c",
            "0x9f8f72aa9304c8b593d555f12ef6589cc3a579a2"
        )
        println(result)
    }

    @Test
    fun getAddressERC721Transfers() = runBlocking {
        val result = client.getAddressERC721Transfers(
            "0x6975be450864c02b4613023c2152ee0743572325",
            "0x06012c8cf97bead5deae237070f9587f8e7a266d"
        )
        println(result)
    }

    @Test
    fun getAddressMinedBlocks() = runBlocking {
        val result = client.getAddressMinedBlocks("0x9dd134d14d1e65f84b706d6f205cd5b1cd03a46b")
        println(result)
    }
}
