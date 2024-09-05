package com.rookie.firecraker.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BugReport
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.BugReport
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.popBackStack
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec
import com.ramcosta.composedestinations.utils.isRouteOnBackStackAsState
import com.rookie.firecraker.R
import com.rookie.firecraker.ui.screen.NavGraphs
import com.rookie.firecraker.ui.screen.destinations.AccountScreenDestination
import com.rookie.firecraker.ui.screen.destinations.DebugScreenDestination
import com.rookie.firecraker.ui.screen.destinations.HomeScreenDestination
import com.rookie.firecraker.ui.screen.destinations.NewsSeenDestination

@Composable
fun AppBottomBar(
    navController: NavController
) {
    Column {
        NavigationBar(
            tonalElevation = 8.dp
        ) {
            AppBottomBarDestination.entries.forEach { destination ->
                val isCurrentDestOnBackStack by navController.isRouteOnBackStackAsState(destination.direction)
                NavigationBarItem(
                    selected = isCurrentDestOnBackStack,
                    onClick = {
                        if (isCurrentDestOnBackStack) {
                            navController.popBackStack(destination.direction, false)
                        }

                        navController.navigate(destination.direction.route) {
                            popUpTo(NavGraphs.root.route) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }, icon = {
                        if (destination.iconSelected != null && destination.iconNotSelected != null) {
                            if (isCurrentDestOnBackStack) {
                                Icon(
                                    destination.iconSelected,
                                    stringResource(destination.label)
                                )
                            } else {
                                Icon(
                                    destination.iconNotSelected,
                                    stringResource(destination.label)
                                )
                            }
                        }
                        if (destination.iconSelectedId != null && destination.iconNotSelectedId != null) {
                            if (isCurrentDestOnBackStack) {
                                Icon(
                                    painterResource(id = destination.iconSelectedId),
                                    stringResource(destination.label)
                                )
                            } else {
                                Icon(
                                    painterResource(id = destination.iconNotSelectedId),
                                    stringResource(destination.label)
                                )
                            }
                        }
                    },
                    label = {
                        Text(
                            stringResource(destination.label),
                            overflow = TextOverflow.Visible,
                            maxLines = 1,
                            softWrap = false
                        )
                    }, alwaysShowLabel = false
                )
            }
        }
    }
}

private enum class AppBottomBarDestination(
    val direction: DirectionDestinationSpec,
    @StringRes val label: Int,
    val iconSelected: ImageVector? = null,
    val iconNotSelected: ImageVector? = null,
    val iconSelectedId: Int? = null,
    val iconNotSelectedId: Int? = null,
) {
    HomeScreen(
        HomeScreenDestination,
        R.string.home,
        Icons.Filled.Home,
        Icons.Outlined.Home
    ),

    NewsScreen(
        NewsSeenDestination,
        R.string.news,
        null,
        null,
        R.drawable.mode_fan_filled,
        R.drawable.mode_fan_outline
    ),
    AccountScreen(
        AccountScreenDestination,
        R.string.account,
        Icons.Filled.Person,
        Icons.Outlined.Person
    ),
    DebugScreen(
        DebugScreenDestination,
        R.string.debug,
        Icons.Filled.BugReport,
        Icons.Outlined.BugReport
    )
}