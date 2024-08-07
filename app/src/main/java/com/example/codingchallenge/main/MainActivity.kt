package com.example.codingchallenge.main

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.codingchallenge.common.theme.CodingChallengeTheme
import com.example.codingchallenge.navigation.AppNavGraph
import com.example.codingchallenge.navigation.NavigationProvider
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            navigationBarStyle = SystemBarStyle.light(
                Color.TRANSPARENT,
                Color.TRANSPARENT
            )
        )

        setContent {
            MainActivityContent(
                navigationProvider = viewModel.navigationProvider
            )
        }
    }
}

@Composable
fun MainActivityContent(modifier: Modifier = Modifier, navigationProvider: NavigationProvider) {
    val navController = rememberNavController()

    CodingChallengeTheme {
        Scaffold(
            modifier = modifier.animateContentSize(),
            contentColor = MaterialTheme.colorScheme.background
        ) { innerPadding ->
            AppNavGraph(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                navController = navController,
                navigationProvider = navigationProvider
            )
        }
    }
}
