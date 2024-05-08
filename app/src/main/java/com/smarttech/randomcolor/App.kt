package com.smarttech.randomcolor

import android.app.Application
import com.smarttech.randomcolor.di.dispatcherModule
import com.smarttech.randomcolor.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                viewModelModule,
                dispatcherModule,
            )
        }
    }
}