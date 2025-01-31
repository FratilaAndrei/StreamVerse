package com.streamverse.tv_app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.streamverse.tv_app.feature.auth.AuthRoute
import com.streamverse.tv_app.feature.auth.AuthScreen
import com.streamverse.tv_app.feature.home.HomeRoute
import com.streamverse.tv_app.feature.home.HomeScreen

@Composable
fun MainNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AuthRoute) {
        composable<AuthRoute> { AuthScreen(modifier = Modifier, navController) }
        composable<HomeRoute> { HomeScreen() }
    }
}