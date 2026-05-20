package com.shanto.learnjeetpackcompose.`20_Badges`

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height

@Composable
fun FacebookNotificationBadge() {

    var notificationCount by remember {
        mutableIntStateOf(0)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Notification Badge
        BadgedBox(
            badge = {
                if (notificationCount > 0) {
                    Badge(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ) {
                        Text(
                            text = if (notificationCount > 99)
                                "99+"
                            else
                                "$notificationCount"
                        )
                    }
                }
            }
        ) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notification Icon"
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                notificationCount++
            }
        ) {
            Text("New Notification")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun NotificationPreview() {
    FacebookNotificationBadge()
}