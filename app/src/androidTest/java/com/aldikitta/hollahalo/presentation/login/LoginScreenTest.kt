package com.aldikitta.hollahalo.presentation.login

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.NavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.aldikitta.hollahalo.presentation.MainActivity
import com.aldikitta.signin.LoginScreen
import com.example.designsystem.theme.HollaHaloTheme
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

//This used to be splash screenV test before using splashscreen API
@RunWith(AndroidJUnit4::class)
class LoginScreenTest {
    @get:Rule
    val composeTestRules = createAndroidComposeRule<MainActivity>()

    @RelaxedMockK
    lateinit var navController: NavController

    @Before
    fun setup(){
        MockKAnnotations.init(this)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun loginScreen_displayAndDisappears() {

        composeTestRules.setContent {
            com.example.designsystem.theme.HollaHaloTheme() {
                com.aldikitta.signin.LoginScreen(navController = navController)
            }
        }

        composeTestRules
            .onNodeWithText(text = "Hello Sayang")
            .assertExists()
    }
}