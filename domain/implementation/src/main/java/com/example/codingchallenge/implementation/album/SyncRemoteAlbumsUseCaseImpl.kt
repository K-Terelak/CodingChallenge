package com.example.codingchallenge.implementation.album

import com.example.codingchallenge.contract.AlbumRepository
import com.example.codingchallenge.contract.album.SyncRemoteAlbumsUseCase
import com.example.codingchallenge.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SyncRemoteAlbumsUseCaseImpl @Inject constructor(
    private val repository: AlbumRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
) : SyncRemoteAlbumsUseCase {
    override suspend fun invoke(quantity: Int?): Result<Unit> = withContext(dispatcher) {
        repository.syncRemoteAlbums(quantity ?: DEFAULT_ALBUM_QUANTITY)
    }

    private companion object {
        const val DEFAULT_ALBUM_QUANTITY = 100
    }
}
