package com.shanto.learnjeetpackcompose.`11_Menus`

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Logout
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MoreVertMenuExample() {

    // Menu Open / Close State
    var expanded by remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopEnd
    ) {

        Box(
            modifier = Modifier.padding(16.dp)
        ) {

            // More Vert Button
            IconButton(
                onClick = {
                    expanded = true
                }
            ) {

                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More Menu"
                )
            }

            // Dropdown Menu
            DropdownMenu(
                expanded = expanded,

                // Outside Click করলে Menu Close হবে
                onDismissRequest = {
                    expanded = false
                }
            ) {

                // Profile Item
                DropdownMenuItem(

                    text = {
                        Text("Profile")
                    },

                    leadingIcon = {
                        Icon(
                            Icons.Outlined.Person,
                            contentDescription = "Profile"
                        )
                    },

                    onClick = {

                        expanded = false

                        Toast
                            .makeText(
                                context,
                                "Profile Clicked",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }
                )

                // Settings Item
                DropdownMenuItem(

                    text = {
                        Text("Settings")
                    },

                    leadingIcon = {
                        Icon(
                            Icons.Outlined.Settings,
                            contentDescription = "Settings"
                        )
                    },

                    onClick = {

                        expanded = false

                        Toast
                            .makeText(
                                context,
                                "Settings Clicked",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }
                )

                HorizontalDivider()

                // About Item
                DropdownMenuItem(

                    text = {
                        Text("About")
                    },

                    leadingIcon = {
                        Icon(
                            Icons.Outlined.Info,
                            contentDescription = "About"
                        )
                    },

                    onClick = {

                        expanded = false

                        Toast
                            .makeText(
                                context,
                                "About Clicked",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }
                )

                // Logout Item
                DropdownMenuItem(

                    text = {
                        Text("Logout")
                    },

                    leadingIcon = {
                        Icon(
                            Icons.AutoMirrored.Outlined.Logout,
                            contentDescription = "Logout"
                        )
                    },

                    onClick = {

                        expanded = false

                        Toast
                            .makeText(
                                context,
                                "Logout Clicked",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ShowMoreVertMenuPreview() {

    MoreVertMenuExample()
}