package com.mygomii.push_message_android.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.tasks.Task
import com.google.firebase.messaging.FirebaseMessaging
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
        Text(
            text = token.value,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.padding(top = 10.dp))

        Button(
            modifier = Modifier
                .padding(4.dp),
            onClick = {
                viewModel.postToken(token.value)
            }
        ) {
            Text(
                text = "TOKEN 보내기",
                fontSize = 24.sp
            )
        }
    }

}