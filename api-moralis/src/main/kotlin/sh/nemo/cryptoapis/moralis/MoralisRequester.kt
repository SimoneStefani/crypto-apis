package sh.nemo.cryptoapis.moralis

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.accept
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType

class MoralisRequester {
    companion object {
        @PublishedApi
        internal const val BASE_URL = "https://deep-index.moralis.io/api/v2/"

        @PublishedApi
        internal val httpClient: HttpClient = RestClient.create()

        @PublishedApi
        internal suspend inline fun <reified T> request(
            path: String,
            httpMethod: HttpMethod,
            apiKey: String,
            requestBody: Any? = null,
            queryParameters: Map<String, Any?>? = null
        ): T =
            httpClient.request("$BASE_URL$path") {
                method = httpMethod
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
                header("X-API-Key", apiKey)
                requestBody?.let {
                    setBody(it)
                }
                queryParameters?.map { queryParam ->
                    queryParam.value?.let {
                        parameter(queryParam.key, queryParam.value)
                    }
                }
            }.body()

        suspend inline fun <reified T> get(path: String, apiKey: String, queryParameters: Map<String, Any?>? = null): T =
            request(path = path, httpMethod = HttpMethod.Get, apiKey = apiKey, queryParameters = queryParameters)
    }
}
