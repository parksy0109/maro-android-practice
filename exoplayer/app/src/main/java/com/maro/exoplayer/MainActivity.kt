package com.maro.exoplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.maro.exoplayer.ui.player.VideoPlayer
import com.maro.exoplayer.ui.screen.MainScreen
import com.maro.exoplayer.ui.screen.pages.VideoScreen
import com.maro.exoplayer.ui.theme.ExoplayerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val rememberNavController = rememberNavController()
            ExoplayerTheme {
                NavHost(navController = rememberNavController, startDestination = "main") {
                    composable("main") {
                        MainScreen(rememberNavController)
                    }
                    composable(
                        "videos/{id}",
                        arguments = listOf(navArgument("id") { type = NavType.IntType })
                    ) {
                        VideoScreen(rememberNavController, it.arguments?.getInt("id"))
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExoplayerTheme {
        Greeting("Android")
    }
}