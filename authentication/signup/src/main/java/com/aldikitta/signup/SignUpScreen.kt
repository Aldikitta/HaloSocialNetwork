package com.aldikitta.signup

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.aldikitta.data.util.asString
import com.aldikitta.designsystem.components.GreetingAuth
import com.aldikitta.designsystem.components.SocialTextField
import com.aldikitta.designsystem.R
import com.aldikitta.designsystem.theme.spacing
import com.aldikitta.signup.component.AlertDialogFailedSignUp
import com.aldikitta.signup.component.AlertDialogSuccessSignUp
import kotlinx.coroutines.flow.collectLatest

@Composable
fun SignUpScreen(
    navController: NavController,
    signUpViewModel: SignUpViewModel = hiltViewModel(),
) {
    val signUpState by signUpViewModel.signUpUiState.collectAsStateWithLifecycle()
    val uiState by signUpViewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()

    val openDialog = remember { mutableStateOf(true) }
    val message = remember { mutableStateOf("") }

    LaunchedEffect(pressed) {
        when (uiState) {
            is UIStateSignUp.Error -> {
                openDialog.value = true
            }
            is UIStateSignUp.Success -> {
                openDialog.value = true
            }
            else -> {
                openDialog.value = true
            }
        }
        signUpViewModel.eventFlow.collectLatest {
            when (it) {
                is SignUpEvent.ShowMessage -> {
                    message.value = it.uiText.asString(context)
                }
            }
        }
    }

    when (uiState) {
        is UIStateSignUp.Initial -> Unit
        is UIStateSignUp.Success -> {
            if (openDialog.value) {
                AlertDialogSuccessSignUp(
                    onDismissRequest = {
                        openDialog.value = false
                        navController.popBackStack()
                    },
                    onConfirmButton = {
                        openDialog.value = false
                        navController.popBackStack()
                    },
                    message = message.value
                )
            }
        }
        is UIStateSignUp.Error -> {
            if (openDialog.value) {
                AlertDialogFailedSignUp(
                    onDismissRequest = {
                        openDialog.value = false
                    },
                    onConfirmButton = {
                        openDialog.value = false
                    },
                    errorMessage = message.value
                )
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .systemBarsPadding(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GreetingAuth(
                header = stringResource(id = R.string.welcome),
                subHeader = stringResource(id = R.string.your_new_here),
            )
            SocialTextField(
                text = signUpState.emailText,
                onValueChange = { email ->
                    signUpViewModel.onEvent(SignUpUiEvent.EmailInputText(email))
                    signUpViewModel.onEvent(
                        SignUpUiEvent.ValidateEmail(
                            email = signUpState.emailText
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
                isError = !signUpState.validateEmail,
                errorMessage = stringResource(id = R.string.validate_email),
                trailingIcon = {
                    if (signUpState.emailText.isNotEmpty()) {
                        IconButton(onClick = { signUpViewModel.onEvent(SignUpUiEvent.EmptyFieldEmail) }) {
                            Icon(
                                imageVector = Icons.Outlined.Cancel,
                                contentDescription = stringResource(R.string.empty_email_field)
                            )
                        }
                    }
                })

            SocialTextField(text = signUpState.usernameText,
                onValueChange = { username ->
                    signUpViewModel.onEvent(SignUpUiEvent.UsernameInputText(username))
                    signUpViewModel.onEvent(
                        SignUpUiEvent.ValidateUsername(
                            username = signUpState.usernameText
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
                isError = !signUpState.validateUsername,
                errorMessage = stringResource(id = R.string.validate_username),
                trailingIcon = {
                    if (signUpState.usernameText.isNotEmpty()) {
                        IconButton(onClick = { signUpViewModel.onEvent(SignUpUiEvent.EmptyFieldUsername) }) {
                            Icon(
                                imageVector = Icons.Outlined.Cancel,
                                contentDescription = stringResource(R.string.empty_username_field)
                            )
                        }
                    }
                })

            SocialTextField(
                text = signUpState.passwordText,
                onValueChange = { password ->
                    signUpViewModel.onEvent(SignUpUiEvent.PasswordInputText(password))
                    signUpViewModel.onEvent(
                        SignUpUiEvent.ValidatePassword(
                            password = signUpState.passwordText
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
                        if (signUpState.passwordText.isNotEmpty()) {
                            IconButton(onClick = { signUpViewModel.onEvent(SignUpUiEvent.EmptyFieldPassword) }) {
                                Icon(
                                    imageVector = Icons.Outlined.Cancel,
                                    contentDescription = stringResource(R.string.empty_password_field)
                                )
                            }
                        }
                        IconButton(onClick = {
                            signUpViewModel.onEvent(
                                SignUpUiEvent.ToggleVisibilityClick(
                                    signUpState.toggleVisibility
                                )
                            )
                        }) {
                            Icon(
                                imageVector = if (signUpState.toggleVisibility) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                contentDescription = ""
                            )
                        }
                    }
                },
                visualTransformation = if (signUpState.toggleVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                isError = !signUpState.validatePassword,
                errorMessage = stringResource(id = R.string.validate_password)
            )

            SocialTextField(
                text = signUpState.confirmPasswordText,
                onValueChange = { confirmPassword ->
                    signUpViewModel.onEvent(
                        SignUpUiEvent.ConfirmPasswordInputText(
                            confirmPassword
                        )
                    )
                    signUpViewModel.onEvent(
                        SignUpUiEvent.ValidateConfirmPassword(
                            confirmPassword = signUpState.confirmPasswordText
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
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password,
                trailingIcon = {
                    Row {
                        if (signUpState.confirmPasswordText.isNotEmpty()) {
                            IconButton(onClick = { signUpViewModel.onEvent(SignUpUiEvent.EmptyFieldConfirmPassword) }) {
                                Icon(
                                    imageVector = Icons.Outlined.Cancel,
                                    contentDescription = stringResource(R.string.empty_confirmPassword_field)
                                )
                            }
                        }
                        IconButton(onClick = {
                            signUpViewModel.onEvent(
                                SignUpUiEvent.ToggleVisibilityClick(
                                    signUpState.toggleVisibility
                                )
                            )
                        }) {
                            Icon(
                                imageVector = if (signUpState.toggleVisibility) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                contentDescription = ""
                            )
                        }
                    }
                },
                visualTransformation = if (signUpState.toggleVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                isError = !signUpState.validateConfirmPassword,
                errorMessage = stringResource(id = R.string.validate_confirmPassword)
            )
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
            Button(
                modifier = Modifier
                    .padding(horizontal = MaterialTheme.spacing.large)
                    .fillMaxWidth(),
                onClick = {
                    signUpViewModel.onEvent(SignUpUiEvent.SignUp)
                },
                interactionSource = interactionSource,
                enabled = if (
                    signUpState.emailText.isEmpty() ||
                    signUpState.usernameText.isEmpty() ||
                    signUpState.passwordText.isEmpty() ||
                    signUpState.confirmPasswordText.isEmpty()
                ) false
                else
                    signUpState.validateEmail &&
                            signUpState.validateUsername &&
                            signUpState.validatePassword &&
                            signUpState.validateConfirmPassword


            ) {
                if (signUpState.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(CenterVertically),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                } else {
                    Text(
                        modifier = Modifier.padding(MaterialTheme.spacing.small),
                        text = stringResource(id = R.string.sign_me_up), style = MaterialTheme.typography.bodyMedium
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
            Text(text = stringResource(id = R.string.already_here))
            Text(
                modifier = Modifier.clickable {
                    navController.popBackStack()
                },
                text = stringResource(id = R.string.apply),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}