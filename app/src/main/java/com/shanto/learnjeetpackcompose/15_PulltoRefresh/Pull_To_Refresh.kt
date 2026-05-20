package com.shanto.learnjeetpackcompose.`15_PulltoRefresh`

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PullToRefreshExamples() {

    var isRefreshing by remember {
        mutableStateOf(false)
    }
    var items by remember {
        mutableStateOf(
            List(15) { "Item ${it + 1}" }
        )
    }
    val scope = rememberCoroutineScope()

    PullToRefreshBox(
        isRefreshing = isRefreshing, onRefresh = {
            scope.launch {
                isRefreshing = true
                delay(2000)

                items = listOf("New Item ${System.currentTimeMillis()}") + items
                isRefreshing = false
            }
        }, modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(Modifier.fillMaxSize()) {
            items(items) { item ->
                ListItem(
                    headlineContent = { Text(text = item) },
                    modifier = Modifier.fillMaxWidth()
                )
                HorizontalDivider()
            }
        }
    }
}

// Show Ui Design
@Preview(showSystemUi = true)
@Composable
fun PullToRefreshPreview() {
    PullToRefreshExamples()
}