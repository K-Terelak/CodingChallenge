package com.example.codingchallenge

import android.app.Application
import com.example.codingchallenge.appinitializer.AppInitializersContainer
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    @Inject
    lateinit var appInitializersContainer: AppInitializersContainer

    override fun onCreate() {
        super.onCreate()

        appInitializersContainer.init(this)
    }
}
