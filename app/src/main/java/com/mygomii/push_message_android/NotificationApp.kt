package com.mygomii.push_message_android

import android.app.Application
import com.mygomii.push_message_android.di.commonModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class NotificationApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@NotificationApp)
            androidLogger()
            modules(
                commonModule()
            )
        }
    }
}