package com.example.codingchallenge.di

import com.example.codingchallenge.initializer.contract.AppInitializer
import com.example.codingchallenge.initializer.implementation.TimberInitializer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@InstallIn(SingletonComponent::class)
@Module
abstract class CoreInitializerModule {

    @Binds
    @IntoSet
    abstract fun timberInitializer(timberInitializer: TimberInitializer): AppInitializer
}
