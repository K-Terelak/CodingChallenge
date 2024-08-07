package com.example.codingchallenge.contract.album

interface SyncRemoteAlbumsUseCase {
    suspend operator fun invoke(quantity: Int? = null): Result<Unit>
}
