package com.shanto.learnjeetpackcompose.`2_FundamentalsConcepts`

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.shanto.learnjeetpackcompose.R

// A ResourceAccess Files diyee Amra res--->folder er Shob Files Access korte parbo UI Build korte.


// Ekhane kora hoyeche, Color and String Text Access kora. and Etc...
@Composable
fun AccessStringResource() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(stringResource(R.string.Shanto_Text), color = colorResource(R.color.teal_700))
    }
}

// EKhane korbo ekhon Image Access Drwable theke.
@Composable
fun ImageAccess() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.ai_automation),
            contentDescription = stringResource(R.string.Ai_Image_Description)
        )
    }
}


//Preview Ui Design Show
//@Preview(showSystemUi = true)
//@Composable
//fun previewAccessResourceString() {
//    //AccessStringResource()
//    ImageAccess()
//}