package com.okuzawats.comcoroutine

import android.app.Application
import android.content.Context
import timber.log.Timber

class CoroutineApplication: Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: CoroutineApplication? = null

        fun applicationContext(): Context = instance!!.applicationContext
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}