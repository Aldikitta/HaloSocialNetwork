package com.aldikitta.hollahalo.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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
    val loginUiState by loginViewModel.loginUiState.collectAsStateWithLifecycle()

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
            text = loginUiState.usernameText,
            onValueChange = { username ->
                loginViewModel.onEvent(LoginUiEvent.UsernameInputText(username))
            },
            hint = stringResource(id = R.string.enter_username),
            label = stringResource(id = R.string.username),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = stringResource(id = R.string.username)
                )
            },
            keyboardType = KeyboardType.Text
        )

        SocialTextField(
            text = loginUiState.passwordText,
            onValueChange = { password ->
                loginViewModel.onEvent(LoginUiEvent.PasswordInputText(password))
            },
            hint = stringResource(id = R.string.enter_password),
            label = stringResource(id = R.string.password),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = stringResource(id = R.string.password)
                )
            },
            keyboardType = KeyboardType.Password,
            trailingIcon = {
                IconButton(onClick = {
                    loginViewModel.onEvent(LoginUiEvent.ToggleVisibilityClick(loginUiState.toggleVisibility))
                }) {
                    Icon(
                        imageVector = if (loginUiState.toggleVisibility) Icons.Filled.Add else Icons.Filled.Lock,
                        contentDescription = ""
                    )
                }
            },
            visualTransformation = when {
                loginUiState.toggleVisibility -> PasswordVisualTransformation()
                else -> VisualTransformation.None
            }
        )
    }

//    LoginScreenContent(
//        usernameText = usernameText.value.usernameText,
//        passwordText = passwordText.value.passwordText,
//        onValueChangeUsername = { username ->
//            loginViewModel.onEvent(LoginUiEvent.UsernameInputText(username))
//        },
//        onValueChangePassword = { password ->
//            loginViewModel.onEvent(LoginUiEvent.PasswordInputText(password))
//        },
//        onVisibilityClick = {
//            loginViewModel.onEvent(LoginUiEvent.ToggleVisibility(toggleVisibility.value))
//            onVisibilityChange(!isPasswordVisible)
////            toggleVisibility.value = true
//            Log.d("TAG",
//                onVisibilityChange(!isPasswordVisible).toString())
//        },
//        showPassword = loginViewModel.onEvent(LoginUiEvent.ShowPassword)
//    )
}

//@Composable
//fun LoginScreenContent(
//    usernameText: String,
//    passwordText: String,
//    onValueChangeUsername: (String) -> Unit,
//    onValueChangePassword: (String) -> Unit,
//    onVisibilityClick: () -> Unit,
//    showPassword: Unit,
//) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(horizontal = MaterialTheme.spacing.small),
//        verticalArrangement = Arrangement.Center
//    ) {
//        Text(
//            text = stringResource(id = R.string.login),
//            style = MaterialTheme.typography.displaySmall
//        )
//        SocialTextField(
//            text = usernameText,
//            onValueChange = onValueChangeUsername,
//            hint = stringResource(id = R.string.enter_username),
//            label = stringResource(id = R.string.username),
//            leadingIcon = {
//                Icon(
//                    imageVector = Icons.Filled.Email,
//                    contentDescription = stringResource(id = R.string.username)
//                )
//            },
//            keyboardType = KeyboardType.Text
//        )
//        SocialTextField(
//            text = passwordText,
//            onValueChange = onValueChangePassword,
//            hint = stringResource(id = R.string.enter_password),
//            label = stringResource(id = R.string.password),
//            leadingIcon = {
//                Icon(
//                    imageVector = Icons.Filled.Lock,
//                    contentDescription = stringResource(id = R.string.password)
//                )
//            },
//            keyboardType = KeyboardType.Password,
//            trailingIcon = {
//                IconButton(onClick = onVisibilityClick) {
//                    Icon(imageVector = Icons.Filled.Add, contentDescription = "")
////                    Icon(imageVector = if () Icons.Filled.Email else Icons.Filled.Lock, contentDescription = "")
//                }
//            }
//        )
//    }
//}