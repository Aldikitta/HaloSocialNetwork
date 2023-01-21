package com.aldikitta.signin

import androidx.compose.foundation.*
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.aldikitta.designsystem.R
import com.aldikitta.designsystem.components.GreetingAuth
import com.aldikitta.designsystem.components.SocialTextField
import com.aldikitta.designsystem.theme.spacing

@Composable
fun SignInScreen(
    navController: NavController,
    signInViewModel: SignInViewModel = hiltViewModel()
) {
    val signInUiState by signInViewModel.signInUiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.systemBarsPadding(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GreetingAuth(
                header = stringResource(id = R.string.hello_again),
                subHeader = stringResource(id = R.string.welcome_back),
            )
            SocialTextField(
                text = signInUiState.usernameText,
                onValueChange = { username ->
                    signInViewModel.onEvent(SignInUiEvent.UsernameInputText(username))
                    signInViewModel.onEvent(
                        SignInUiEvent.ValidateUsername(
                            username = signInUiState.usernameText
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
                isError = !signInUiState.validateUsername,
                errorMessage = stringResource(id = R.string.validate_username),
                trailingIcon = {
                    if (signInUiState.usernameText.isNotEmpty()) {
                        IconButton(onClick = { signInViewModel.onEvent(SignInUiEvent.EmptyFieldUsername) }) {
                            Icon(
                                imageVector = Icons.Outlined.Cancel,
                                contentDescription = stringResource(R.string.empty_username_field)
                            )
                        }
                    }
                }
            )

            SocialTextField(
                text = signInUiState.passwordText,
                onValueChange = { password ->
                    signInViewModel.onEvent(
                        SignInUiEvent.PasswordInputText(password),
                    )
                    signInViewModel.onEvent(
                        SignInUiEvent.ValidatePassword(
                            password = signInUiState.passwordText
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
                        if (signInUiState.passwordText.isNotEmpty()) {
                            IconButton(onClick = { signInViewModel.onEvent(SignInUiEvent.EmptyFieldPassword) }) {
                                Icon(
                                    imageVector = Icons.Outlined.Cancel,
                                    contentDescription = stringResource(R.string.empty_password_field)
                                )
                            }
                        }
                        IconButton(onClick = {
                            signInViewModel.onEvent(
                                SignInUiEvent.ToggleVisibilityClick(
                                    signInUiState.toggleVisibility
                                )
                            )
                        }) {
                            Icon(
                                imageVector = if (signInUiState.toggleVisibility) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                contentDescription = ""
                            )
                        }
                    }
                },
                visualTransformation = if (signInUiState.toggleVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                isError = !signInUiState.validatePassword,
                errorMessage = stringResource(id = R.string.validate_password)
            )
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
            Button(
                onClick = {

                },
                enabled = if (signInUiState.usernameText.isEmpty() || signInUiState.passwordText.isEmpty()) false else signInUiState.validateUsername && signInUiState.validatePassword
            ) {
                Text(text = stringResource(id = R.string.take_me_in))
            }
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.large))
            Text(
                text = stringResource(id = R.string.or_continue_with),
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.outline
            )
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.large))
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
                .fillMaxWidth()
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.Center

        ) {
            Text(text = stringResource(id = R.string.new_here))
            Text(
                modifier = Modifier.clickable {
                    navController.navigate(Screen.RegisterScreen.route) {
//                        popUpToId { inclusive = true }
                    }
                },
                text = stringResource(id = R.string.apply),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }


}