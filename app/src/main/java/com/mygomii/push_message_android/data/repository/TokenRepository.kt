package com.mygomii.push_message_android.data.repository

import com.mygomii.push_message_android.data.models.TokenRes

interface TokenRepository {
    suspend fun postToken(token: String): TokenRes
}