package com.mygomii.push_message_android.data.datasources

import com.mygomii.push_message_android.data.models.TokenRes
import com.mygomii.push_message_android.data.service.TokenService

class TokenDatasourceImpl(
    private val service: TokenService,
) : TokenDatasource {
    override suspend fun postToken(token: String): TokenRes {
        return service.postToken(token)
    }
}