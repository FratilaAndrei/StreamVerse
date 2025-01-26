package com.streamverse.tv_app.feature.auth

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.tv.material3.Button
import androidx.tv.material3.ButtonDefaults
import androidx.tv.material3.Text
import com.streamverse.tv_app.R
import com.streamverse.tv_app.feature.auth.components.LoginField
import com.streamverse.tv_app.feature.home.HomeRoute


@Composable
fun AuthScreen(modifier: Modifier = Modifier, navController: NavController) {
    val focusRequester = remember { FocusRequester() }
    val email = remember { FocusRequester() }
    val password = remember { FocusRequester() }
    val viewModel = remember { LoginViewModel() }
    val state = viewModel.uiState.collectAsStateWithLifecycle().value
    val context = LocalContext.current.applicationContext
    val account1 = Account(state.userName, state.password)

    Box(modifier) {
        Image(
            painter = painterResource(R.drawable.auth_background),
            contentDescription = "backgroundImage",
            modifier = Modifier
                .fillMaxSize()
                .height(300.dp)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .width(300.dp)
                .align(Alignment.Center)
                .zIndex(1f)
        ) {

            Image(painterResource(R.drawable.logo), contentDescription = "")

            LoginField(
                focusRequester = email,
                value = state.userName,
                onValueChange = { viewModel.setAction(LoginContract.Action.UserNameValueChanged(it)) },
                keyboardType = KeyboardType.Email,
                placeholder = "Email"
            )

            Spacer(modifier = Modifier.height(10.dp))

            LoginField(
                focusRequester = password,
                value = state.password,
                onValueChange = { viewModel.setAction(LoginContract.Action.PasswordValueChanged(it)) },
                keyboardType = KeyboardType.Password,
                placeholder = "Password"
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    if (account1 == adminAccount) navController.navigate(HomeRoute) else Toast.makeText(
                        context,
                        "Account doesnt exists",
                        Toast.LENGTH_LONG
                    ).show()
                },
                scale = ButtonDefaults.scale(focusedScale = 1.1f),
                colors = ButtonDefaults.colors(Color.White),
                modifier = Modifier.width(150.dp),
            ) {
                Text(
                    "Sign In",
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

    }

    LaunchedEffect(focusRequester) {
        email.requestFocus()
    }
}

data class Account(val email: String, val password: String)

private val adminAccount = Account("andrei@gmail.com", "dani")