package com.mygomii.push_message_android.di

import com.mygomii.push_message_android.domain.TokenUsecase
import com.mygomii.push_message_android.presentation.screens.home.HomeViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { HomeViewModel(tokenUsecase = get()) }
}

val usecaseModule = module {
    single { TokenUsecase(tokenRepository = get()) }
}