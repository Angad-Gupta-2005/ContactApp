package com.angad.contactapp.presentation.navigation.appnavigation

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.angad.contactapp.presentation.ContactViewModel
import com.angad.contactapp.presentation.navigation.routes.Routes
import com.angad.contactapp.presentation.screens.AddEditScreenUI
import com.angad.contactapp.presentation.screens.HomeScreenUI

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    viewModel: ContactViewModel
){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.HomeScreen ){

        composable<Routes.HomeScreen> {
            HomeScreenUI(viewModel = viewModel, navController = navController)
        }

        composable<Routes.AddEditScreen> {
            AddEditScreenUI(viewModel = viewModel, navController = navController)
        }
    }
}