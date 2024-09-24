package com.mygomii.push_message_android.data.datasources

import com.mygomii.push_message_android.data.models.TokenRes
import kotlinx.coroutines.flow.Flow

interface TokenDatasource {
    suspend fun postToken(token: String): Flow<TokenRes>
}