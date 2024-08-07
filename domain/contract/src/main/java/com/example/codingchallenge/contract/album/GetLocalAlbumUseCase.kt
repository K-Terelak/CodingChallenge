package com.example.codingchallenge.contract.album

import com.example.codingchallenge.model.Album

interface GetLocalAlbumUseCase {
    suspend operator fun invoke(albumId: String): Result<Album>
}
