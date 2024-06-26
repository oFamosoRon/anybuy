package com.devira.anybuy.ui

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
import com.devira.anybuy.NavigationRoutes
import com.devira.anybuy.ui.composables.ForgotPasswordScreen
import com.devira.anybuy.ui.composables.MainContainer
import com.devira.anybuy.ui.composables.LoginScreen
import com.devira.anybuy.ui.composables.SignUpScreen
import com.devira.anybuy.ui.composables.WelcomeScreen
import com.devira.anybuy.ui.theme.AnybuyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnybuyTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = NavigationRoutes.WelcomeScreen.route,
                    modifier = Modifier.fillMaxSize(),
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
                    composable(route = NavigationRoutes.WelcomeScreen.route) {
                        WelcomeScreen(navigate = {
                            navController.navigate(route = NavigationRoutes.LoginScreen.route)
                        })
                    }
                    composable(NavigationRoutes.LoginScreen.route) {
                        LoginScreen(
                            onForgotPasswordClick = { navController.navigate(route = NavigationRoutes.ForgotPasswordScreen.route) },
                            onLoginClick = { navController.navigate(route = NavigationRoutes.MainContainer.route) },
                            onNavigateBack = { navController.popBackStack() },
                            onSignUpClick = { navController.navigate(route = NavigationRoutes.SignUpScreen.route) }
                        )
                    }
                    composable(NavigationRoutes.ForgotPasswordScreen.route) {
                        ForgotPasswordScreen(onNavigateBackClick = { navController.popBackStack() })
                    }
                    composable(NavigationRoutes.MainContainer.route) {
                        MainContainer()
                    }
                    composable(NavigationRoutes.SignUpScreen.route) {
                        SignUpScreen(
                            onNavigateBackClick = { navController.popBackStack() },
                            onRegisterClick = { navController.navigate(NavigationRoutes.MainContainer.route) }
                        )
                    }
                }
            }
        }
    }
}