package com.shanto.learnjeetpackcompose.`16_SearchBar`

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults.InputField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun UpdatedSearchSystem() {

    val textFieldState = rememberTextFieldState()

    val allItems = remember {

        listOf(
            "Android",
            "Jetpack Compose",
            "Kotlin",
            "Java",
            "Firebase",
            "SQLite",
            "Room Database",
            "Retrofit",
            "API",
            "Material Design",
            "RecyclerView",
            "Navigation Drawer",
            "Search Bar",
            "Bottom Navigation",
            "Animation"
        )
    }

    var searchResults by remember {
        mutableStateOf(allItems)
    }

    val recentSearches = remember {
        mutableStateListOf<String>()
    }

    val onSearch: (String) -> Unit = { query ->

        searchResults = if (query.isEmpty()) {

            allItems

        } else {

            allItems.filter {
                it.contains(query, ignoreCase = true)
            }
        }

        if (query.isNotEmpty() && !recentSearches.contains(query)) {
            recentSearches.add(0, query)
        }
    }

    ModernSearchBar(
        textFieldState = textFieldState,
        searchResults = searchResults,
        recentSearches = recentSearches,
        onSearch = onSearch
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModernSearchBar(
    textFieldState: TextFieldState,
    searchResults: List<String>,
    recentSearches: List<String>,
    onSearch: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    var expanded by rememberSaveable {
        mutableStateOf(false)
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        SearchBar(

            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter),

            expanded = expanded,

            onExpandedChange = {
                expanded = it
            },

            tonalElevation = 6.dp,

            shadowElevation = 6.dp,

            inputField = {

                InputField(

                    query = textFieldState.text.toString(),

                    onQueryChange = { newText ->

                        textFieldState.edit {
                            replace(0, length, newText)
                        }

                        onSearch(newText)
                    },

                    onSearch = {

                        onSearch(textFieldState.text.toString())

                        expanded = false
                    },

                    expanded = expanded,

                    onExpandedChange = {
                        expanded = it
                    },

                    placeholder = {
                        Text("Search anything...")
                    },

                    leadingIcon = {

                        Icon(
                            imageVector = Icons.Default.Search, contentDescription = "Search Icon"
                        )
                    },

                    trailingIcon = {

                        if (textFieldState.text.isNotEmpty()) {

                            IconButton(

                                onClick = {

                                    textFieldState.edit {
                                        replace(0, length, "")
                                    }

                                    onSearch("")
                                }) {

                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "Clear Search"
                                )
                            }
                        }
                    })
            }

        ) {

            Column {

                if (recentSearches.isNotEmpty()) {

                    Text(
                        text = "Recent Searches",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(16.dp)
                    )

                    recentSearches.take(3).forEach { item ->

                        ListItem(

                            headlineContent = {
                                Text(item)
                            },

                            supportingContent = {
                                Text("Recently searched")
                            },

                            modifier = Modifier.clickable {

                                textFieldState.edit {
                                    replace(0, length, item)
                                }

                                onSearch(item)

                                expanded = false
                            })
                    }

                    // Divider --> HorizontalDivider
                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(horizontal = 8.dp)
                ) {

                    items(searchResults) { result ->

                        Card(

                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {

                                    textFieldState.edit {
                                        replace(0, length, result)
                                    }

                                    expanded = false
                                },

                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 4.dp
                            )

                        ) {

                            ListItem(

                                headlineContent = {
                                    Text(
                                        text = result, fontWeight = FontWeight.SemiBold
                                    )
                                },

                                supportingContent = {
                                    Text("Tap to select")
                                },

                                leadingContent = {

                                    Icon(
                                        imageVector = Icons.Default.Search,
                                        contentDescription = null
                                    )
                                })
                        }
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun UpdatedSearchSystemPreview() {
    UpdatedSearchSystem()
}