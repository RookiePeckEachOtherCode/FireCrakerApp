package com.rookie.firecraker.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@RootNavGraph(start = true)
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Home")
                }
            )
        }
    ) { inPadding ->
        Box(modifier = Modifier.padding(inPadding)) {
        }
    }
}