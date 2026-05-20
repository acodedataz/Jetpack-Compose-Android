package com.shanto.learnjeetpackcompose.`10_FloatingActionButton`

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.shanto.learnjeetpackcompose.R

// Extended Floating Action Button
// in Jetpack Compose Android Kotlin Language
@Composable
fun ExtendedFabExample() {

    val context = LocalContext.current
    val fonts_alatasi = FontFamily(
        Font(R.font.alatsi_regular)
    )

    Scaffold(

        floatingActionButton = {

            ExtendedFloatingActionButton(

                // On Click Code here
                onClick = {
                    Toast.makeText(
                        context, "Extended FAB Clicked", Toast.LENGTH_SHORT
                    ).show()
                },

                // Button icon Adding
                icon = {
                    Icon(
                        imageVector = Icons.Default.Add, contentDescription = "Add"
                    )
                },

                // Button Text
                text = {
                    Text(
                        text = "Add Item", fontFamily = fonts_alatasi, fontSize = 17.sp
                    )
                }

            )

        }

    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Extended Floating Action Button Example",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                fontFamily = fonts_alatasi,
                fontSize = 19.sp
            )

        }

    }

}

@Preview(showBackground = true)
@Composable
fun PreviewExtendedFabExample() {
    ExtendedFabExample()
}