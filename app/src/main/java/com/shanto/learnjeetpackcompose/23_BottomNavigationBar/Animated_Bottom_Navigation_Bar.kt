package com.shanto.learnjeetpackcompose.`23_BottomNavigationBar`

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.bottombar.AnimatedBottomBar
import com.example.bottombar.components.BottomBarItem
import com.example.bottombar.model.IndicatorDirection
import com.example.bottombar.model.IndicatorStyle


data class BottomNavItem(
    val name: String, val icon: ImageVector, val unselectedIcon: ImageVector
)

@Composable
fun BottomNavigationBarExample() {

    var selectedItem by remember {
        mutableIntStateOf(0)
    }

    val bottomNavItems = listOf(

        BottomNavItem(
            "Home", Icons.Default.Home, Icons.Outlined.Home
        ),

        BottomNavItem(
            "Wish List", Icons.Default.Favorite, Icons.Outlined.FavoriteBorder
        ),

        BottomNavItem(
            "Cart", Icons.Default.ShoppingCart, Icons.Outlined.ShoppingCart
        ),

        BottomNavItem(
            "Profile", Icons.Default.Person, Icons.Outlined.Person
        )
    )

    Scaffold(

        bottomBar = {

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        bottom = WindowInsets.navigationBars.asPaddingValues()
                            .calculateBottomPadding()
                    ),

                shape = RoundedCornerShape(
                    topStart = 24.dp, topEnd = 24.dp
                ),

                tonalElevation = 8.dp
            ) {

                AnimatedBottomBar(

                    selectedItem = selectedItem,
                    itemSize = bottomNavItems.size,
                    containerColor = MaterialTheme.colorScheme.surface,
                    indicatorColor = MaterialTheme.colorScheme.primary,
                    indicatorDirection = IndicatorDirection.TOP,
                    indicatorStyle = IndicatorStyle.LINE

                ) {

                    bottomNavItems.forEachIndexed { index, navigationItem ->

                        BottomBarItem(

                            modifier = Modifier.align(
                                Alignment.Top
                            ),

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

                            imageVector = if (selectedItem == index) {
                                navigationItem.icon
                            } else {
                                navigationItem.unselectedIcon
                            },

                            label = navigationItem.name,

                            containerColor = Color.Transparent
                        )
                    }
                }
            }
        }

    ) { innerPadding ->

    }
}

// Show Preview Design
//@Preview(showSystemUi = true)
//@Composable
//fun BottomNavigationPreview() {
//    BottomNavigationBarExample()
//}