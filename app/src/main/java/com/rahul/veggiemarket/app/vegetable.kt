package com.rahul.veggiemarket.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rahul.veggiemarket.data.home.HomeViewModel
import com.rahul.veggiemarket.navigation.AppRouter
import com.rahul.veggiemarket.navigation.Screen
import com.rahul.veggiemarket.screens.HomeScreen
import com.rahul.veggiemarket.screens.LoginScreen
import com.rahul.veggiemarket.screens.SignUpScreen
import com.rahul.veggiemarket.screens.TermsAndConditionsScreen


@Composable
fun VegetableApps(homeViewModel: HomeViewModel = viewModel()) {

    homeViewModel.checkForActiveSession()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.LightGray
    ) {

        if (homeViewModel.isUserLoggedIn.value == true) {
            AppRouter.navigateTo(Screen.HomeScreen)
        }

        Crossfade(targetState = AppRouter.currentScreen) { currentState ->
            when (currentState.value) {
                is Screen.SignUpScreen -> {
                    SignUpScreen()
                }

                is Screen.TermsAndConditionsScreen -> {
                    TermsAndConditionsScreen()
                }

                is Screen.LoginScreen -> {
                    LoginScreen()
                }

                is Screen.HomeScreen -> {
                    HomeScreen()
                }
            }
        }

    }
}