package com.app.veggiemarket.data.vegmarketsignup

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.app.veggiemarket.data.RUIstate
import com.app.veggiemarket.data.vegmarketrules.Validator
import com.app.veggiemarket.navigation.AppRouter
import com.app.veggiemarket.navigation.Screen


class Svm : ViewModel() {

    private val TAG = Svm::class.simpleName
    var registrationUIState = mutableStateOf(RUIstate())
    var allValidationsPassed = mutableStateOf(false)
    var signUpInProgress = mutableStateOf(false)


    fun onEvent(event: SUIEventveg) {
        when (event) {
            is SUIEventveg.FirstNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(firstName = event.firstName)
            }


            is SUIEventveg.LastNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(lastName = event.lastName)
            }


            is SUIEventveg.EmailChanged -> {
                registrationUIState.value = registrationUIState.value.copy(email = event.email)
            }

            is SUIEventveg.PasswordChanged -> {
                registrationUIState.value = registrationUIState.value.copy(password = event.password)
            }

            is SUIEventveg.RegisterButtonClicked -> {
                signUp()
            }

            is SUIEventveg.PrivacyPolicyCheckBoxClicked -> {
                registrationUIState.value = registrationUIState.value.copy(privacyPolicyAccepted = event.status)
            }
        }
        validateDataWithRules()
    }


    private fun signUp() {
        createUserInFirebase(
            email = registrationUIState.value.email,
            password = registrationUIState.value.password
        )
    }

    private fun validateDataWithRules() {
        val fNameResult = Validator.validateFirstName(fName = registrationUIState.value.firstName)

        val lNameResult = Validator.validateLastName(lName = registrationUIState.value.lastName)

        val emailResult = Validator.validateEmail(email = registrationUIState.value.email)

        val passwordResult = Validator.validatePassword(password = registrationUIState.value.password)

        val privacyPolicyResult = Validator.validatePrivacyPolicyAcceptance(statusValue = registrationUIState.value.privacyPolicyAccepted)

        registrationUIState.value = registrationUIState.value.copy(
            firstNameError = fNameResult.status,
            lastNameError = lNameResult.status,
            emailError = emailResult.status,
            passwordError = passwordResult.status,
            privacyPolicyError = privacyPolicyResult.status
        )

        allValidationsPassed.value = fNameResult.status && lNameResult.status && emailResult.status && passwordResult.status && privacyPolicyResult.status

    }



    private fun createUserInFirebase(email: String, password: String) {
        signUpInProgress.value = true
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { signUpInProgress.value = false
                if (it.isSuccessful) { AppRouter.navigateTo(Screen.HomeScreen) }
            }.addOnFailureListener {


            }
    }
}
