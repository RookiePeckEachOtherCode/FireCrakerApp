package com.rookie.firecraker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.rookie.firecraker.ui.component.AppBottomBar
import com.rookie.firecraker.ui.screen.NavGraphs
import com.rookie.firecraker.ui.theme.FireCrakerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FireCrakerTheme {
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = { AppBottomBar(navController = navController) }
                ) { inPadding ->
                    val noUse = inPadding
                    DestinationsNavHost(
                        navGraph = NavGraphs.root,
                        navController = navController,
                        modifier = Modifier.padding(bottom = 80.dp)
                    )
                }
            }
        }
    }
}