package com.example.codingchallenge.implementation.album

import com.example.codingchallenge.contract.AlbumRepository
import com.example.codingchallenge.contract.album.GetLocalAlbumUseCase
import com.example.codingchallenge.di.IoDispatcher
import com.example.codingchallenge.model.Album
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetLocalAlbumUseCaseImpl @Inject constructor(
    private val repository: AlbumRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
) : GetLocalAlbumUseCase {
    override suspend fun invoke(albumId: String): Result<Album> = withContext(dispatcher) {
        repository.getLocalAlbum(albumId)
    }
}
