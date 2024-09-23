package com.mygomii.push_message_android.di

import com.mygomii.push_message_android.data.repository.TokenRepository
import com.mygomii.push_message_android.data.repository.TokenRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<TokenRepository> { TokenRepositoryImpl(datasource = get()) }
}