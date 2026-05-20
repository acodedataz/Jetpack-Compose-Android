package com.shanto.learnjeetpackcompose.`19_SnackBar`

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun SnackBarExample() {
    val snackBarHostState = remember {
        SnackbarHostState()
    }
    val scope = rememberCoroutineScope()
    Scaffold(snackbarHost = {
        SnackbarHost(
            hostState = snackBarHostState
        ) { snackBarData ->
            Snackbar(
                snackbarData = snackBarData,
                modifier = Modifier.padding(16.dp),
                shape = MaterialTheme.shapes.large,
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                actionContentColor = MaterialTheme.colorScheme.primary
            )
        }
    }, floatingActionButton = {
        ExtendedFloatingActionButton(text = {
            Text(text = "Show SnackBar")
        }, icon = {
            Icon(
                imageVector = Icons.Default.Notifications, contentDescription = "Notification Icon"
            )
        }, onClick = {
            scope.launch {
                val result = snackBarHostState.showSnackbar(
                    message = "Photo uploaded successfully 📸",
                    actionLabel = "Undo",
                    duration = SnackbarDuration.Short
                )
                when (result) {
                    SnackbarResult.ActionPerformed -> {
                        // Undo action
                    }

                    SnackbarResult.Dismissed -> {
                        // Snackbar dismissed
                    }
                }
            }
        })
    }) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding), contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Tap the FAB to show SnackBar", style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

// Show Ui Design
@Preview(showSystemUi = true)
@Composable
fun SnackBarPreview() {
    SnackBarExample()
}