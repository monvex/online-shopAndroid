package com.example.online_shop.presentation.auth

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
):ViewModel() {
    private val _loginResponse = MutableLiveData<ApiResponse<AuthResponse>>()
    val loginResponse = _loginResponse

    suspend fun signIn(authRequest: AuthRequest): AuthResponse {
        return repository.login(authRequest)
    }

}