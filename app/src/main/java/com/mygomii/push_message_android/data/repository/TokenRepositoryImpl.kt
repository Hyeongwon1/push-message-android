package com.mygomii.push_message_android.data.repository

import com.mygomii.push_message_android.data.datasources.TokenDatasource
import com.mygomii.push_message_android.data.models.TokenRes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TokenRepositoryImpl(
    private val datasource: TokenDatasource,
) : TokenRepository {
    override suspend fun postToken(token: String): Flow<TokenRes> = datasource.postToken(token)
}