package com.example.codingchallenge.data.api.contract.service

import com.example.codingchallenge.data.api.contract.client.NetworkClientProvider
import com.example.codingchallenge.data.api.model.AlbumsDto

interface ApiService {
    val networkClientProvider: NetworkClientProvider

    suspend fun getAlbums(quantity: Int): AlbumsDto
}
