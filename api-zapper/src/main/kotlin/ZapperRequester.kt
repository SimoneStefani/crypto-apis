package sh.nemo.cryptoapis.etherscan

import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.accept
import io.ktor.client.request.parameter
import io.ktor.client.request.request
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType


class ZapperRequester {
    companion object {
        @PublishedApi
        internal const val BASE_URL = "https://api.zapper.fi"

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
                        when (it) {
                            is List<*> -> parameterList(queryParam.key, it)
                            else -> parameter(queryParam.key, queryParam.value)
                        }
                    }
                }
            }

        suspend inline fun <reified T> get(path: String, queryParameters: Map<String, Any?>? = null): T =
            request(path = path, httpMethod = HttpMethod.Get, queryParameters = queryParameters)
    }
}

fun HttpRequestBuilder.parameterList(key: String, value: List<*>) =
    value.forEach { url.parameters.append("$key[]", it.toString()) }
