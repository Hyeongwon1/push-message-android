package com.mygomii.push_message_android.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        isLenient = true
                        encodeDefaults = true
                        ignoreUnknownKeys = true
                    }
                )
            }

            install(HttpTimeout) {
                requestTimeoutMillis = 10_000L
                connectTimeoutMillis = 10_000L
                socketTimeoutMillis = 10_000L
            }

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        println("########## $message")
                    }
                }
                level = LogLevel.ALL
            }

            defaultRequest {
                header("Content-Type", "application/json")
                header("Accept", "application/json")
            }
        }
    }
}
