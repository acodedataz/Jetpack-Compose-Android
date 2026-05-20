package com.shanto.learnjeetpackcompose.`22_DateAndTimePicker`

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun DateTimePickerExample() {

    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    var selectedDateTime by remember {
        mutableStateOf("Select Date & Time")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        OutlinedButton(
            onClick = {

                // Date Picker
                DatePickerDialog(
                    context,
                    { _, year, month, day ->

                        // Time Picker
                        TimePickerDialog(
                            context,
                            { _, hour, minute ->

                                calendar.set(
                                    year,
                                    month,
                                    day,
                                    hour,
                                    minute
                                )

                                val formatter =
                                    SimpleDateFormat(
                                        "dd/MM/yyyy hh:mm a",
                                        Locale.getDefault()
                                    )

                                selectedDateTime =
                                    formatter.format(calendar.time)

                            },
                            calendar.get(Calendar.HOUR_OF_DAY),
                            calendar.get(Calendar.MINUTE),
                            false
                        ).show()

                    },
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                ).show()

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = selectedDateTime)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewDateTimePicker() {
    DateTimePickerExample()
}