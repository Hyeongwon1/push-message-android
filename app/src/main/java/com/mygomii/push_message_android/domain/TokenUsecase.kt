package com.mygomii.push_message_android.domain

import com.mygomii.push_message_android.data.models.TokenRes
import com.mygomii.push_message_android.data.repository.TokenRepository
import kotlinx.coroutines.flow.Flow

class TokenUsecase(
    private val tokenRepository: TokenRepository,
) {
    suspend fun invoke(token: String): Flow<TokenRes> = tokenRepository.postToken(token)

}