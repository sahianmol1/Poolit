package com.example.poolit.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.poolit.R
import com.example.poolit.ui.theme.PoolItTheme

@Composable
fun RideDetailScreen(onChatButtonClick: () -> Unit) {
    PoolItTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Image(
                        modifier = Modifier.size(150.dp),
                        painter = painterResource(id = R.drawable.ic_google_logo),
                        contentDescription = "Profile image",
                    )

                    Text(
                        text = "Name",
                        style = MaterialTheme.typography.headlineLarge
                    )
                    Text(
                        text = "Start ------ Destination",
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Text(
                        text = "12:30 PM, Tomorrow",
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Text(
                        text = "Seats Available: 4",
                        style = MaterialTheme.typography.headlineSmall
                    )

                    Text(text = "Rs.100/seat")

                }


                Column(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Divider()


                    FilledTonalButton(
                        onClick = { /*TODO*/ },
                        shape = RectangleShape,
                        modifier = Modifier
                            .fillMaxWidth()
                            .defaultMinSize(minHeight = 60.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Filled.Call, contentDescription = "call")
                            Spacer(modifier = Modifier.size(8.dp))
                            Text(text = "Call", style = MaterialTheme.typography.labelLarge)
                        }
                    }

                    Divider()

                    FilledTonalButton(
                        onClick = { onChatButtonClick() },
                        shape = RectangleShape,
                        modifier = Modifier
                            .fillMaxWidth()
                            .defaultMinSize(minHeight = 60.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Filled.Email, contentDescription = "chat")
                            Spacer(modifier = Modifier.size(8.dp))
                            Text(text = "Chat", style = MaterialTheme.typography.labelLarge)
                        }
                    }

                    Divider()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RideDetailsScreenPreview() {
    RideDetailScreen {
    }
}