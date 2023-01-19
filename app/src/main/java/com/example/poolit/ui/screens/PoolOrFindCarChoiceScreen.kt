package com.example.poolit.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.poolit.MainActivity
import com.example.poolit.ui.theme.PoolItTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PoolOrFindCarChoiceScreen(onFindRideClick: () -> Unit) {
    PoolItTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Box(
                Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    text = "Hi ${MainActivity.userGoogleAccount?.name ?: "Guest"}",
                )

                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .defaultMinSize(minHeight = 200.dp)
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(vertical = 16.dp, horizontal = 32.dp),
                            text = "Pool your car",
                            style = MaterialTheme.typography.displayLarge
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .defaultMinSize(minHeight = 200.dp)
                            .clickable { onFindRideClick() }
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(vertical = 16.dp, horizontal = 32.dp),
                            text = "Find a ride",
                            style = MaterialTheme.typography.displayLarge,
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PoolOrFindCarChoiceScreenPreview() {
    PoolOrFindCarChoiceScreen() {}
}