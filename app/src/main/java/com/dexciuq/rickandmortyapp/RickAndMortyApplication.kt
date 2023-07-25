package com.dexciuq.rickandmortyapp

import android.app.Application
import com.dexciuq.rickandmortyapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RickAndMortyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(appModule)
        }
    }
}