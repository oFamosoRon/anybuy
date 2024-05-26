package com.devira.anybuy.ui.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devira.anybuy.ui.MainViewModel
import com.devira.anybuy.NavigationRoutes
import com.devira.anybuy.R

@JvmOverloads
@Composable
fun MainContainer(
    viewModel: MainViewModel = hiltViewModel()
) {

    val navController = rememberNavController()
    val pages = listOf(Page.Favourites, Page.Home, Page.Profile)
    val selectedPage = remember { mutableStateOf<Page>(Page.Home) }

    val state = viewModel.state.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            startDestination = NavigationRoutes.HomeScreen.route
        ) {
            composable(route = NavigationRoutes.HomeScreen.route) {
                HomeScreen()
            }
            composable(route = NavigationRoutes.FavouritesScreen.route) {
                FavouritesScreen(onBackClick = { navController.popBackStack() })
            }
            composable(route = NavigationRoutes.ProfileScreen.route) {
                ProfileScreen(onBackClick = { navController.popBackStack() })
            }
        }
        BottomAppBar(
            containerColor = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ) {
            pages.forEach { page ->
                when (page) {
                    is Page.Home -> {
                        NavigationBarItem(
                            selected = selectedPage.value is Page.Home,
                            onClick = {
                                selectedPage.value = Page.Home
                                navController.navigate(NavigationRoutes.HomeScreen.route)
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.home),
                                    contentDescription = "home screen"
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                indicatorColor = MaterialTheme.colorScheme.primary
                            )
                        )
                    }

                    is Page.Favourites -> {
                        NavigationBarItem(
                            selected = selectedPage.value is Page.Favourites,
                            onClick = {
                                selectedPage.value = Page.Favourites
                                navController.navigate(NavigationRoutes.FavouritesScreen.route)
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.heart),
                                    contentDescription = "favourites screen"
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                indicatorColor = MaterialTheme.colorScheme.primary
                            )
                        )
                    }

                    is Page.Profile -> {
                        NavigationBarItem(
                            selected = selectedPage.value is Page.Profile,
                            onClick = {
                                selectedPage.value = Page.Profile
                                navController.navigate(NavigationRoutes.ProfileScreen.route)
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.profile),
                                    contentDescription = "profile screen"
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                indicatorColor = MaterialTheme.colorScheme.primary
                            )
                        )
                    }
                }
            }
        }
    }
}

private sealed class Page() {
    object Home : Page()
    object Profile : Page()
    object Favourites : Page()
}