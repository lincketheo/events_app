package com.communeo.mobile.android

import android.app.Application
import android.content.res.Resources
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CommuneoApplication : Application() {
    companion object {
        lateinit var resources: Resources
    }

    override fun onCreate() {
        super.onCreate()
        CommuneoApplication.resources = resources
    }
}
