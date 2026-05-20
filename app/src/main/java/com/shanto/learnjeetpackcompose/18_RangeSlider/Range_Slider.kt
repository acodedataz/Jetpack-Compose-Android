package com.shanto.learnjeetpackcompose.`18_RangeSlider`

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SliderExample() {

    var sliderPosition by remember {
        mutableFloatStateOf(15f)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),

        verticalArrangement = Arrangement.Center,

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Volume - ${sliderPosition.toInt()}%",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Slider(

            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),

            value = sliderPosition,

            onValueChange = {
                sliderPosition = it
            },

            valueRange = 0f..100f,

            steps = 0,

            colors = SliderDefaults.colors(

                thumbColor = MaterialTheme.colorScheme.primary,

                activeTrackColor = MaterialTheme.colorScheme.primary,

                inactiveTrackColor = MaterialTheme.colorScheme.primaryContainer
            )
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun SliderPreview() {
    SliderExample()
}