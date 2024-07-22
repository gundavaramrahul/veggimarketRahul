package com.app.veggiemarket.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen {

    object SignUps : Screen()
    object TermsAndConditionsScreen : Screen()
    object LoginScreen : Screen()
    object HomeScreen : Screen()

}


object AppRouter {

    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.SignUps)

    fun navigateTo(destination : Screen){
        currentScreen.value = destination
    }


}