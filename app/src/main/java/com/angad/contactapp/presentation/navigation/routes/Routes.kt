package com.angad.contactapp.presentation.navigation.routes

import kotlinx.serialization.Serializable

sealed class Routes {
    @Serializable
    object HomeScreen: Routes()

    @Serializable
    object AddEditScreen: Routes()
}