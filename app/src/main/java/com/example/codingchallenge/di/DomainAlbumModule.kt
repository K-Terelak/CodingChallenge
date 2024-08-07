package com.example.codingchallenge.di

import com.example.codingchallenge.contract.album.GetLocalAlbumUseCase
import com.example.codingchallenge.contract.album.ObserveLocalAlbumsUseCase
import com.example.codingchallenge.contract.album.SyncRemoteAlbumsUseCase
import com.example.codingchallenge.implementation.album.GetLocalAlbumUseCaseImpl
import com.example.codingchallenge.implementation.album.ObserveLocalAlbumsUseCaseImpl
import com.example.codingchallenge.implementation.album.SyncRemoteAlbumsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DomainAlbumModule {
    @Binds
    abstract fun bindSyncRemoteAlbumsUseCase(impl: SyncRemoteAlbumsUseCaseImpl): SyncRemoteAlbumsUseCase

    @Binds
    abstract fun bindObserveLocalAlbumsUseCase(impl: ObserveLocalAlbumsUseCaseImpl): ObserveLocalAlbumsUseCase

    @Binds
    abstract fun bindGetLocalAlbumUseCase(impl: GetLocalAlbumUseCaseImpl): GetLocalAlbumUseCase
}
