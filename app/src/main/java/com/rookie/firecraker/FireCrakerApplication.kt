package com.rookie.firecraker

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import io.sanghun.compose.video.cache.VideoPlayerCacheManager

@HiltAndroidApp
class FireCrakerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = this
        VideoPlayerCacheManager.initialize(this, 1024 * 1024 * 1024) //1GB
    }

    companion object {
        lateinit var appContext: Context
    }
}