package com.shanto.learnjeetpackcompose.`3_CoreComponents`


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

// Ekhane Ame Korbo Holo. User Theke Input Newar TextOutLine Field Example : Name,Email,Password
// Login,Signup,Form Fillup System. Mainly System is User Inputing System.
// Starting Design in Input Box @Composable

@Composable
fun TextOutlineFiled_UserInput() {
    var text by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        // OutlineTextField_InputBox
        OutlinedTextField(value = text, onValueChange = { newText ->
            text = newText
        }, label = {
            Text("Input Your Name")
        })
    }
}


// Input Box Coloring Input Text Color
@Composable
fun My_Ui() {
    val rainbowColors = listOf(
        Color.Red,
        Color.Blue,
        Color.Cyan,
        Color.Gray
    )

    var text1 by remember {
        mutableStateOf("")
    }

    val brush = remember {
        Brush.linearGradient(
            colors = rainbowColors
        )
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        TextField(
            value = text1,
            onValueChange = {
                text1 = it
            },
            textStyle = TextStyle(brush = brush)
        )
    }
}


// Input Box Text Field With Password Type
@Composable
fun Password_TextField(){
    var password by rememberSaveable() {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ){
        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text("Enter Your Password")
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )
    }
}


// Show Preview Ui Design in Live Frame /***
//@Preview(showSystemUi = true)
//@Composable
//fun Show_Preview1(){
//    My_Ui()
//}

//@Preview(showSystemUi = true)
//@Composable
//fun Show_Preview2(){
//    TextOutlineFiled_UserInput()
//}

//@Preview(name = "Password Preview", showSystemUi = true)
//@Composable
//fun TextPassword_Preview(){
//    Password_TextField()
//}