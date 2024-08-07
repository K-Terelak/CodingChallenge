package com.example.codingchallenge.implementation.album

import com.example.codingchallenge.contract.AlbumRepository
import com.example.codingchallenge.contract.album.ObserveLocalAlbumsUseCase
import com.example.codingchallenge.di.IoDispatcher
import com.example.codingchallenge.model.Feed
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ObserveLocalAlbumsUseCaseImpl @Inject constructor(
    private val repository: AlbumRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
) : ObserveLocalAlbumsUseCase {
    override suspend fun invoke(): Flow<Feed?> = withContext(dispatcher) {
        repository.observeLocalAlbums()
    }
}
