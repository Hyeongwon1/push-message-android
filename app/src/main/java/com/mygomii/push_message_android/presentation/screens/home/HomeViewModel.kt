package com.mygomii.push_message_android.presentation.screens.home

import com.mygomii.push_message_android.domain.TokenUsecase
import com.mygomii.push_message_android.presentation.screens.base.BaseViewModel
import com.mygomii.push_message_android.presentation.status.UIStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class HomeViewModel(
    private val tokenUsecase: TokenUsecase,
) : BaseViewModel() {
    private val _uiStatus = MutableStateFlow<UIStatus>(UIStatus.Loading)
    val uiStatus: StateFlow<UIStatus> = _uiStatus


    fun postToken(token: String) {
        viewModelScope.launch {
            tokenUsecase.invoke(token = token)
                .map(UIStatus::Success)
                .onEach { value ->
                    println("###### Screen state updated: $value")
                    _uiStatus.value = value
                }
                .catch { e ->
                    println("###### Error occurred: ${e.message}")
                    _uiStatus.value = UIStatus.Failure(e.message.toString())
                }
                .launchIn(viewModelScope)
        }


    }
}