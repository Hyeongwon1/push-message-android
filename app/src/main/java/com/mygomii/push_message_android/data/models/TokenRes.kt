package com.mygomii.push_message_android.data.models

import kotlinx.serialization.Serializable

@Serializable
data class TokenRes(
    val isSuccess: Boolean,
    val token: String? = null,
)