package com.aldikitta.hollahalo.presentation.auth.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
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
import com.aldikitta.hollahalo.presentation.auth.composable.GreetingAuth
import com.aldikitta.hollahalo.presentation.auth.composable.SocialTextField
import com.aldikitta.hollahalo.presentation.ui.theme.spacing

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun RegisterScreen(
    navController: NavController, registerViewModel: RegisterViewModel = hiltViewModel()
) {
    val registerUiState by registerViewModel.registerUiState.collectAsStateWithLifecycle()
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = MaterialTheme.spacing.small)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GreetingAuth(
                header = stringResource(id = R.string.welcome),
                subHeader = stringResource(id = R.string.your_new_here),
            )
            SocialTextField(text = registerUiState.emailText,
                onValueChange = { email ->
                    registerViewModel.onEvent(RegisterUiEvent.EmailInputText(email))
                    registerViewModel.onEvent(
                        RegisterUiEvent.ValidateEmail(
                            email = registerUiState.emailText
                        )
                    )
                },
                hint = stringResource(id = R.string.enter_email),
                label = stringResource(id = R.string.email),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = stringResource(id = R.string.email)
                    )
                },
                keyboardType = KeyboardType.Email,
                isError = !registerUiState.validateEmail,
                errorMessage = stringResource(id = R.string.validate_email),
                trailingIcon = {
                    if (registerUiState.emailText.isNotEmpty()) {
                        IconButton(onClick = { registerViewModel.onEvent(RegisterUiEvent.EmptyFieldEmail) }) {
                            Icon(
                                imageVector = Icons.Outlined.Cancel,
                                contentDescription = stringResource(R.string.empty_email_field)
                            )
                        }
                    }
                })

            SocialTextField(text = registerUiState.usernameText,
                onValueChange = { username ->
                    registerViewModel.onEvent(RegisterUiEvent.UsernameInputText(username))
                    registerViewModel.onEvent(
                        RegisterUiEvent.ValidateUsername(
                            username = registerUiState.usernameText
                        )
                    )
                },
                hint = stringResource(id = R.string.enter_username),
                label = stringResource(id = R.string.username),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = stringResource(id = R.string.username)
                    )
                },
                keyboardType = KeyboardType.Email,
                isError = !registerUiState.validateUsername,
                errorMessage = stringResource(id = R.string.validate_username),
                trailingIcon = {
                    if (registerUiState.usernameText.isNotEmpty()) {
                        IconButton(onClick = { registerViewModel.onEvent(RegisterUiEvent.EmptyFieldUsername) }) {
                            Icon(
                                imageVector = Icons.Outlined.Cancel,
                                contentDescription = stringResource(R.string.empty_username_field)
                            )
                        }
                    }
                })

            SocialTextField(
                text = registerUiState.passwordText,
                onValueChange = { password ->
                    registerViewModel.onEvent(RegisterUiEvent.PasswordInputText(password))
                    registerViewModel.onEvent(
                        RegisterUiEvent.ValidatePassword(
                            password = registerUiState.passwordText
                        )
                    )
                },
                hint = stringResource(id = R.string.enter_password),
                label = stringResource(id = R.string.password),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Password,
                        contentDescription = stringResource(id = R.string.password)
                    )
                },
                keyboardType = KeyboardType.Password,
                trailingIcon = {
                    Row {
                        if (registerUiState.passwordText.isNotEmpty()) {
                            IconButton(onClick = { registerViewModel.onEvent(RegisterUiEvent.EmptyFieldPassword) }) {
                                Icon(
                                    imageVector = Icons.Outlined.Cancel,
                                    contentDescription = stringResource(R.string.empty_password_field)
                                )
                            }
                        }
                        IconButton(onClick = {
                            registerViewModel.onEvent(
                                RegisterUiEvent.ToggleVisibilityClick(
                                    registerUiState.toggleVisibility
                                )
                            )
                        }) {
                            Icon(
                                imageVector = if (registerUiState.toggleVisibility) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                contentDescription = ""
                            )
                        }
                    }
                },
                visualTransformation = if (registerUiState.toggleVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                isError = !registerUiState.validatePassword,
                errorMessage = stringResource(id = R.string.validate_password)
            )

            SocialTextField(
                text = registerUiState.confirmPasswordText,
                onValueChange = { confirmPassword ->
                    registerViewModel.onEvent(
                        RegisterUiEvent.ConfirmPasswordInputText(
                            confirmPassword
                        )
                    )
                    registerViewModel.onEvent(
                        RegisterUiEvent.ValidateConfirmPassword(
                            confirmPassword = registerUiState.confirmPasswordText
                        )
                    )
                },
                hint = stringResource(id = R.string.enter_confirmPassword),
                label = stringResource(id = R.string.confirmPassword),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Password,
                        contentDescription = stringResource(id = R.string.confirmPassword)
                    )
                },
                keyboardType = KeyboardType.Password,
                trailingIcon = {
                    Row {
                        if (registerUiState.confirmPasswordText.isNotEmpty()) {
                            IconButton(onClick = { registerViewModel.onEvent(RegisterUiEvent.EmptyFieldConfirmPassword) }) {
                                Icon(
                                    imageVector = Icons.Outlined.Cancel,
                                    contentDescription = stringResource(R.string.empty_confirmPassword_field)
                                )
                            }
                        }
                        IconButton(onClick = {
                            registerViewModel.onEvent(
                                RegisterUiEvent.ToggleVisibilityClick(
                                    registerUiState.toggleVisibility
                                )
                            )
                        }) {
                            Icon(
                                imageVector = if (registerUiState.toggleVisibility) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                contentDescription = ""
                            )
                        }
                    }
                },
                visualTransformation = if (registerUiState.toggleVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                isError = !registerUiState.validateConfirmPassword,
                errorMessage = stringResource(id = R.string.validate_confirmPassword)
            )
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
            Button(
                onClick = {
//
                },
                enabled = if (
                    registerUiState.emailText.isEmpty() ||
                    registerUiState.usernameText.isEmpty() ||
                    registerUiState.passwordText.isEmpty() ||
                    registerUiState.confirmPasswordText.isEmpty()
                ) false
                else
                    registerUiState.validateEmail &&
                            registerUiState.validateUsername &&
                            registerUiState.validatePassword &&
                            registerUiState.validateConfirmPassword


            ) {
                Text(text = stringResource(id = R.string.sign_me_up))
            }
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.large))

        }
        Row(
            modifier = Modifier
                .padding(MaterialTheme.spacing.medium)
                .align(Alignment.BottomCenter)

        ) {
            Text(text = stringResource(id = R.string.already_here))
            Text(
                modifier = Modifier.clickable { navController.navigateUp() },
                text = stringResource(id = R.string.login_instead),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}