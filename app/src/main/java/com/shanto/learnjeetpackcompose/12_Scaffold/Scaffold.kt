package com.shanto.learnjeetpackcompose.`12_Scaffold`

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shanto.learnjeetpackcompose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {

    var pressCount by remember { mutableStateOf(0) }

    val fonts_alatasi = FontFamily(
        Font(R.font.alatsi_regular)
    )

    Scaffold(

        // TOP BAR
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Scaffold Demo",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        color = Color.Black,
                        fontFamily = fonts_alatasi
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        },

        // BOTTOM BAR
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ) {
                Text(
                    text = "Bottom Navigation Area",
                    modifier = Modifier.padding(16.dp),
                    fontFamily = fonts_alatasi,
                    fontSize = 19.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        },

        // FLOATING ACTION BUTTON
        floatingActionButton = {
            FloatingActionButton(
                onClick = { pressCount++ }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        }

    ) { innerPadding ->

        // CONTENT AREA
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "FAB Press Count",
                    style = MaterialTheme.typography.titleMedium,
                    fontFamily = fonts_alatasi,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "$pressCount",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

// Show Ui Design
@Preview(showSystemUi = true)
@Composable
fun ShowScaffoldPreview() {
    ScaffoldExample()
}