package com.example.codingchallenge.contract.album

import com.example.codingchallenge.model.Feed
import kotlinx.coroutines.flow.Flow

interface ObserveLocalAlbumsUseCase {
    suspend operator fun invoke(): Flow<Feed?>
}
