package com.maro.exoplayer.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maro.exoplayer.ui.footer.BottomNavigationBar
import com.maro.exoplayer.ui.header.MainTopBar
import com.maro.exoplayer.ui.screen.pages.home.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navHostController: NavHostController
) {

    val rememberNavController = rememberNavController()

    Scaffold(
        topBar = {
            MainTopBar()
        },
        bottomBar = {
            BottomNavigationBar()
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            NavHost(navController = rememberNavController, startDestination = "home") {
                composable("home") {
                    HomeScreen(navHostController)
                }
                composable("popular") {

                }
                composable("library") {

                }
            }
        }
    }
}