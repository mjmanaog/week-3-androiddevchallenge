/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.helpers.ROUTE_CART_SCREEN
import com.example.androiddevchallenge.helpers.ROUTE_FAVORITES_SCREEN
import com.example.androiddevchallenge.helpers.ROUTE_HOME_SCREEN
import com.example.androiddevchallenge.helpers.ROUTE_PROFILE_SCREEN

sealed class BottomNavigationScreens(val route: String, val title: String, val icon: ImageVector) {
    object Home : BottomNavigationScreens(ROUTE_HOME_SCREEN, "Home", Icons.Default.Home)
    object Favorites :
        BottomNavigationScreens(ROUTE_FAVORITES_SCREEN, "Favorites", Icons.Default.FavoriteBorder)

    object Profile :
        BottomNavigationScreens(ROUTE_PROFILE_SCREEN, "Profile", Icons.Default.AccountCircle)

    object Cart : BottomNavigationScreens(ROUTE_CART_SCREEN, "Cart", Icons.Default.ShoppingCart)
}

@Composable
fun HomeNavigation() {
    val navController = rememberNavController()
    val bottomNavigationItems = listOf(
        BottomNavigationScreens.Home,
        BottomNavigationScreens.Favorites,
        BottomNavigationScreens.Profile,
        BottomNavigationScreens.Cart,
    )
    Scaffold(
        bottomBar = {
            HomeNavigation(navController, bottomNavigationItems)
        },
    ) {
        HomeScreenNavigationConfigurations(navController)
    }
}

@Composable
private fun HomeScreenNavigationConfigurations(
    navController: NavHostController
) {
    NavHost(navController, startDestination = BottomNavigationScreens.Home.route) {
        composable(BottomNavigationScreens.Home.route) {
            HomeScreen()
        }
        composable(BottomNavigationScreens.Favorites.route) {
            FavoritesScreen()
        }
        composable(BottomNavigationScreens.Profile.route) {
            ProfileScreen()
        }
        composable(BottomNavigationScreens.Cart.route) {
            CartScreen()
        }
    }
}

@Composable
private fun HomeNavigation(
    navController: NavHostController,
    items: List<BottomNavigationScreens>
) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary
    ) {
        val currentRoute = currentRoute(navController)
        items.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Image(
                        imageVector = screen.icon,
                        contentDescription = "Nav Icon",
                        colorFilter = ColorFilter.tint(MaterialTheme.colors.onPrimary)
                    )
                },
                label = { Text(screen.title) },
                selected = currentRoute == screen.route,
                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route)
                    }
                }
            )
        }
    }
}

@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.arguments?.getString(KEY_ROUTE)
}
