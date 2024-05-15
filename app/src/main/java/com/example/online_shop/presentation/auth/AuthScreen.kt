package com.example.online_shop.presentation.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp


@Composable
fun AuthScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            var loginText by remember { mutableStateOf("") }
            var passwordText by remember { mutableStateOf("") }
            Column(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = 0.dp,
                        y = 280.dp,
                    ) ,
                ),
            ) {
                Text(
                    text = "Логин:",
                    fontFamily = FontFamily(
                        Font(
                            R.font.relay_comfortaa_regular,
                            weight = FontWeight.W400,
                            style = FontStyle.Normal,
                        ),
                    ),
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                )
                OutlinedTextField(
                    value = uiState.email,
                    onValueChange = { viewModel.onEmailChange(it) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.7f),
                    textStyle = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp,
                    ),
                )
                Text(
                    text = "Пароль:",
                    fontFamily = FontFamily(
                        Font(
                            R.font.relay_comfortaa_regular,
                            weight = FontWeight.W400,
                            style = FontStyle.Normal,
                        ),
                    ),
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                )
                OutlinedTextField(
                    value = uiState.password,
                    onValueChange = { viewModel.onPasswordChange(it) },
                    visualTransformation = PasswordVisualTransformation(),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.7f),
                    textStyle = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp,
                    ),
                )
            }
            EntryBlock(
                onSignUpTapped = { viewModel.onSignInClick(clearAndNavigate) },
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopCenter,
                    offset = DpOffset(
                        x = -0.5.dp,
                        y = 470.0.dp,
                    ),
                )
                    .fillMaxWidth(0.5f),
            ) { Entry() }

        }
    }


}



@Preview(showBackground = true)
@Composable
fun AuthScreenPreview() {
    AuthScreen()
}