package com.example.poolit.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.poolit.ui.theme.PoolItTheme

@Composable
fun StartDestinationScreen(onSearchClick: () -> Unit) {

    var startLocation by remember { mutableStateOf("") }
    var endLocation by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }

    PoolItTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = startLocation,
                    onValueChange = { newValue ->
                        startLocation = newValue
                    },
                    label = { Text(text = "Start") }
                )

                OutlinedTextField(
                    value = endLocation,
                    onValueChange = { newValue ->
                        endLocation = newValue
                    },
                    label = { Text(text = "Destination") }
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = date,
                    onValueChange = { newValue ->
                        date = newValue
                    },
                    label = { Text(text = "Date") }
                )

                Spacer(modifier = Modifier.height(16.dp))

                ElevatedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    onClick = { onSearchClick() }) {
                    Text(text = "Search")
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun StartDestinationScreenPreview() {
    StartDestinationScreen() {}
}