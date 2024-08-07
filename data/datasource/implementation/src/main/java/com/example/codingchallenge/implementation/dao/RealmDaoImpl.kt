package com.example.codingchallenge.implementation.dao

import com.example.codingchallenge.contract.client.RealmDatabaseProvider
import com.example.codingchallenge.contract.dao.RealmDao
import com.example.codingchallenge.model.AlbumEntity
import com.example.codingchallenge.model.FeedEntity
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.ext.query
import io.realm.kotlin.notifications.SingleQueryChange
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RealmDaoImpl @Inject constructor(
    override val realmDatabaseProvider: RealmDatabaseProvider,
) : RealmDao, RealmDatabaseProvider by realmDatabaseProvider {

    override suspend fun observeFeed(): Flow<SingleQueryChange<FeedEntity>> = realmDatabaseProvider.realm.query(FeedEntity::class).first().asFlow()

    override suspend fun getAlbum(albumId: String): AlbumEntity = realmDatabaseProvider.realm.query<AlbumEntity>("id == $0", albumId).find().first()

    override suspend fun insertFeed(feedEntity: FeedEntity) {
        realmDatabaseProvider.realm.writeBlocking {
            copyToRealm(feedEntity, UpdatePolicy.ALL)
        }
    }
}
