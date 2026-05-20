package com.shanto.learnjeetpackcompose.`6_CardDesign`

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.shanto.learnjeetpackcompose.ui.theme.White

// This is Cards Design in Android

@Composable
fun ElevatedCardsExample() {


    // Custom Font
    val AlatasiFonts = FontFamily(
        Font(R.font.alatsi_regular)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 18.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ElevatedCard(
                elevation = CardDefaults.elevatedCardElevation(3.dp),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = Color.Cyan
                ),
                modifier = Modifier.size(width = 200.dp, height = 200.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "First Card",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontFamily = AlatasiFonts,
                    )
                    Text(
                        "Hello Samiya",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontFamily = AlatasiFonts,
                    )
                }

            }

            ElevatedCard(
                elevation = CardDefaults.elevatedCardElevation(3.dp),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = Color.Cyan
                ),
                modifier = Modifier.size(width = 200.dp, height = 200.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Second Card",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontFamily = AlatasiFonts,
                    )
                    Text(
                        "Hello Munni",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontFamily = AlatasiFonts,
                    )
                }

            }
        }

    }
}

// Show Ui Design
@Preview(showSystemUi = true)
@Composable
fun CardPreview() {
    ElevatedCardsExample()
}