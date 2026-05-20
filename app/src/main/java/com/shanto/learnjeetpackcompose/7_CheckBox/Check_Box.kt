package com.shanto.learnjeetpackcompose.`7_CheckBox`

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.util.fastForEachIndexed

// Check Box Creating in Android Application

@Composable
fun CheckBoxExample() {

    val childCheckState = remember {
        mutableStateListOf(false, false, false)
    }

    val parentState = when {
        childCheckState.all { it } -> ToggleableState.On
        childCheckState.none { it } -> ToggleableState.Off
        else -> ToggleableState.Indeterminate
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text("Select All")

            TriStateCheckbox(
                state = parentState,
                onClick = {

                    val newState = parentState != ToggleableState.On

                    childCheckState.fastForEachIndexed { index, _ ->
                        childCheckState[index] = newState
                    }
                }
            )
        }

        childCheckState.forEachIndexed { index, checked ->

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text("Option ${index + 1}")

                Checkbox(
                    checked = checked,
                    onCheckedChange = {
                        childCheckState[index] = it
                    }
                )
            }
        }

        if (childCheckState.all { it }) {
            Text("All Option Selected")
        }
    }
}

// Show Preview Ui Design
@Preview(showSystemUi = true)
@Composable
fun CheckBoxPreview() {
    CheckBoxExample()
}