package com.mygomii.push_message_android.di

import com.mygomii.push_message_android.data.datasources.TokenDatasource
import com.mygomii.push_message_android.data.datasources.TokenDatasourceImpl
import org.koin.dsl.module

val datasourceModule = module {
    single<TokenDatasource> { TokenDatasourceImpl(client = get()) }
}