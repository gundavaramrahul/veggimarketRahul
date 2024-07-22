package com.app.veggiemarket.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.veggiemarket.R
import com.app.veggiemarket.compoofveg.ButtonComponent
import com.app.veggiemarket.compoofveg.CheckboxComponent
import com.app.veggiemarket.compoofveg.ClickableLoginTextComponent
import com.app.veggiemarket.compoofveg.DividerTextComponent
import com.app.veggiemarket.compoofveg.HeadingTextComponent
import com.app.veggiemarket.compoofveg.MyTextFieldComponent
import com.app.veggiemarket.compoofveg.PasswordTextFieldComponent
import com.app.veggiemarket.data.vegmarketsignup.SUIEventveg
import com.app.veggiemarket.data.vegmarketsignup.Svm
import com.app.veggiemarket.navigation.AppRouter
import com.app.veggiemarket.navigation.Screen


@Composable
fun SignUps(signupViewModel: Svm = viewModel()) {

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

            Column(
                modifier = Modifier
                    .background(color = Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Image(
                    modifier = Modifier.size(220.dp),
                    painter = painterResource(id = com.app.veggiemarket.R.drawable.grocery),
                    contentDescription = null)
                  HeadingTextComponent(value = "VeggieMarket App")
                  Spacer(modifier = Modifier.height(8.dp))
                  MyTextFieldComponent(
                    labelValue = stringResource(id = com.app.veggiemarket.R.string.first_name),
                    painterResource(id =com.app.veggiemarket. R.drawable.profile),
                    onTextChanged = {
                        signupViewModel.onEvent(SUIEventveg.FirstNameChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.firstNameError
                )

                MyTextFieldComponent(
                    labelValue = stringResource(id = com.app.veggiemarket.R.string.last_name),
                    painterResource = painterResource(id =com.app.veggiemarket. R.drawable.profile),
                    onTextChanged = {
                        signupViewModel.onEvent(SUIEventveg.LastNameChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.lastNameError
                )

                MyTextFieldComponent(
                    labelValue = stringResource(id =com.app.veggiemarket. R.string.email),
                    painterResource = painterResource(id = com.app.veggiemarket.R.drawable.message),
                    onTextChanged = {
                        signupViewModel.onEvent(SUIEventveg.EmailChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.emailError
                )

                PasswordTextFieldComponent(
                    labelValue = stringResource(id = com.app.veggiemarket.R.string.password),
                    painterResource = painterResource(id = com.app.veggiemarket.R.drawable.ic_lock),
                    onTextSelected = {
                        signupViewModel.onEvent(SUIEventveg.PasswordChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.passwordError
                )

//                CheckboxComponent(value = stringResource(id = com.app.veggiemarket.R.string.terms_and_conditions),
//                    onTextSelected = {
//                        AppRouter.navigateTo(Screen.TermsAndConditionsScreen)
//                    },
//                    onCheckedChange = {
//                        signupViewModel.onEvent(SignupUIEvent.PrivacyPolicyCheckBoxClicked(it))
//                    }
//                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0x4B4CAF50)) // Adjust the color as needed
                ) {
                    CheckboxComponent(
                        value = stringResource(id = com.app.veggiemarket.R.string.terms_and_conditions),
                        onTextSelected = {
                            AppRouter.navigateTo(Screen.TermsAndConditionsScreen)
                        },
                        onCheckedChange = {
                            signupViewModel.onEvent(SUIEventveg.PrivacyPolicyCheckBoxClicked(it))
                        }
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                ButtonComponent(
                    value = stringResource(id =com.app.veggiemarket. R.string.register),
                    onButtonClicked = {
                        signupViewModel.onEvent(SUIEventveg.RegisterButtonClicked)
                    },
                    isEnabled = signupViewModel.allValidationsPassed.value
                )

                Spacer(modifier = Modifier.height(10.dp))

                DividerTextComponent()

                ClickableLoginTextComponent(tryingToLogin = true, onTextSelected = {
                    AppRouter.navigateTo(Screen.LoginScreen)
                })
            }
        }


        if(signupViewModel.signUpInProgress.value) {
            CircularProgressIndicator()
        }
    }

}

@Preview
@Composable
fun DefaultPreviewOfSignUps() {
    SignUps()
}