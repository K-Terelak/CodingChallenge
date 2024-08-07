package com.example.codingchallenge.implementation

import com.example.codingchallenge.contract.AlbumRepository
import com.example.codingchallenge.contract.dao.RealmDao
import com.example.codingchallenge.data.api.contract.service.ApiService
import com.example.codingchallenge.implementation.mapping.toAlbum
import com.example.codingchallenge.implementation.mapping.toFeed
import com.example.codingchallenge.implementation.mapping.toFeedEntity
import com.example.codingchallenge.model.Album
import com.example.codingchallenge.model.Feed
import io.realm.kotlin.notifications.DeletedObject
import io.realm.kotlin.notifications.InitialObject
import io.realm.kotlin.notifications.PendingObject
import io.realm.kotlin.notifications.UpdatedObject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val realmDao: RealmDao,
) : AlbumRepository {

    override suspend fun syncRemoteAlbums(quantity: Int): Result<Unit> = runCatching {
        val remoteAlbums = apiService.getAlbums(quantity)
        realmDao.insertFeed(remoteAlbums.feed.toFeedEntity())
    }

    override suspend fun observeLocalAlbums(): Flow<Feed?> = realmDao.observeFeed().map { resultsChange ->
        when (resultsChange) {
            is DeletedObject -> null
            is InitialObject -> resultsChange.obj.toFeed()
            is UpdatedObject -> resultsChange.obj.toFeed()
            is PendingObject -> null
        }
    }

    override suspend fun getLocalAlbum(albumId: String): Result<Album> = runCatching {
        realmDao.getAlbum(albumId).toAlbum()
    }
}
