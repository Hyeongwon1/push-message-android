package com.mygomii.push_message_android.data.repository

import com.mygomii.push_message_android.data.models.TokenRes
import kotlinx.coroutines.flow.Flow

interface TokenRepository {
    suspend fun postToken(token: String): Flow<TokenRes>
}