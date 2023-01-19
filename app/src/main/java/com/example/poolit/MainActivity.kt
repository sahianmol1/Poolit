package com.example.poolit

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.navigation.activity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.poolit.models.UserGoogleAccount
import com.example.poolit.ui.screens.*
import com.example.poolit.ui.theme.PoolItTheme
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException

const val REQUEST_CODE_SIGN_IN = 1000

class MainActivity : ComponentActivity() {

    private lateinit var gso: GoogleSignInOptions
    private lateinit var gsc: GoogleSignInClient
    private var currentUser: GoogleSignInAccount? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)

        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        gsc = GoogleSignIn.getClient(this, gso)

        setContent {
            PoolItTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavGraph(currentUser, gsc, this)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                task.getResult(ApiException::class.java)
                currentUser = GoogleSignIn.getLastSignedInAccount(this)

                currentUser?.let {
                    val username = currentUser!!.givenName
                    val email = currentUser!!.email
                    val imageUrl = currentUser!!.photoUrl.toString()
                    Toast.makeText(this, "name: $username, email: $email", Toast.LENGTH_LONG).show()
                    userGoogleAccount = UserGoogleAccount(name = username ?: "", email = email ?: "", imageUrl = imageUrl)

                    setContent {

                    }
                }


            } catch (e: ApiException) {
                Toast.makeText(this, "Something Went Wrong!", Toast.LENGTH_LONG).show()
            }
        }
    }

    companion object {
        var userGoogleAccount: UserGoogleAccount? = null
    }
}

private fun googleSignIn(gsc: GoogleSignInClient, activity: ComponentActivity) {
    val signInIntent = gsc.signInIntent
    startActivityForResult(activity, signInIntent, REQUEST_CODE_SIGN_IN, null)
}

@Composable
fun NavGraph(currentUser: GoogleSignInAccount?, gsc: GoogleSignInClient, mainActivity: MainActivity) {
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination =
        if (currentUser == null) "login-screen"
        else "car-choice-screen"
    ) {
        composable("login-screen") {
            LoginScreen(onIconButtonClick = {
                navController.navigate("otp-verification-screen")
            }, onLoginClick = {
                googleSignIn(gsc = gsc, activity = mainActivity)
            })
        }

        composable("otp-verification-screen") {
            OtpVerificationScreen() {
                navController.navigate("car-choice-screen")
            }
        }

        composable("car-choice-screen") {
            PoolOrFindCarChoiceScreen() {
                navController.navigate("start-destination-screen")
            }
        }

        composable("start-destination-screen") {
            StartDestinationScreen() {
                navController.navigate("rides_list_screen")
            }
        }

        composable("rides_list_screen") {
            RidesListScreen() {
                navController.navigate("ride_details_screen")
            }
        }

        composable("ride_details_screen") {
            RideDetailScreen() {
                navController.navigate("chat_Screen")
            }
        }

        composable("chat_Screen") {
            ChatScreen()
        }
    }
}
