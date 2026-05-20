package com.shanto.learnjeetpackcompose.`2_FundamentalsConcepts`

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

// what is the Composable Function

// Eta holo Composable Ui Toiri korar Function @Composable dewa mane ata ame Ui Toiri kortechi
// Eta Only Composable Ui Function --
// Eta ekhon jemon ache kintu dekha jabe na Design ta, Hello Jetpack Compose
// Eta dekhar jonno, mane Composable ui Function diyee j Design ba ui toiri korbo,
// Ata dekhte hole nicha @Preview Function Toiri korte hove, and oi Preview Function ar bitore A Composable
// Function ti k Call korte hove , Tahole Design ti dekha jabe OK

// Noted : Jodi A Function k Tomar Main Orginal Mobile a dekhte chaw
// Tahole MainActivity tee Call kore daw @Composable Function ta k. OK

@Composable
fun Greeting() {
    Text(text = "Hello Jetpack Compose")
}

// Composable Function ar UI Design ti Dekhte hole @Preview Function Created korte hove
@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    Greeting()  //Composable Function ta , mane Design kora Function ta Call kora holo dekhar jonno
}