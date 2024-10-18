package com.mygomii.push_message_android.data.datasources

import android.provider.Settings
import com.mygomii.push_message_android.NotificationApp
import com.mygomii.push_message_android.const.BASE_URL
import com.mygomii.push_message_android.data.models.TokenReq
import com.mygomii.push_message_android.data.models.TokenRes
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TokenDatasourceImpl(
    private val client: HttpClient,
) : TokenDatasource {
    override suspend fun postToken(token: String): Flow<TokenRes> {
        return flow {
            emit(
                client.post("$BASE_URL/token") {
                    setBody(TokenReq(token))
                }.body()
            )
        }
    }
}

object DeviceUtils {
    fun getDeviceId(): String {
        return Settings.Secure.getString(
            NotificationApp.app.contentResolver,
            Settings.Secure.ANDROID_ID
        )
    }
}