package com.example.poolit.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.poolit.ui.theme.PoolItTheme
import androidx.compose.runtime.remember as remember1

@Composable
fun OtpVerificationScreen(onButtonClick: () -> Unit) {
    PoolItTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Box(modifier = Modifier.fillMaxSize()) {

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp),
                    text = "Code is sent to 9041274648",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyLarge
                )

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.padding(top = 56.dp),
                    ) {
                        Spacer(modifier = Modifier.width(8.dp))
                        CommonOtpTextField(otp = remember1 { mutableStateOf("") })
                        CommonOtpTextField(otp = remember1 { mutableStateOf("") })
                        CommonOtpTextField(otp = remember1 { mutableStateOf("") })
                        CommonOtpTextField(otp = remember1 { mutableStateOf("") }, true)
                    }

                    Text(
                        modifier = Modifier.padding(vertical = 56.dp),
                        text = "Didn't receive code? Request Again",
                        style = MaterialTheme.typography.bodyLarge
                    )

                    ElevatedButton(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        onClick = { onButtonClick() }) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Verify",
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }


        }
    }
}

@Composable
fun CommonOtpTextField(otp: MutableState<String>, isLastField: Boolean = false) {
    val focusManager = LocalFocusManager.current
    val max = 1
    Row {
        OutlinedTextField(
            value = otp.value,
            singleLine = true,
            onValueChange = {
                if (it.length <= max) {
                    otp.value = it
                }
                if (it.length == max && !isLastField) {
                    focusManager.moveFocus(FocusDirection.Next)
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .width(60.dp)
                .height(60.dp),
            maxLines = 1,
            textStyle = LocalTextStyle.current.copy(
                textAlign = TextAlign.Center
            )
        )

        Spacer(modifier = Modifier.width(8.dp))
    }

}

@Preview(showBackground = true)
@Composable
fun OtpVerificationScreenPreView() {
    OtpVerificationScreen({})
}
