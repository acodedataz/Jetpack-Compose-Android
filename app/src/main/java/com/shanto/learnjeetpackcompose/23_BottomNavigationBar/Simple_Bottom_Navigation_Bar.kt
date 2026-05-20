package com.shanto.learnjeetpackcompose.`23_BottomNavigationBar`

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


data class BottomNavItems(
    val name: String, val icon: ImageVector, val unselectedIcon: ImageVector
)

@Composable
fun SimpleBottomNavigationBarExample() {

    var selectedItem by remember {
        mutableIntStateOf(0)
    }

    val bottomNavItems = listOf(

        BottomNavItem(
            "Home",
            Icons.Default.Home,
            Icons.Outlined.Home
        ),

        BottomNavItem(
            "Wish List",
            Icons.Default.Favorite,
            Icons.Outlined.FavoriteBorder
        ),

        BottomNavItem(
            "Cart",
            Icons.Default.ShoppingCart,
            Icons.Outlined.ShoppingCart
        ),

        BottomNavItem(
            "Profile",
            Icons.Default.Person,
            Icons.Outlined.Person
        )
    )

    Scaffold(

        bottomBar = {

            Surface(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(
                    topStart = 24.dp,
                    topEnd = 24.dp
                ),

                tonalElevation = 8.dp,
                color = MaterialTheme.colorScheme.surface
            ) {

                NavigationBar(

                    containerColor = Color.Transparent

                ) {

                    bottomNavItems.forEachIndexed { index, navigationItem ->

                        NavigationBarItem(

                            selected = selectedItem == index,

                            onClick = {

                                selectedItem = index

                                when (index) {

                                    0 -> {}

                                    1 -> {}

                                    2 -> {}

                                    3 -> {}
                                }
                            },

                            icon = {

                                Icon(

                                    imageVector =
                                        if (selectedItem == index) {
                                            navigationItem.icon
                                        } else {
                                            navigationItem.unselectedIcon
                                        },

                                    contentDescription =
                                        navigationItem.name
                                )
                            },

                            label = {
                                Text(text = navigationItem.name)
                            }
                        )
                    }
                }
            }
        }

    ) { innerPadding ->

    }
}

// Show Preview Design
@Preview(showSystemUi = true)
@Composable
fun BottomNavigationPreview() {
    SimpleBottomNavigationBarExample()
}