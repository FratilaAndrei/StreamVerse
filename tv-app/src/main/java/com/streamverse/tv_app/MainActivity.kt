package com.streamverse.tv_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.Surface
import com.streamverse.tv_app.feature.auth.AuthRoute
import com.streamverse.tv_app.feature.auth.AuthScreen
import com.streamverse.tv_app.feature.home.HomeRoute
import com.streamverse.tv_app.feature.home.HomeScreen
import com.streamverse.tv_app.ui.theme.StreamVerseTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StreamVerseTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    shape = RectangleShape
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = AuthRoute) {
                        composable<AuthRoute> { AuthScreen(modifier = Modifier, navController) }
                        composable<HomeRoute> { HomeScreen() }
                    }
                }
            }
        }
    }
}






