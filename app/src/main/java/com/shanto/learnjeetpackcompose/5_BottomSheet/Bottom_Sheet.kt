package com.shanto.learnjeetpackcompose.`5_BottomSheet`

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shanto.learnjeetpackcompose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowPartialBottomSheet() {

    // Custom Fonts Use System
    val AlatsiFont = FontFamily(
        Font(R.font.alatsi_regular)
    )

    var showBottomSheet by remember {
        mutableStateOf(false)
    }

    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Button(
            modifier = Modifier.width(300.dp), onClick = {
                showBottomSheet = true
            }) {
            Text(
                "Open Bottom Sheet",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                fontFamily = AlatsiFont
            )
        }

        if (showBottomSheet) {

            ModalBottomSheet(
                modifier = Modifier.fillMaxHeight(), sheetState = sheetState, onDismissRequest = {
                    showBottomSheet = false
                }) {

                Text(
                    text = "This is Bottom Sheet",
                    modifier = Modifier.padding(16.dp),
                    fontSize = 22.sp,
                    color = Color.Blue
                )
            }
        }
    }
}

// Show Preview
@Preview(showSystemUi = true)
@Composable
private fun showBottomSheetPreview() {
    ShowPartialBottomSheet()
}