package sh.nemo.api.etherscan

import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.parameter
import io.ktor.client.request.request
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType


class EtherscanRequester {
    companion object {
        @PublishedApi
        internal const val BASE_URL = "https://api.etherscan.io/api/"

        @PublishedApi
        internal val httpClient: HttpClient = RestClient.create()

        @PublishedApi
        internal suspend inline fun <reified T> request(
            path: String,
            httpMethod: HttpMethod,
            requestBody: Any? = null,
            queryParameters: Map<String, Any?>? = null
        ): T =
            httpClient.request("$BASE_URL$path") {
                method = httpMethod
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
                requestBody?.let {
                    body = it
                }
                queryParameters?.map { queryParam ->
                    queryParam.value?.let {
                        parameter(queryParam.key, queryParam.value)
                    }
                }
            }

        suspend inline fun <reified T> get(path: String, queryParameters: Map<String, Any?>? = null): T =
            request(path = path, httpMethod = HttpMethod.Get, queryParameters = queryParameters)

        suspend inline fun <reified T> post(path: String, body: Any): T =
            request(path = path, httpMethod = HttpMethod.Post, requestBody = body)

        suspend inline fun <reified T> patch(path: String, body: Any): T =
            request(path = path, httpMethod = HttpMethod.Patch, requestBody = body)

        suspend inline fun <reified T> put(path: String, body: Any? = null): T =
            request(path = path, httpMethod = HttpMethod.Put, requestBody = body)

        suspend inline fun <reified T> delete(path: String): T =
            request(path = path, httpMethod = HttpMethod.Delete)
    }
}
