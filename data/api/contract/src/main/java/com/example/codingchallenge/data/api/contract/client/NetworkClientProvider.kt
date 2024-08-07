package com.example.codingchallenge.data.api.contract.client

import io.ktor.client.HttpClient

interface NetworkClientProvider {
    val client: HttpClient
}
