package com.example.online_shop.presentation.auth

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.online_shop.data.remote.requests.AuthRequest
import com.example.online_shop.data.remote.responses.AuthResponse
import com.example.online_shop.domain.repository.OnlineShopRepository
import com.example.online_shop.utils.ApiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthScreenViewModel @Inject constructor(
    private val repository: OnlineShopRepository
): ViewModel() {

    var uiState = mutableStateOf(AuthState())
        private set

    private val login
        get() = uiState.value.login
    private val password
        get() = uiState.value.password

    fun onLoginChange(newValue: String) {
        uiState.value = uiState.value.copy(login = newValue)
    }

    fun onPasswordChange(newValue: String) {
        uiState.value = uiState.value.copy(password = newValue)
    }

    suspend fun signIn(authRequest: AuthRequest): AuthResponse {
        return repository.login(authRequest)
    }

}