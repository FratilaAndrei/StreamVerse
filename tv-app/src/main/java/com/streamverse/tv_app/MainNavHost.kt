package com.streamverse.tv_app

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.streamverse.tv_app.feature.auth.login.AuthRoute
import com.streamverse.tv_app.feature.auth.login.AuthScreen
import com.streamverse.tv_app.feature.home.HomeRoute
import com.streamverse.tv_app.feature.home.HomeScreen


@Composable
fun MainNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AuthRoute.route) {
        composable(AuthRoute.route) {
            AuthScreen(
                navigateToHome = { navController.navigateToHome() },
            )
        }
        composable(HomeRoute.route) { HomeScreen() }
    }
}

private fun NavController.navigateToHome() {
    navigate(HomeRoute.route) {
        popUpTo(AuthRoute.route) { inclusive = true }
    }
}
