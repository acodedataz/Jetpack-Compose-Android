package com.shanto.learnjeetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.shanto.learnjeetpackcompose.`26_Animation`.AnimationBox
import com.shanto.learnjeetpackcompose.ui.theme.LearnJeetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnJeetpackComposeTheme {
                AnimationBox()
            }
        }
    }
}