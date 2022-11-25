package com.aldikitta.hollahalo.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.aldikitta.hollahalo.R
import com.aldikitta.hollahalo.presentation.composable.SocialTextField
import com.aldikitta.hollahalo.presentation.ui.theme.spacing

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun LoginScreen(
    navController: NavController,
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    val usernameText = loginViewModel.usernameText.collectAsStateWithLifecycle()
    val passwordText = loginViewModel.passwordText.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = MaterialTheme.spacing.small),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.login),
            style = MaterialTheme.typography.displaySmall
        )
        SocialTextField(
            text = usernameText.value.usernameText,
            onValueChange = { username ->
                loginViewModel.onEvent(LoginUiEvent.UsernameInputText(username))
            },
            hint = stringResource(id = R.string.enter_username),
            label = stringResource(id = R.string.username)
        )
        SocialTextField(
            text = passwordText.value.passwordText,
            onValueChange = { password ->
                loginViewModel.onEvent(LoginUiEvent.PasswordInputText(password))
            },
            hint = stringResource(id = R.string.enter_password),
            label = stringResource(id = R.string.password)
        )
    }
}