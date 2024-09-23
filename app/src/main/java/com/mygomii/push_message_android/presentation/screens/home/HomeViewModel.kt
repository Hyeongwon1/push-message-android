package com.mygomii.push_message_android.presentation.screens.home

import com.mygomii.push_message_android.data.repository.TokenRepository
import com.mygomii.push_message_android.presentation.screens.base.BaseViewModel
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: TokenRepository,
) : BaseViewModel() {

    fun postToken(token: String) {
        viewModelScope.launch {
            repository.postToken(token)
        }
    }
}