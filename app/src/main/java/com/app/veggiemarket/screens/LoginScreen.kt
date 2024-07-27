package com.app.veggiemarket.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.veggiemarket.R
import com.app.veggiemarket.components.ButtonComponent
import com.app.veggiemarket.components.ClickableLoginTextComponent
import com.app.veggiemarket.components.DividerTextComponent
import com.app.veggiemarket.components.HeadingTextComponent
import com.app.veggiemarket.components.MyTextFieldComponent
import com.app.veggiemarket.components.PasswordTextFieldComponent
import com.app.veggiemarket.data.LoginViewModel
import com.app.veggiemarket.data.login.LoginUIEvent
import com.app.veggiemarket.navigation.AppRouter
import com.app.veggiemarket.navigation.Screen
import com.app.veggiemarket.navigation.SystemBackButtonHandler


@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {

//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//
//        Surface(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color.White)
//                .padding(28.dp)
//        )
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.bl),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds // Adjust content scale as needed
        )

        // Your content here, wrapped in another Box or Surface for stacking layers
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(28.dp)
        )
        {


            Column( modifier = Modifier.fillMaxSize()) {
//                Image(
//                    modifier = Modifier.size(350.dp),
//                    painter = painterResource(id = R.drawable.grocery),
//                    contentDescription = null)
                Spacer(modifier = Modifier.height(100.dp))
                HeadingTextComponent(value = "Login")
                Spacer(modifier = Modifier.height(80.dp))

                MyTextFieldComponent(labelValue = stringResource(id = com.app.veggiemarket.R.string.email),
                    painterResource(id = com.app.veggiemarket.R.drawable.message),
                    onTextChanged = { loginViewModel.onEvent(LoginUIEvent.EmailChanged(it)) },
                    errorStatus = loginViewModel.loginUIState.value.emailError
                )

                PasswordTextFieldComponent(
                    labelValue = stringResource(id =com.app.veggiemarket. R.string.password),
                    painterResource(id = com.app.veggiemarket.R.drawable.lock),
                    onTextSelected = {
                        loginViewModel.onEvent(LoginUIEvent.PasswordChanged(it))
                    },
                    errorStatus = loginViewModel.loginUIState.value.passwordError
                )

                Spacer(modifier = Modifier.height(40.dp))

                Spacer(modifier = Modifier.height(40.dp))

                ButtonComponent(
                    value = stringResource(id = com.app.veggiemarket.R.string.login),
                    onButtonClicked = {
                       loginViewModel.onEvent(LoginUIEvent.LoginButtonClicked)
                    },
                    isEnabled = loginViewModel.allValidationsPassed.value
                )

                Spacer(modifier = Modifier.height(20.dp))

                DividerTextComponent()

                ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
                    AppRouter.navigateTo(Screen.SignUpScreen)
                })
            }
        }

        if(loginViewModel.loginInProgress.value) {
            CircularProgressIndicator()
        }
    }

    SystemBackButtonHandler {
        AppRouter.navigateTo(Screen.SignUpScreen)
    }

}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
