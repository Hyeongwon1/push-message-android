package com.mygomii.push_message_android.data.models

import kotlinx.serialization.Serializable

@Serializable
data class TokenReq(
    val token: String,
)