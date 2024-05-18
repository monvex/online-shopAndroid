package com.example.online_shop.presentation.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun AuthScreen(
    viewModel: AuthScreenViewModel = hiltViewModel(),
    onSignInClick: () -> Unit
) {
    val uiState by viewModel.uiState
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

            Text("Введите логин")
            OutlinedTextField(
                value = uiState.login ,
                onValueChange = { viewModel.onLoginChange(it) },
                singleLine = true
            )
            Text("Введите пароль")
            OutlinedTextField(
                value = uiState.password ,
                onValueChange = { viewModel.onPasswordChange(it) },
                singleLine = true
            )
            Button(onClick = onSignInClick) {
                Text(text = "Войти")
            }
        }
    }


}



@Preview(showBackground = true)
@Composable
fun AuthScreenPreview() {
    AuthScreen(onSignInClick = {})
}