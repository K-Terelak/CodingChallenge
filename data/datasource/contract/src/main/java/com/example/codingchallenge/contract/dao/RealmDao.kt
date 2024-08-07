package com.example.codingchallenge.contract.dao

import com.example.codingchallenge.contract.client.RealmDatabaseProvider
import com.example.codingchallenge.model.AlbumEntity
import com.example.codingchallenge.model.FeedEntity
import io.realm.kotlin.notifications.SingleQueryChange
import kotlinx.coroutines.flow.Flow

interface RealmDao {
    val realmDatabaseProvider: RealmDatabaseProvider

    suspend fun observeFeed(): Flow<SingleQueryChange<FeedEntity>>
    suspend fun getAlbum(albumId: String): AlbumEntity
    suspend fun insertFeed(feedEntity: FeedEntity)
}
