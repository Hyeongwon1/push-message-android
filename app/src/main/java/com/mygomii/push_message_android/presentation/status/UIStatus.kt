package com.mygomii.push_message_android.presentation.status

import com.mygomii.push_message_android.data.models.TokenRes

sealed class UIStatus {
    data object Loading : UIStatus()
    data class Success(val tokenRes: TokenRes): UIStatus()
    data class Failure(val message: String): UIStatus()

}
