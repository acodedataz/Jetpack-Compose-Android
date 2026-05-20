package com.shanto.learnjeetpackcompose.`3_CoreComponents`

import android.graphics.Paint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shanto.learnjeetpackcompose.R

@Composable
fun ShowingImagesFiles() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        // Colors Created
        val rainbowColors = remember {
            Brush.sweepGradient(
                listOf(
                    Color.Blue, Color.Red, Color.Yellow, Color.DarkGray, Color.Green
                )
            )
        }
        val borderWidth = 4.dp

        // Image Circle Shape, Image Saturation Adding, And Etc....
        Image(
            painter = painterResource(id = R.drawable.ai_automation),
            contentDescription = stringResource(id = R.string.Ai_Image_Description),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(300.dp)
                .clip(CircleShape),
//                .border(
//                    BorderStroke(borderWidth, rainbowColors)
//                ),
            alignment = Alignment.Center,
            //clip(CircleShape)
//            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
//                setToSaturation(0f)
//            })
        )
    }

}

// Showing Ui Image Preview
@Preview(showSystemUi = true)
@Composable
fun ImagePreviewShow() {
    ShowingImagesFiles()
}