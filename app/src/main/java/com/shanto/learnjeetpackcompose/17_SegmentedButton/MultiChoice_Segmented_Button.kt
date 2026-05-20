package com.shanto.learnjeetpackcompose.`17_SegmentedButton`

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.DirectionsWalk
import androidx.compose.material.icons.filled.DirectionsBus
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SegmentedButtonExample() {

    val selectedOptions = remember {
        mutableStateListOf(false, false, false)
    }

    val options = listOf("Walk", "Ride", "Drive")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),

        contentAlignment = Alignment.Center
    ) {

        MultiChoiceSegmentedButtonRow(
            space = 8.dp
        ) {

            options.forEachIndexed { index, label ->

                SegmentedButton(

                    shape = SegmentedButtonDefaults.itemShape(
                        index = index,
                        count = options.size
                    ),

                    checked = selectedOptions[index],

                    onCheckedChange = {
                        selectedOptions[index] = it
                    },

                    icon = {
                        SegmentedButtonDefaults.Icon(
                            active = selectedOptions[index]
                        )
                    },

                    label = {

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {

                            when (label) {

                                "Walk" -> {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.DirectionsWalk,
                                        contentDescription = "Walk"
                                    )
                                }

                                "Ride" -> {
                                    Icon(
                                        imageVector = Icons.Default.DirectionsBus,
                                        contentDescription = "Ride"
                                    )
                                }

                                "Drive" -> {
                                    Icon(
                                        imageVector = Icons.Default.DirectionsCar,
                                        contentDescription = "Drive"
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.width(6.dp))

                            Text(
                                text = label,
                                style = MaterialTheme.typography.labelLarge
                            )
                        }
                    }
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SegmentedButtonPreview() {
    SegmentedButtonExample()
}