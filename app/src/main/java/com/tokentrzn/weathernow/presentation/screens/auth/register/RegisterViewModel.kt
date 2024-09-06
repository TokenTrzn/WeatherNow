package com.tokentrzn.weathernow.presentation.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.tokentrzn.weathernow.domain.model.FirebaseResponse
import com.tokentrzn.weathernow.domain.use_cases.authentication.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val authUseCases: AuthUseCases): ViewModel(){

    // State
    var state by mutableStateOf(RegisterState())
        private set

    // Response
    var registerResponse by mutableStateOf<FirebaseResponse<FirebaseUser>?>(null)
        private set

    // VALIDATIONS
    var isEmailValid by mutableStateOf(false)
    var emailErrMsg by mutableStateOf("")
    var isPasswordValid by mutableStateOf(false)
    var passwordErrMsg by mutableStateOf("")
    var isPasswordEquals by mutableStateOf(false)
    var passwordNotEqualsMsg by mutableStateOf("")
    var isEnabledRegisterButton by mutableStateOf(false)

    // Register user in Firebase Authentication
    fun registerUser(email: String, password: String) {
        viewModelScope.launch {
            val response = authUseCases.register(email, password)
            registerResponse = response

            if (response is FirebaseResponse.Success) {

            }
        }
    }

    // Validate email format
    fun validateEmail() {
        isEmailValid = Patterns.EMAIL_ADDRESS.matcher(state.email).matches()
        emailErrMsg = if (isEmailValid) "" else "El email no tiene el formato válido"
        enabledRegisterButton()
    }

    // Validate password length
    fun validatePassword() {
        isPasswordValid = state.password.length >= 6
        passwordErrMsg = if (isPasswordValid) "" else "La contraseña debe tener al menos 6 caracteres"
        enabledRegisterButton()
    }

    // Confirm password match
    fun confirmPassword() {
        isPasswordEquals = state.password == state.confirmPassword
        passwordNotEqualsMsg = if (isPasswordEquals) "" else "Las contraseñas no coinciden"
        enabledRegisterButton()
    }

    // Enable/disable register button based on validation
    fun enabledRegisterButton() {
        isEnabledRegisterButton = isEmailValid && isPasswordValid && isPasswordEquals
    }

    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

    fun onConfirmPasswordInput(confirmPassword: String) {
        state = state.copy(confirmPassword = confirmPassword)
    }

    fun cleanTextFields() {
        state = RegisterState()
    }
}
