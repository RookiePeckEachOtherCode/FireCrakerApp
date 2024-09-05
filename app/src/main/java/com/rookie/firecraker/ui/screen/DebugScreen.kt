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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Destination
fun DebugScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Debug")
                }
            )
        }
    ) { inPadding ->
        Box(modifier = Modifier.padding(inPadding)) {
        }
    }
}
