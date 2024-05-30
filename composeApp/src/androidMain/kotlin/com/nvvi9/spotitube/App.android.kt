package com.nvvi9.spotitube

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.nvvi9.spotitube.di.initKoin
import org.koin.android.ext.koin.androidContext

class AndroidApp : Application() {
    companion object {
        lateinit var INSTANCE: AndroidApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        initKoin {
            androidContext(this@AndroidApp)
        }
    }
}

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}
