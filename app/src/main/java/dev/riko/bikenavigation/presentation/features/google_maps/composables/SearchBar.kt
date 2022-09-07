package dev.riko.bikenavigation.presentation.features.google_maps.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import dev.riko.bikenavigation.presentation.ui.theme.Shapes

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    var search by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(22.dp),
        backgroundColor = Color.White,
        shape = Shapes.large,
        elevation = 8.dp
    ) {
        TextField(
            value = search,
            label = {
                Text(
                    text = "Destination place",
                    color = Color.Black
                )
            },
            placeholder = {
                Text(
                    text = "Search here",
                    color = Color.Black
                )
            },
            onValueChange = { search = it },
            singleLine = true,
            leadingIcon = {
                IconButton(onClick = {
                    if (search.isNotBlank()) {

                    }
                    focusManager.clearFocus()
                }) {
                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = "search",
                        tint = MaterialTheme.colors.primary
                    )
                }
            },
            trailingIcon = {
                IconButton(onClick = {
                    focusManager.clearFocus()
                    search = ""
                }) {
                    Icon(
                        imageVector = Icons.Outlined.Close,
                        contentDescription = "close",
                        tint = MaterialTheme.colors.primary
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(onSearch = {
                if (search.isNotEmpty()) {

                }
                focusManager.clearFocus()
            }),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Unspecified,
                focusedIndicatorColor = Color.Unspecified,
                unfocusedIndicatorColor = Color.Unspecified,
                cursorColor = MaterialTheme.colors.secondary,
                textColor = Color.Black
            ),
        )
    }
}