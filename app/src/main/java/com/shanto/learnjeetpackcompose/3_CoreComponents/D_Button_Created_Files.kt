package com.shanto.learnjeetpackcompose.`3_CoreComponents`

import android.R.attr.onClick
import android.widget.Button
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview


// Field Button Created
@Composable
fun FieldButtonCreated() {
    var context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Button(
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }) {
            Text("My First Button")
        }
    }
}

// Tonal Button Created
@Composable
fun FilledTonalButtonExample() {
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        FilledTonalButton(
            onClick = {
                Toast.makeText(context, "Clicked!", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text("Filled Tonal Button")
        }
    }
}

// Outline Button Created
@Composable
fun OutlineButtonCreated(){
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        OutlinedButton(
            onClick = {
                Toast.makeText(context, "", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text("Outline Button")
        }
    }
}

// Elevated Button Created
@Composable
fun ElevatedButtonCreated(){
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        ElevatedButton(
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text("Clicked")
        }
    }
}

// Text Button Created
@Composable
fun TextButtonCreated(){
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        TextButton(
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text("Text Button")
        }
    }
}

// Show Preview Ui Design
//@Preview(showSystemUi = true)
//@Composable
//fun ShowPreview() {
//    TextButtonCreated()
//}