package com.tokentrzn.weathernow.presentation.screens.auth.login.components

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider
import com.tokentrzn.weathernow.R
import com.tokentrzn.weathernow.presentation.navigation.Screen
import com.tokentrzn.weathernow.presentation.screens.auth.login.LoginViewModel
import com.tokentrzn.weathernow.presentation.theme.PrimaryTextColor

@Composable
fun LoginSocial( navController: NavController, viewModel: LoginViewModel = hiltViewModel()) {

    val token = "771325904491-aumtjbvenruhkmdjfeho9iel7kul9gel.apps.googleusercontent.com"
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
        try {
            val account = task.getResult(ApiException::class.java)
            val credential = GoogleAuthProvider.getCredential(account.idToken, null)
            viewModel.loginWithGoogle(credential) {
                navController.navigate(Screen.Weather.route)
            }
        } catch(ex: Exception) {
            ex.printStackTrace()
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 40.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .clickable {
                val options = GoogleSignInOptions.Builder(
                    GoogleSignInOptions.DEFAULT_SIGN_IN
                )
                    .requestIdToken(token)
                    .requestEmail()
                    .build()
                val googleLoginClient = GoogleSignIn.getClient(context, options)
                launcher.launch(googleLoginClient.signInIntent)
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(id = R.drawable.google_icon_color),
            contentDescription = "Google Icon",
            modifier = Modifier
                .padding(10.dp)
                .size(40.dp)
        )
        Text(
            text = "Iniciar Sesión con Google",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = PrimaryTextColor
        )
    }
}