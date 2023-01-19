package com.example.poolit.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.poolit.R
import com.example.poolit.ui.theme.PoolItTheme

@Composable
fun RidesListScreen(onCardClick: () -> Unit) {
    PoolItTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            LazyColumn{
                items(
                    count = 10
                ) {
                    RideCard(onCardClick)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RideCard(onCardClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onCardClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,

                ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_google_logo),
                    modifier = Modifier.size(56.dp),
                    contentDescription = "user profile image"
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column(
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(text = "Name")
                    Text(text = "Start ---- Destination")
                    Text(text = "12:30 PM, Tomorrow")
                }
            }

            Box{
                Text(text = "Rs. 100", textAlign = TextAlign.End)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RidesListScreenPreview() {
    RideCard(){}
}