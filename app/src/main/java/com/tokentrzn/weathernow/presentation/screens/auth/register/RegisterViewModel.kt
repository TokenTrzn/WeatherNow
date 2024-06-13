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
    var registerResponse by mutableStateOf<FirebaseResponse<FirebaseUser?>?>(null)

    fun register() = viewModelScope.launch {
        registerResponse = FirebaseResponse.Loading
        val result = authUseCases.register(state.email, state.password)
        registerResponse = result
    }

    //VALIDATIONS
    var isEmailValid by mutableStateOf(false)
    var emailErrMsg by mutableStateOf("")
    var isPasswordValid by mutableStateOf(false)
    var passwordErrMsg by mutableStateOf("")
    var passwordNotEqualsMsg by mutableStateOf("")

    var isPasswordEquals by mutableStateOf(false)

    var isEnabledRegisterButton = false

    fun validateEmail(){
        if(Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            isEmailValid=true
            emailErrMsg = ""
        }else{
            isEmailValid =false
            emailErrMsg = "El email no tiene el formato válido"
        }
    }

    fun validatePassword(){
        if(state.password.length >=6){
            isPasswordValid = true
            passwordErrMsg = ""
        }else{
            isPasswordValid = false
            passwordErrMsg = "La contraseña debe tener al menos 6 caracteres"
        }
    }

    fun confirmPassword() {
        if (state.password == state.confirmPassword) {
            isPasswordEquals = true
            passwordNotEqualsMsg = ""
        } else {
            isPasswordEquals = false
            passwordNotEqualsMsg = "Las contraseñas no coinciden"
        }
    }

    fun enabledRegisterButton(){
        isEnabledRegisterButton= isEmailValid && isPasswordValid && isPasswordEquals
    }

    //INPUTS
    fun onNameInput(name:String){
        state = state.copy(name = name)
    }

    fun onCityInput(city:String){
        state = state.copy(city = city)
    }

    fun onEmailInput(email:String){
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String){
        state = state.copy(password = password)
    }

    fun onConfirmPasswordInput(confirmPassword: String){
        state = state.copy(confirmPassword = confirmPassword)
    }
}