package com.mygomii.push_message_android.data.datasources

import com.mygomii.push_message_android.data.models.TokenRes

interface TokenDatasource {
    suspend fun postToken(token: String): TokenRes
}