package com.example.codingchallenge.data.api.implementation.service

import com.example.codingchallenge.data.api.contract.client.NetworkClientProvider
import com.example.codingchallenge.data.api.contract.service.ApiService
import com.example.codingchallenge.data.api.model.AlbumsDto
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(
    override val networkClientProvider: NetworkClientProvider,
) : ApiService, NetworkClientProvider by networkClientProvider {

    override suspend fun getAlbums(quantity: Int): AlbumsDto = client
        .get("v2/us/music/most-played/$quantity/albums.json")
        .body<AlbumsDto>()
}
