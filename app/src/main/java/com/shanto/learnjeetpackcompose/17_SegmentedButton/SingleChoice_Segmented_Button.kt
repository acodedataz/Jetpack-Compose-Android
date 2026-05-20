package com.shanto.learnjeetpackcompose.`17_SegmentedButton`

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SingleChoiceSegmentedButtonExample() {

    val options = listOf("Light", "Dark")

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),

        contentAlignment = Alignment.Center
    ) {

        SingleChoiceSegmentedButtonRow {

            options.forEachIndexed { index, label ->

                SegmentedButton(

                    shape = SegmentedButtonDefaults.itemShape(
                        index = index, count = options.size
                    ),

                    selected = selectedIndex == index,

                    onClick = {
                        selectedIndex = index
                    },

                    label = {

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {

                            if (label == "Light") {

                                Icon(
                                    imageVector = Icons.Default.LightMode,
                                    contentDescription = "Light Mode"
                                )

                            } else {

                                Icon(
                                    imageVector = Icons.Default.DarkMode,
                                    contentDescription = "Dark Mode"
                                )
                            }

                            Spacer(modifier = Modifier.width(6.dp))

                            Text(
                                text = label, style = MaterialTheme.typography.labelLarge
                            )
                        }
                    })
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SingleChoiceSegmentedButtonPreview() {
    SingleChoiceSegmentedButtonExample()
}