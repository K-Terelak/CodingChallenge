package com.example.codingchallenge.di

import com.example.codingchallenge.home.navigation.HomeNestedGraph
import com.example.codingchallenge.navigation.NavigationProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Provides
    @Singleton
    fun provideNavigationProvider(homeNestedGraph: HomeNestedGraph): NavigationProvider = NavigationProvider(homeNestedGraph)
}
