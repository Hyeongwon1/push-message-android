package com.mygomii.push_message_android.di

import com.mygomii.push_message_android.data.service.TokenService
import org.koin.dsl.module

val serviceModule = module {
    single { TokenService(client = get()) }
}