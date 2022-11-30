package com.aldikitta.hollahalo.presentation.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
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
fun LoginScreen(
    navController: NavController,
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    val loginUiState by loginViewModel.loginUiState.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = MaterialTheme.spacing.small),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GreetingAuth(
                header = stringResource(id = R.string.hello_again),
                subHeader = stringResource(id = R.string.welcome_back),
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
                        imageVector = Icons.Filled.Person,
                        contentDescription = stringResource(id = R.string.username)
                    )
                },
                keyboardType = KeyboardType.Text,
                isError = !loginUiState.validateUsername,
                errorMessage = stringResource(id = R.string.validate_username),
                trailingIcon = {
                    if (loginUiState.usernameText.isNotEmpty()) {
                        IconButton(onClick = { loginViewModel.onEvent(LoginUiEvent.EmptyFieldUsername) }) {
                            Icon(
                                imageVector = Icons.Outlined.Cancel,
                                contentDescription = stringResource(R.string.empty_username_field)
                            )
                        }
                    }
                }
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
                        imageVector = Icons.Filled.Password,
                        contentDescription = stringResource(id = R.string.password)
                    )
                },
                keyboardType = KeyboardType.Password,
                trailingIcon = {
                    Row {
                        if (loginUiState.passwordText.isNotEmpty()) {
                            IconButton(onClick = { loginViewModel.onEvent(LoginUiEvent.EmptyFieldPassword) }) {
                                Icon(
                                    imageVector = Icons.Outlined.Cancel,
                                    contentDescription = stringResource(R.string.empty_password_field)
                                )
                            }
                        }
                        IconButton(onClick = {
                            loginViewModel.onEvent(LoginUiEvent.ToggleVisibilityClick(loginUiState.toggleVisibility))
                        }) {
                            Icon(
                                imageVector = if (loginUiState.toggleVisibility) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                                contentDescription = ""
                            )
                        }
                    }
                },
                visualTransformation = if (loginUiState.toggleVisibility) PasswordVisualTransformation() else VisualTransformation.None,
                isError = !loginUiState.validatePassword,
                errorMessage = stringResource(id = R.string.validate_password)
            )
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
            Button(
                onClick = {
                    loginViewModel.onEvent(
                        LoginUiEvent.ValidateForm(
                            username = loginUiState.usernameText,
                            password = loginUiState.passwordText
                        )
                    )
                }) {
                Text(text = stringResource(id = R.string.take_me_in))
            }
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraLarge))
            Text(
                text = stringResource(id = R.string.or_continue_with),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.outline
            )
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraLarge))
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                OutlinedButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .weight(1f)
                        .padding(MaterialTheme.spacing.extraSmall)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = stringResource(
                            id = R.string.google_signIn
                        ),
                        modifier = Modifier.size(30.dp)
                    )
                    Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
                    Text(
                        text = stringResource(id = R.string.google_signIn),
                    )
                }
                OutlinedButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .weight(1f)
                        .padding(MaterialTheme.spacing.extraSmall)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = stringResource(
                            id = R.string.facebook_signIn
                        ),
                        modifier = Modifier.size(30.dp)
                    )
                    Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
                    Text(
                        text = stringResource(id = R.string.facebook_signIn),
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .padding(MaterialTheme.spacing.medium)
                .align(Alignment.BottomCenter)

        ) {
            Text(text = stringResource(id = R.string.new_here))
            Text(
                modifier = Modifier.clickable { },
                text = stringResource(id = R.string.apply),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}