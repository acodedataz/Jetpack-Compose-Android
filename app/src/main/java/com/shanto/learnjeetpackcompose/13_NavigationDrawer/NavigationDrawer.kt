package com.shanto.learnjeetpackcompose.`13_NavigationDrawer`

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shanto.learnjeetpackcompose.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawerExample() {

    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )

    val scope = rememberCoroutineScope()

    // Selected Drawer Item
    var selectedItem by remember {
        mutableStateOf("Home")
    }

    val englishFonts = FontFamily(
        Font(R.font.alatsi_regular)
    )

    ModalNavigationDrawer(

        drawerState = drawerState,

        drawerContent = {

            ModalDrawerSheet(
                modifier = Modifier.width(280.dp)
            ) {

                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState())
                ) {

                    Text(
                        text = "Navigation Drawer",
                        style = MaterialTheme.typography.headlineSmall,
                        fontFamily = englishFonts
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    HorizontalDivider()

                    Spacer(modifier = Modifier.height(12.dp))

                    // Home Item
                    NavigationDrawerItem(

                        label = {
                            Text("Home")
                        },

                        selected = selectedItem == "Home",

                        onClick = {

                            selectedItem = "Home"

                            scope.launch {
                                drawerState.close()
                            }
                        },

                        icon = {
                            Icon(
                                Icons.Default.Home,
                                contentDescription = "Home"
                            )
                        }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Settings Item
                    NavigationDrawerItem(

                        label = {
                            Text("Settings")
                        },

                        selected = selectedItem == "Settings",

                        onClick = {

                            selectedItem = "Settings"

                            scope.launch {
                                drawerState.close()
                            }
                        },

                        icon = {
                            Icon(
                                Icons.Default.Settings,
                                contentDescription = "Settings"
                            )
                        }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // About Item
                    NavigationDrawerItem(

                        label = {
                            Text("About")
                        },

                        selected = selectedItem == "About",

                        onClick = {

                            selectedItem = "About"

                            scope.launch {
                                drawerState.close()
                            }
                        },

                        icon = {
                            Icon(
                                Icons.Default.Info,
                                contentDescription = "About"
                            )
                        }
                    )
                }
            }
        }
    ) {

        Scaffold(

            topBar = {

                TopAppBar(

                    title = {
                        Text(
                            "Navigation Drawer",
                            fontFamily = englishFonts
                        )
                    },

                    navigationIcon = {

                        IconButton(
                            onClick = {

                                scope.launch {

                                    if (drawerState.isClosed) {
                                        drawerState.open()
                                    } else {
                                        drawerState.close()
                                    }
                                }
                            }
                        ) {

                            Icon(
                                Icons.Default.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    }
                )
            }

        ) { innerPadding ->

            Column(
                modifier = Modifier.padding(innerPadding)
            ) {

                Text(
                    text = "Selected Item : $selectedItem",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ShowPreviewDrawer() {
    NavigationDrawerExample()
}