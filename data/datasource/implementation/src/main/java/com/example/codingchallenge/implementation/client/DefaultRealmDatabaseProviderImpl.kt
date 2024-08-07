package com.example.codingchallenge.implementation.client

import com.example.codingchallenge.contract.client.RealmDatabaseProvider
import com.example.codingchallenge.model.AlbumEntity
import com.example.codingchallenge.model.FeedEntity
import com.example.codingchallenge.model.GenreEntity
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import javax.inject.Inject

class DefaultRealmDatabaseProviderImpl @Inject constructor() : RealmDatabaseProvider {
    private val realmConfig = RealmConfiguration.create(
        schema = setOf(
            AlbumEntity::class,
            GenreEntity::class,
            FeedEntity::class
        )
    )
    override val realm: Realm = Realm.open(realmConfig)
}
