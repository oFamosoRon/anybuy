package com.devira.anybuy.ui.composables

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devira.anybuy.NavigationRoutes
import com.devira.anybuy.R
import com.devira.anybuy.ui.MainViewModel
import com.devira.anybuy.ui.composables.home.HomeScreen
import com.devira.anybuy.ui.composables.home.ProductDetailsScreen

@JvmOverloads
@Composable
fun MainContainer(
    viewModel: MainViewModel = hiltViewModel()
) {

    val navController = rememberNavController()
    val pages = listOf(Page.Favourites, Page.Home, Page.Profile)
    var selectedPage by remember { mutableStateOf<Page>(Page.Home) }
    var isBottomNavBarVisible by remember {
        mutableStateOf(true)
    }

    val state = viewModel.state.collectAsState()

    BackHandler(enabled = true) {
        // Do nothing on back press
    }

    Box(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            startDestination = NavigationRoutes.HomeScreen.route,
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
            composable(route = NavigationRoutes.HomeScreen.route) {
                HomeScreen(
                    products = state.value.products,
                    isLoading = state.value.isLoadingProducts,
                    onClick = { product ->
                        viewModel.updateSelectedProduct(product)
                        isBottomNavBarVisible = false
                        navController.navigate(NavigationRoutes.ProductDetailsScreen.route)
                    })
            }
            composable(route = NavigationRoutes.FavouritesScreen.route) {
                FavouritesScreen(onBackClick = { navController.popBackStack() })
            }
            composable(route = NavigationRoutes.ProfileScreen.route) {
                ProfileScreen(onBackClick = { navController.popBackStack() })
            }
            composable(route = NavigationRoutes.ProductDetailsScreen.route) {
                ProductDetailsScreen(
                    viewModel = viewModel,
                    onBackClick = {
                        viewModel.clearSelectedProduct()
                        isBottomNavBarVisible = true
                        navController.popBackStack()
                    })
            }
        }

        if (isBottomNavBarVisible) {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
            ) {
                pages.forEach { page ->
                    when (page) {
                        is Page.Home -> {
                            NavigationBarItem(
                                selected = selectedPage is Page.Home,
                                onClick = {
                                    selectedPage = Page.Home
                                    navController.navigate(NavigationRoutes.HomeScreen.route)
                                },
                                icon = {
                                    if (selectedPage is Page.Home) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.home),
                                            contentDescription = "home screen",
                                            tint = MaterialTheme.colorScheme.tertiary
                                        )
                                    } else {
                                        Icon(
                                            painter = painterResource(id = R.drawable.home),
                                            contentDescription = "home screen"
                                        )
                                    }
                                },
                                colors = NavigationBarItemDefaults.colors(
                                    indicatorColor = MaterialTheme.colorScheme.primary
                                )
                            )
                        }

                        is Page.Favourites -> {
                            NavigationBarItem(
                                selected = selectedPage is Page.Favourites,
                                onClick = {
                                    selectedPage = Page.Favourites
                                    navController.navigate(NavigationRoutes.FavouritesScreen.route)
                                },
                                icon = {
                                    if (selectedPage is Page.Favourites) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.heart),
                                            contentDescription = "favourites screen",
                                            tint = MaterialTheme.colorScheme.tertiary
                                        )
                                    } else {
                                        Icon(
                                            painter = painterResource(id = R.drawable.heart),
                                            contentDescription = "favourites screen"
                                        )
                                    }

                                },
                                colors = NavigationBarItemDefaults.colors(
                                    indicatorColor = MaterialTheme.colorScheme.primary
                                )
                            )
                        }

                        is Page.Profile -> {
                            NavigationBarItem(
                                selected = selectedPage is Page.Profile,
                                onClick = {
                                    selectedPage = Page.Profile
                                    navController.navigate(NavigationRoutes.ProfileScreen.route)
                                },
                                icon = {
                                    if (selectedPage is Page.Profile) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.profile),
                                            contentDescription = "profile screen",
                                            tint = MaterialTheme.colorScheme.tertiary
                                        )
                                    } else {
                                        Icon(
                                            painter = painterResource(id = R.drawable.profile),
                                            contentDescription = "profile screen"
                                        )
                                    }
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
}

private sealed class Page() {
    object Home : Page()
    object Profile : Page()
    object Favourites : Page()
}