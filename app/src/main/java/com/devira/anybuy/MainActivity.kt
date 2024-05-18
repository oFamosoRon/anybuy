package com.devira.anybuy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devira.anybuy.ui.composables.LoginScreen
import com.devira.anybuy.ui.composables.WelcomeScreen
import com.devira.anybuy.ui.theme.AnybuyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnybuyTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = NavigationRoutes.WelcomeScreen.route,
                    modifier = Modifier.fillMaxSize()
                ) {
                    composable(
                        route = NavigationRoutes.WelcomeScreen.route,
                        enterTransition = {
                            slideIntoContainer(
                                AnimatedContentTransitionScope.SlideDirection.Right,
                                tween(600)
                            )
                        },
                        exitTransition = {
                            slideOutOfContainer(
                                AnimatedContentTransitionScope.SlideDirection.Left,
                                tween(600)
                            )
                        }
                    ) {
                        WelcomeScreen(navigate = {
                            navController.navigate(route = NavigationRoutes.LoginScreen.route)
                        })
                    }
                    composable(NavigationRoutes.LoginScreen.route) {
                        LoginScreen()
                    }
                }
            }
        }
    }
}