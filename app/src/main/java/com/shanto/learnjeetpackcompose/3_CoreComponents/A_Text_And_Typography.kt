package com.shanto.learnjeetpackcompose.`3_CoreComponents`

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shanto.learnjeetpackcompose.R


// Normal Text Color and Shadow Usg
@Composable
fun Demo_Text() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.Shanto_Text),
            color = Color.Blue,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            //Shadow
            style = TextStyle(
                shadow = Shadow(Color.Black, blurRadius = 3f)
            )
        )
    }
}

// Normal Text Using for Rainbow Color
@Composable
fun Colorful_Text() {
    val rainbowColors = listOf(
        Color.Black, Color.Red,
        Color.Green, Color.Yellow,
        Color.Gray, Color.DarkGray
    )
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(
            text = buildAnnotatedString {
                append("Don't Allow People To Dim Your Shine \n")
                withStyle(
                    SpanStyle(
                        brush = Brush.linearGradient(
                            colors = rainbowColors
                        )
                    )
                ) {
                    append("This is Blended Color Here \n")
                }
                append("Tell Them To Put Some Sunglasses on")
            })
    }
}


// This is Scrolling Text Practice
@Composable
fun Scrolling_Text(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "This is Rahatul Hossen Shanto and I'm Experimanting in Jetpack Compose".repeat(20),
            //modifier = Modifier.basicMarquee(),   //----> Text Headline type System
            fontSize = 30.sp,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif
        )
    }
}

// ChatGPT Example UI Design Compose Code Here : --->
@Composable
fun ProfileCard() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.paste_color)),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Rahatul Hossen Shanto",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Android Developer",
                    fontSize = 16.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = { }) {
                    Text("Follow")
                }
            }
        }
    }
}


// Preview Showing Ui Design
@Preview
@Composable
fun Preview_Ui_Design() {
    ProfileCard()
}