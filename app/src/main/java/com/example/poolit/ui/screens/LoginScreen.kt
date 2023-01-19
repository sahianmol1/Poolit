package com.example.poolit.ui.screens

import android.widget.Space
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat.startActivityForResult
import com.example.poolit.R
import com.example.poolit.ui.theme.PoolItTheme
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(onIconButtonClick: () -> Unit?, onLoginClick: () -> Unit) {
    PoolItTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            var phoneText by remember { mutableStateOf("") }
            Card(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Sign Up/Sign In", style = MaterialTheme.typography.headlineLarge)
                    Spacer(modifier = Modifier.height(24.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(0.8f),
                            singleLine = true,
                            value = phoneText,
                            label = {
                                Text(text = "Enter Phone")
                            },
                            onValueChange = { newValue ->
                                phoneText = newValue
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        )
                        Spacer(modifier = Modifier.width(8.dp))

                        FilledIconButton(onClick = { onIconButtonClick() }) {
                            Icon(Icons.Filled.ArrowForward, contentDescription = "")
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = " or ", style = MaterialTheme.typography.titleMedium)

                    Spacer(modifier = Modifier.height(16.dp))
                    GoogleLoginButton(onLoginClick)
                }
            }
        }
    }


}


@Composable
fun GoogleLoginButton(onLoginClick: () -> Unit) {
    var isLoginClicked by remember { mutableStateOf(false) }

    OutlinedButton(
        modifier = Modifier.animateContentSize(),
        onClick = {
            isLoginClicked = true
            onLoginClick()
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Icon(
                painter = painterResource(id = R.drawable.ic_google_logo),
                contentDescription = "Sign in with Google",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Continue with Google"
            )

            Spacer(modifier = Modifier.width(16.dp))
        }

        if (isLoginClicked) {
            CircularProgressIndicator(
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview
@Composable
fun GoogleLogoPreview() {
    GoogleLoginButton(){}
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen({}, {})
}