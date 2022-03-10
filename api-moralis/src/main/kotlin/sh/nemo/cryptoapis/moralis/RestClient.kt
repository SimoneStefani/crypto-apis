package sh.nemo.cryptoapis.moralis

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import kotlinx.serialization.json.Json

class RestClient {
    companion object {
        internal fun create() = HttpClient {
            install(JsonFeature) {
                serializer = KotlinxSerializer(
                    Json {
                        ignoreUnknownKeys = true
                        coerceInputValues = true
                        isLenient = true
                        encodeDefaults = true
                    }
                )
            }
        }
    }
}
