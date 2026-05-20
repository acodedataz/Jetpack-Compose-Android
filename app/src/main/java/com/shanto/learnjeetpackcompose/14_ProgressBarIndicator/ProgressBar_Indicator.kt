package com.shanto.learnjeetpackcompose.`14_ProgressBarIndicator`

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Android CircularProgressIndicator in Jetpack Compose
@Composable
fun CircularProgressIndicatorExample() {

    var loading by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = {
                loading = !loading
            }
        ) {
            Text(
                if (loading) "Stop Loading"
                else "Start Loading"
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (loading) {

            CircularProgressIndicator(
                modifier = Modifier.size(70.dp),
                strokeWidth = 6.dp,
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )

        }
    }
}

// Preview
@Preview(showSystemUi = true)
@Composable
fun ProgressBarIndicatorPreview() {
    CircularProgressIndicatorExample()
}