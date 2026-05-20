package com.shanto.learnjeetpackcompose.`21_Switch`

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SwitchExample() {

    var checked by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Switch(
            checked = checked,
            onCheckedChange = { checked = it },

            // Switch Color Customization
            colors = SwitchDefaults.colors(
                checkedThumbColor = androidx.compose.ui.graphics.Color.Green,
                checkedTrackColor = androidx.compose.ui.graphics.Color(0xFFB9F6CA),

                uncheckedThumbColor = androidx.compose.ui.graphics.Color.Red,
                uncheckedTrackColor = androidx.compose.ui.graphics.Color.LightGray
            ),

            // Thumb Icon
            thumbContent = {
                Icon(
                    imageVector = if (checked)
                        Icons.Default.Check
                    else
                        Icons.Default.Close,

                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize)
                )
            }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun SwitchExamplePreview() {
    SwitchExample()
}