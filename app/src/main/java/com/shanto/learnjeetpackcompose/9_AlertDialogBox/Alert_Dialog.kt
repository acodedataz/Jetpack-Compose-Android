package com.shanto.learnjeetpackcompose.`9_AlertDialogBox`

import android.widget.Toast
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NormalAlertDialog() {

    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(true) }

    if (showDialog) {

        AlertDialog(

            onDismissRequest = {
                showDialog = false
            },

            title = {
                Text(text = "Delete File")
            },

            text = {
                Text(
                    text = "Are you sure you want to delete this file?"
                )
            },

            confirmButton = {

                Button(
                    onClick = {

                        Toast.makeText(
                            context, "File Deleted", Toast.LENGTH_SHORT
                        ).show()

                        showDialog = false
                    }) {
                    Text("Delete")
                }
            },

            dismissButton = {

                TextButton(
                    onClick = {
                        showDialog = false
                    }) {
                    Text("Cancel")
                }
            })
    }
}

@Preview(showSystemUi = true)
@Composable
fun ShowNormalAlertDialog() {
    NormalAlertDialog()
}