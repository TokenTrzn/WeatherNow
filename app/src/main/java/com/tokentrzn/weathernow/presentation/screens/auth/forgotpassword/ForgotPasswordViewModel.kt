package com.tokentrzn.weathernow.presentation.screens.auth.forgotpassword

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tokentrzn.weathernow.domain.model.FirebaseResponse
import com.tokentrzn.weathernow.domain.use_cases.authentication.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(private val authUseCases: AuthUseCases): ViewModel() {
    //STATES
    var state by mutableStateOf(ForgotPasswordState(email = ""))
        private set

    var response by mutableStateOf<FirebaseResponse<String>?>(null)

    //VALIDATIONS
    var isEmailValid by mutableStateOf(false)
    var emailErrMsg by mutableStateOf("")

    var isEnabledSendEmailButton = false

    fun validateEmail(){
        if(Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            isEmailValid=true
            emailErrMsg = ""
        }else{
            isEmailValid =false
            emailErrMsg = "El email no tiene el formato válido"
        }
    }

    fun enabledSendEmailButton(){
        isEnabledSendEmailButton = isEmailValid
    }

    fun sendPasswordRecoveryEmail(email: String) = viewModelScope.launch {
        /*
        response = FirebaseResponse.Loading
        val result = authUseCases.sendPasswordResetEmail(state.email)
        response = result
         */
    }

    //INPUTS
    fun onEmailInput(email:String){
        state = state.copy(email = email)
    }
}