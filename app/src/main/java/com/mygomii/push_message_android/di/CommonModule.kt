package com.mygomii.push_message_android.di

fun commonModule() = listOf(
    networkModule,
    datasourceModule,
    usecaseModule,
    repositoryModule,
    viewModelModule
)