package com.shanto.learnjeetpackcompose.`4_LayoutComposable`

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

// Column Example : 1
@Composable
fun ColumnExample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Hello Shanto! First Text", color = Color.White
        )
        Text("Hello Samiya")
        Text("Hello Munni")
        Text("Hello Nahima")
        Text("Hello Payel")
    }
}


// Row Example : 2
@Composable
fun RowExample() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            //.padding(5.dp)
            .background(Color.DarkGray),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Shanto", color = Color.White, modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "Munni", color = Color.White, modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "Shipa", color = Color.White, modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "Borsha", color = Color.White, modifier = Modifier.padding(8.dp)
        )
    }
}

// Box Example : 3
@Composable
fun BoxExample() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(color = Color.Red),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(color = Color.Black)
        ) {

        }
    }
}

// ConstraintLayout Example : 4 : Use Only When Needed and UI is Complex
@Composable
fun ConstraintLayoutDesign() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(color = Color.LightGray)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(
                    color = Color.DarkGray
                )

        ) {
            val (text1, text2, text3, text4, centerText, endText) = createRefs()
            //text1
            Text(
                "Bottom Left",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.constrainAs(text1) {
                    bottom.linkTo(parent.bottom, margin = 11.dp)
                    start.linkTo(parent.start, margin = 11.dp)
                })
            //text2
            Text(
                "Bottom Right",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.constrainAs(text2) {
                    bottom.linkTo(text1.bottom)
                    end.linkTo(parent.end, margin = 11.dp)
                })
            //text3
            Text(
                "Top Right",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.constrainAs(text3) {
                    start.linkTo(text2.start)
                    end.linkTo(text2.end)
                })
            //text4
            Text(
                "Top Left",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.constrainAs(text4) {
                    start.linkTo(text1.start)
                    end.linkTo(text1.end)
                })
            //CenterText
            Text(
                "This Center Text",
                color = Color.Magenta,
                fontSize = 20.sp,
                modifier = Modifier.constrainAs(centerText) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                })
            //Center End Text
            Text(
                "End Text",
                color = Color.Yellow,
                fontSize = 20.sp,
                modifier = Modifier.constrainAs(endText) {
                    start.linkTo(centerText.end)
                    bottom.linkTo(centerText.bottom)
                    end.linkTo(parent.end)
                })

        }
    }
}


// Show Preview
@Preview(showSystemUi = true)
@Composable
fun ShowPreview() {
    ConstraintLayoutDesign()
}