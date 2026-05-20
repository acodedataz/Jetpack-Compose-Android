package com.shanto.learnjeetpackcompose.`4_LayoutComposable`

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


// Modifiers
// Modifier in Details : image, text, composeable Layout design , button , Etc..

@Composable
fun ModifierExample() {

    Box(
        modifier = Modifier
            .size(500.dp)
            .background(color = Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "Hello Jetpack Android",
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier.background(color = Color.Black)
        )
    }
}


// Show in Design the Preview
@Preview(showSystemUi = true)
@Composable
fun modifierPreview() {
    ModifierExample()
}