package com.example.codingchallenge.home.di

import com.example.codingchallenge.home.navigation.HomeNestedGraph
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object HomeModule {
    @Provides
    @Singleton
    fun provideHomeNestedGraph(): HomeNestedGraph = HomeNestedGraph()
}
