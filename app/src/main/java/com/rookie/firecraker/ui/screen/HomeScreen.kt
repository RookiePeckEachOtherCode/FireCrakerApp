package com.rookie.firecraker.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.rookie.firecraker.ui.component.HomeSearchBar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@RootNavGraph(start = true)
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator,
    vm: HomeViewModel = hiltViewModel()
) {
    val videoList by vm.videoList.collectAsState()
    val pagerState = rememberPagerState(initialPage = 0) { 2 }
    val scope = rememberCoroutineScope()
    val titles = listOf("推荐", "热门")

    Scaffold(
        topBar = {
            HomeSearchBar(
                avatarUrl = vm.avatarUrl,
                searchText = vm.searchText,
                onSearchTextChange = { vm.searchText = it },
                onClearClick = {
                    vm.searchText = ""
                },
                onConfirm = {
                }
            )
        }
    ) { inPadding ->
        Column(
            modifier = Modifier.padding(inPadding),
        ) {
            PrimaryTabRow(
                selectedTabIndex = pagerState.currentPage
            ) {
                titles.forEachIndexed { index, title ->
                    Tab(
                        text = { Text(title) },
                        selected = pagerState.currentPage == index,
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        }
                    )
                }
            }

            HorizontalPager(
                state = pagerState,
            ) { page ->
                if (page == 0) {
                    BoxWithConstraints {
                        val scrollState = rememberLazyGridState()
                        val maxWith = maxWidth
                        val maxHeight = maxHeight
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            state = scrollState
                        ) {
                            itemsIndexed(videoList) { index, videoInfo ->
                                key(videoInfo.id) {
                                    Column {
                                        Surface(
                                            shape = MaterialTheme.shapes.medium,
                                            modifier = Modifier
                                                .height(maxHeight.div(4))
                                                .width(maxWith.div(2))
                                        ) {
                                            AsyncImage(
                                                model = ImageRequest.Builder(LocalContext.current)
                                                    .data(videoInfo.coverUrl)
                                                    .crossfade(true)
                                                    .build(),
                                                contentDescription = null,
                                                contentScale = ContentScale.Crop
                                            )
                                        }

                                        Text(
                                            text = videoInfo.title,
                                            fontSize = MaterialTheme.typography.titleSmall.fontSize,
                                            maxLines = 2,
                                            overflow = TextOverflow.Ellipsis
                                        )
                                        Text(
                                            text = videoInfo.authorName,
                                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                                            fontSize = MaterialTheme.typography.bodySmall.fontSize,
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis
                                        )
                                    }
                                }
                            }
                        }
                    }
                } else {
                    Text(text = "114514")
                }
            }
        }
    }
}

