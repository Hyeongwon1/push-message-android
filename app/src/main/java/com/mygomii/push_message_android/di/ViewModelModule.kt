package com.mygomii.push_message_android.di

import com.mygomii.push_message_android.presentation.screens.home.HomeViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { HomeViewModel(repository = get()) }
}