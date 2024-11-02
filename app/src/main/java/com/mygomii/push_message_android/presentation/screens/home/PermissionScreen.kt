package com.mygomii.push_message_android.presentation.screens.home

import android.Manifest
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun NotificationPermissionHandler() {
    val isAndroid13Plus = Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU

    if (isAndroid13Plus) {
        val notificationPermissionState =
            rememberPermissionState(permission = Manifest.permission.POST_NOTIFICATIONS)

        LaunchedEffect(Unit) {
            if (notificationPermissionState.status.isGranted) {
                notificationPermissionState.launchPermissionRequest()
            }
        }

        when {
            notificationPermissionState.status.isGranted -> NotificationGrantedContent()
            notificationPermissionState.status.shouldShowRationale -> NotificationRationaleContent(
                onRequestPermission = { notificationPermissionState.launchPermissionRequest() }
            )

            else -> NotificationDeniedContent()

        }
    } else {
        NotificationGrantedContent()
    }


}


@Composable
fun NotificationGrantedContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HomeScreen()
    }
}


@Composable
fun NotificationRationaleContent(onRequestPermission: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "앱에서 알림을 표시하기 위해 권한이 필요합니다.")
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = onRequestPermission) {
            Text(text = "권한 허용")
        }
    }
}


@Composable
fun NotificationDeniedContent() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "알림 권한이 거부되었습니다. 설정에서 권한을 허용해 주세요.")
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            openSettings(context)
        }) {
            Text(text = "설정으로 이동")
        }
    }
}

fun openSettings(context: Context) {
    context.startActivity(
        Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
            data =
                android.net.Uri.fromParts("package", context.packageName, null)
        }
    )
}
