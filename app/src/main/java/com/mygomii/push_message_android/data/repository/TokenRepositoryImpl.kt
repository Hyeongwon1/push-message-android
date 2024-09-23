package com.mygomii.push_message_android.data.repository

import com.mygomii.push_message_android.data.datasources.TokenDatasource
import com.mygomii.push_message_android.data.models.TokenRes

class TokenRepositoryImpl(
    private val datasource: TokenDatasource
) : TokenRepository {
    override suspend fun postToken(token: String): TokenRes {
        return datasource.postToken(token)
    }
}