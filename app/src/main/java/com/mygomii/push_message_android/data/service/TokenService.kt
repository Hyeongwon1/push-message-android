package com.mygomii.push_message_android.data.service

import com.mygomii.push_message_android.const.BASE_URL
import com.mygomii.push_message_android.data.models.TokenReq
import com.mygomii.push_message_android.data.models.TokenRes
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody

class TokenService(
    private val client: HttpClient,
) {
    suspend fun postToken(token: String): TokenRes {
        return client.post("$BASE_URL/token") {
            setBody(TokenReq(token))
        }.body()
    }
}