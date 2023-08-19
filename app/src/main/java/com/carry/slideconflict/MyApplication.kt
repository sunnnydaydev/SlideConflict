package com.carry.slideconflict

import android.app.Application
import timber.log.Timber.*
import timber.log.Timber.Forest.plant


/**
 * Create by SunnyDay /08/19 12:12:07
 */
class MyApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        plant(DebugTree())
    }
}