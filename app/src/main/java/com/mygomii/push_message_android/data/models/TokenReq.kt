package com.mygomii.push_message_android.data.models

import com.mygomii.push_message_android.data.datasources.DeviceUtils
import kotlinx.serialization.Serializable

@Serializable
data class TokenReq(
    val token: String,
    val deviceId: String = DeviceUtils.getDeviceId(),
)