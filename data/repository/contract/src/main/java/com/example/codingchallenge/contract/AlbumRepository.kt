package com.example.codingchallenge.contract

import com.example.codingchallenge.model.Album
import com.example.codingchallenge.model.Feed
import kotlinx.coroutines.flow.Flow

interface AlbumRepository {
    suspend fun syncRemoteAlbums(quantity: Int): Result<Unit>
    suspend fun observeLocalAlbums(): Flow<Feed?>
    suspend fun getLocalAlbum(albumId: String): Result<Album>
}
