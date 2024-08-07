package com.example.codingchallenge.data.api.implementation.client

import com.example.codingchallenge.data.api.contract.client.NetworkClientProvider
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Inject

class DefaultNetworkClientProviderImpl @Inject constructor() : NetworkClientProvider {
    override val client: HttpClient = HttpClient(provideConfig())
}

private fun provideJson() = Json {
    prettyPrint = true
    isLenient = true
    ignoreUnknownKeys = true
}

private fun provideConfig(): HttpClientConfig<*>.() -> Unit = {
    val baseUrl = "rss.applemarketingtools.com/api/"

    expectSuccess = true

    install(ContentNegotiation) {
        json(provideJson())
    }

    defaultRequest {
        url {
            protocol = URLProtocol.HTTPS
            host = baseUrl
        }
    }
}
