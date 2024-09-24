package com.mygomii.push_message_android.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.tasks.Task
import com.google.firebase.messaging.FirebaseMessaging
import com.mygomii.push_message_android.presentation.status.UIStatus
import org.koin.compose.getKoin


@Composable
fun HomeScreen(viewModel: HomeViewModel = getKoin().get()) {
    val token = remember { mutableStateOf("") }

    FirebaseMessaging.getInstance().token.addOnCompleteListener { task: Task<String> ->
        if (!task.isSuccessful) {
            return@addOnCompleteListener
        }

        token.value = task.result
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (val uiStatus = viewModel.uiStatus.collectAsState().value) {
            is UIStatus.Failure -> FailureScreen(viewModel, token.value, uiStatus.message)
            UIStatus.Loading -> LoadScreen(viewModel, token.value)
            is UIStatus.Success -> SuccessScreen(token.value)
        }
    }
}

@Composable
fun LoadScreen(viewModel: HomeViewModel, token: String) {
    Button(
        modifier = Modifier
            .padding(4.dp),
        onClick = {
            viewModel.postToken(token)
        }
    ) {
        Text(
            text = "TOKEN 보내기",
            fontSize = 24.sp
        )
    }
}

@Composable
fun SuccessScreen(token: String) {
    DescriptionView(message = "token 보내기 성공!!!")

    Text(
        text = token,
        fontSize = 16.sp
    )
}

@Composable
fun FailureScreen(viewModel: HomeViewModel, token: String, message: String) {
    DescriptionView(message = "token 실패 : $message")

    LoadScreen(viewModel, token)
}


@Composable
fun DescriptionView(message: String) {
    Text(
        text = message,
        fontSize = 16.sp
    )

    Spacer(modifier = Modifier.padding(top = 10.dp))

}