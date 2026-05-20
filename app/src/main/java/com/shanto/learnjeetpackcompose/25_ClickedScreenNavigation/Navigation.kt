package com.shanto.learnjeetpackcompose.`25_ClickedScreenNavigation`

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

@Composable
fun App() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Navigation.Main
    ) {

        navigation<Navigation.Main>(
            startDestination = Routes.Home
        ) {

            composable<Routes.Home> {
                HomeScreen(navController = navController)
            }

            composable<Routes.Wishlist> {
                WishlistScreen(navController = navController)
            }
        }
    }
}