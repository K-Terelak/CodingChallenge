package com.example.codingchallenge.initializer.implementation

import android.app.Application
import com.example.codingchallenge.initializer.contract.AppInitializer
import timber.log.Timber
import javax.inject.Inject

class TimberInitializer @Inject constructor() : AppInitializer {

    override fun init(application: Application) {
        Timber.plant(Timber.DebugTree())
    }
}
