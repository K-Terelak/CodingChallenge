package com.example.codingchallenge.di

import com.example.codingchallenge.contract.client.RealmDatabaseProvider
import com.example.codingchallenge.contract.dao.RealmDao
import com.example.codingchallenge.implementation.client.DefaultRealmDatabaseProviderImpl
import com.example.codingchallenge.implementation.dao.RealmDaoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {
    @Binds
    abstract fun bindDefaultRealmClient(clientImpl: DefaultRealmDatabaseProviderImpl): RealmDatabaseProvider

    @Binds
    abstract fun bindApiService(realmDaoImpl: RealmDaoImpl): RealmDao
}
