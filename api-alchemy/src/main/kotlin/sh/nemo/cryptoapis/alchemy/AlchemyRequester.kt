package sh.nemo.cryptoapis.alchemy

import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.request
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import sh.nemo.cryptoapis.alchemy.models.AlchemyParams
import sh.nemo.cryptoapis.alchemy.models.AlchemyRequest

class AlchemyRequester {
    companion object {
        @PublishedApi
        internal const val BASE_URL = "https://eth-mainnet.alchemyapi.io/v2"

        @PublishedApi
        internal val httpClient: HttpClient = RestClient.create()

        @PublishedApi
        internal suspend inline fun <reified T> request(
            path: String,
            httpMethod: HttpMethod,
            rpcMethod: String,
            params: List<AlchemyParams>,
        ): T =
            httpClient.request("$BASE_URL$path") {
                method = httpMethod
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
                body = AlchemyRequest(
                    jsonrpc = "2.0",
                    id = 1,
                    method = rpcMethod,
                    params = params
                )
            }

        suspend inline fun <reified T> post(path: String, rpcMethod: String, params: List<AlchemyParams>): T =
            request(path = path, httpMethod = HttpMethod.Post, rpcMethod, params)
    }
}
