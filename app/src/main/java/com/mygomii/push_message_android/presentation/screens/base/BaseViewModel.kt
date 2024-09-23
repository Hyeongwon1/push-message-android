package com.mygomii.push_message_android.presentation.screens.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import org.koin.core.component.KoinComponent

abstract class BaseViewModel : ViewModel(), KoinComponent {
    protected val viewModelScope = CoroutineScope(Dispatchers.Main)

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}