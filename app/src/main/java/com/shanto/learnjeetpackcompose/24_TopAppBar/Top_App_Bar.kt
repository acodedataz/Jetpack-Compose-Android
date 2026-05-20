package com.shanto.learnjeetpackcompose.`24_TopAppBar`

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarExample() {

    TopAppBar(

        title = {
            Column {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Home",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        tint = Color.DarkGray
                    )
                }

                Text(
                    text = "This is The Location Dhaka",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium
                )
            }
        },

        navigationIcon = {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = "Location",
                modifier = Modifier.size(32.dp),
                tint = Color.Red
            )
        },

        actions = {

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        color = Color.LightGray,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "H",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Blue
                )
            }

            Spacer(modifier = Modifier.width(8.dp))
        },

        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White
        )
    )
}

@Preview(showSystemUi = true)
@Composable
fun TopAppBarPreview() {
    TopAppBarExample()
}