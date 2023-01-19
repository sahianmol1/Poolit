package com.example.poolit.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.poolit.ui.theme.PoolItTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen() {
    var message by remember { mutableStateOf("") }
    PoolItTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
                ) {
                RideCard {}
                Row (verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.padding(vertical = 8.dp)
                    ){
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(0.85f),
                        value = message,
                        onValueChange = { newValue ->
                            message = newValue
                        },
                        label = { Text(text = "Message") }
                    )

                    FilledIconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Send, contentDescription = "Send Message")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatScreenPreview() {
    ChatScreen()
}