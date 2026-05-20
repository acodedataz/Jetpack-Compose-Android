package com.shanto.learnjeetpackcompose.`26_Animation`

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AnimationBox() {

    var expanded by remember {
        mutableStateOf(false)
    }

    val size by animateDpAsState(
        targetValue = if (expanded) 200.dp else 100.dp,

        animationSpec = tween(
            durationMillis = 500,
            easing = FastOutSlowInEasing
        ),

        label = "Box Size Animation"
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .size(size)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.Blue)
                .clickable {
                    expanded = !expanded
                },

            contentAlignment = Alignment.Center
        ) {

            Text(
                text = if (expanded) "Expanded" else "Tap Me",
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AnimationPreview() {
    AnimationBox()
}