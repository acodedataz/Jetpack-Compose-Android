package com.shanto.learnjeetpackcompose.`25_ClickedScreenNavigation`

import kotlinx.serialization.Serializable

sealed class Navigation {

    @Serializable
    data object Main : Navigation()
}

sealed class Routes {

    @Serializable
    data object Home : Routes()

    @Serializable
    data object Wishlist : Routes()
}