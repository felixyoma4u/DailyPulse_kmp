package com.interswitchng.dailypulse2.android

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.interswitchng.dailypulse2.android.screens.AboutScreen
import com.interswitchng.dailypulse2.android.screens.ArticlesScreen
import com.interswitchng.dailypulse2.android.screens.Screens
import com.interswitchng.dailypulse2.android.screens.SourcesScreen

@Composable
fun AppScaffold() {
    val navController = rememberNavController()

    Scaffold {
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        )
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screens.Articles
    ) {
        composable<Screens.Articles> {
            ArticlesScreen(
                onSourceButtonClick = { navController.navigate(Screens.Sources) },
                onAboutButtonClick = { navController.navigate(Screens.AboutDevice) }
            )
        }

        composable<Screens.AboutDevice> {
            AboutScreen(onUpButonClick = { navController.popBackStack() })
        }

        composable<Screens.Sources>{
            SourcesScreen(onUpButtonClick = { navController.popBackStack() })
        }
    }
}