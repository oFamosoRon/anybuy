package com.devira.anybuy.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devira.anybuy.NavigationRoutes
import com.devira.anybuy.R

@Composable
fun MainContainer() {
    val navController = rememberNavController()
    val selectedPage = remember { mutableStateOf<Page>(Page.Home) }
    Box(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            startDestination = NavigationRoutes.HomeScreen.route
        ) {
            composable(route = NavigationRoutes.HomeScreen.route) {
                HomeScreen()
            }
            composable(route = NavigationRoutes.FavouritesScreen.route) {
                FavouritesScreen()
            }
            composable(route = NavigationRoutes.BuyScreen.route) {
                BuyScreen()
            }
            composable(route = NavigationRoutes.ProfileScreen.route) {
                ProfileScreen()
            }
        }
        BottomAppBar(
            containerColor = MaterialTheme.colorScheme.primary,
            actions = {
                NavigationBarItem(
                    selected = selectedPage.value is Page.Favourites,
                    onClick = {
                        selectedPage.value = Page.Favourites
                        navController.navigate(NavigationRoutes.FavouritesScreen.route)
                    },
                    icon = {
                        Icon(
                            painterResource(id = R.drawable.heart),
                            contentDescription = "favourites"
                        )
                    })
                NavigationBarItem(
                    selected = selectedPage.value is Page.Home,
                    onClick = {
                        selectedPage.value = Page.Home
                        navController.navigate(NavigationRoutes.HomeScreen.route)
                    },
                    icon = {
                        Icon(
                            painterResource(id = R.drawable.home),
                            contentDescription = "home"
                        )
                    })
                NavigationBarItem(
                    selected = selectedPage.value is Page.Profile,
                    onClick = {
                        selectedPage.value = Page.Profile
                        navController.navigate(NavigationRoutes.ProfileScreen.route)
                    },
                    icon = {
                        Icon(
                            painterResource(id = R.drawable.profile),
                            contentDescription = "profile"
                        )
                    })
                NavigationBarItem(
                    selected = selectedPage.value is Page.Buy,
                    onClick = {
                        selectedPage.value = Page.Buy
                        navController.navigate(NavigationRoutes.BuyScreen.route)
                    },
                    icon = {
                        Icon(
                            painterResource(id = R.drawable.buy),
                            contentDescription = "buy"
                        )
                    })
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .background(MaterialTheme.colorScheme.primary)
        )
    }
}

private sealed class Page() {
    object Home : Page()
    object Profile : Page()
    object Buy : Page()
    object Favourites : Page()
}