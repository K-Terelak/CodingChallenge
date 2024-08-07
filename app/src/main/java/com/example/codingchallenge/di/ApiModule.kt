package com.example.codingchallenge.di

import com.example.codingchallenge.data.api.contract.client.NetworkClientProvider
import com.example.codingchallenge.data.api.contract.service.ApiService
import com.example.codingchallenge.data.api.implementation.client.DefaultNetworkClientProviderImpl
import com.example.codingchallenge.data.api.implementation.service.ApiServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class ApiModule {
    @Binds
    abstract fun bindDefaultNetworkClient(clientImpl: DefaultNetworkClientProviderImpl): NetworkClientProvider

    @Binds
    abstract fun bindApiService(apiServiceImpl: ApiServiceImpl): ApiService
}
