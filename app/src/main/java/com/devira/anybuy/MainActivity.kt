package com.devira.anybuy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
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
                    startDestination = NavigationRoutes.WelcomeScreen.route
                ) {
                    composable(NavigationRoutes.WelcomeScreen.route) {
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AnybuyTheme {

    }
}