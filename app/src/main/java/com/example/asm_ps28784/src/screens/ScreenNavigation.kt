package com.example.asm_ps28784.src.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState


import androidx.navigation.compose.rememberNavController
import com.example.asm_ps28784.MainActivity
import com.example.asm_ps28784.R
import com.example.asm_ps28784.src.screens.Screen

@Composable
fun CustomBottomNavigation(navController: NavController, items: List<Screen>) {
    BottomNavigation(
        modifier = Modifier
            .height(75.dp)
            .background(Color.White)
            .shadow(8.dp, shape = RoundedCornerShape(0.dp))
            .padding(0.dp),
        elevation = 8.dp,
        backgroundColor = Color(0xFFFFFFFF),
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        items.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(
                            if (currentDestination?.route == screen.route) screen.iconSelected else screen.iconUnselected
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                            .padding(4.dp)

                    )
                },
                selected = currentDestination?.route == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                alwaysShowLabel = false,
                unselectedContentColor = Color.Gray,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}

@Composable
fun ScreenNavigation() {
    val navController = rememberNavController()
    val items = listOf(Screen.HOME, Screen.Favorite, Screen.Notification, Screen.Profile)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute !in listOf(
                    Screen.BOARDING.route,
                    Screen.LOGIN.route,
                    Screen.SIGNUP.route
                )
            ) {
                CustomBottomNavigation(navController, items)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.BOARDING.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.BOARDING.route) {
                Boarding(navController)
            }
            composable(Screen.LOGIN.route) {
                Login(navController)
            }
            composable(Screen.SIGNUP.route) {
                Signup(navController)
            }
            composable(Screen.HOME.route) {
                Home(navController)
            }
            composable(Screen.Favorite.route) {
                Favorite(navController)
            }
            composable(Screen.Notification.route) {
                Notification(navController)
            }
            composable(Screen.Profile.route) {
                Profile(navController)
            }
            composable(Screen.PRODUCT.route) {
                Product(navController)
            }
            composable(Screen.CONGRATS.route) {
                Congrats(navController)
            }
            composable(Screen.CART.route) {
                Cart(navController)
            }
            composable(Screen.CHECKOUT.route) {
                Checkout(navController)
            }
        }
    }
}

@Preview
@Composable
fun PreviewScreenNavigation() {
    CustomBottomNavigation(
        rememberNavController(),
        listOf(Screen.HOME, Screen.Favorite, Screen.Notification, Screen.Profile)
    )
}