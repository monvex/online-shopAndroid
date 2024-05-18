package com.example.online_shop.presentation.auth

import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import com.example.online_shop.data.dataStore.TokenManager
import com.example.online_shop.data.remote.requests.AuthRequest
import com.example.online_shop.data.remote.responses.AuthResponse
import com.example.online_shop.domain.repository.OnlineShopRepository
import com.example.online_shop.utils.ApiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AuthScreenViewModel @Inject constructor(
    private val repository: OnlineShopRepository,
    private val tokenManager: TokenManager
): ViewModel() {
    var uiState = mutableStateOf(AuthState())
        private set

    private val login
        get() = uiState.value.login
    private val password
        get() = uiState.value.password

    var token: String? = null
    val role = MutableLiveData<String?>()
    init {
        runBlocking() {
                token = tokenManager.getToken().first()
            }
        }

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