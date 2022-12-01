//package com.aldikitta.hollahalo.presentation.auth.register
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Password
//import androidx.compose.material.icons.filled.Person
//import androidx.compose.material.icons.filled.Visibility
//import androidx.compose.material.icons.filled.VisibilityOff
//import androidx.compose.material.icons.outlined.Cancel
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.text.input.VisualTransformation
//import androidx.compose.ui.unit.dp
//import androidx.hilt.navigation.compose.hiltViewModel
//import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
//import androidx.lifecycle.compose.collectAsStateWithLifecycle
//import androidx.navigation.NavController
//import com.aldikitta.hollahalo.R
//import com.aldikitta.hollahalo.presentation.auth.composable.GreetingAuth
//import com.aldikitta.hollahalo.presentation.auth.composable.SocialTextField
//import com.aldikitta.hollahalo.presentation.auth.login.LoginUiEvent
//import com.aldikitta.hollahalo.presentation.auth.login.LoginViewModel
//import com.aldikitta.hollahalo.presentation.ui.theme.spacing
//
//@OptIn(ExperimentalLifecycleComposeApi::class)
//@Composable
//fun RegisterScreen(
//    navController: NavController,
//    registerViewModel: RegisterViewModel = hiltViewModel()
//) {
//    val registerUiState by registerViewModel.registerUiState.collectAsStateWithLifecycle()
//
//    Box(
//        modifier = Modifier.fillMaxSize(),
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(horizontal = MaterialTheme.spacing.small),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            GreetingAuth(
//                header = stringResource(id = R.string.welcome),
//                subHeader = stringResource(id = R.string.your_new_here),
//            )
//            SocialTextField(
//                text = registerUiState.usernameText,
//                onValueChange = { username ->
//                    registerViewModel.onEvent(RegisterUiEvent.UsernameInputText(username))
//                },
//                hint = stringResource(id = R.string.enter_username),
//                label = stringResource(id = R.string.username),
//                leadingIcon = {
//                    Icon(
//                        imageVector = Icons.Filled.Person,
//                        contentDescription = stringResource(id = R.string.username)
//                    )
//                },
//                keyboardType = KeyboardType.Email,
//                isError = !registerUiState.validateUsername,
//                errorMessage = stringResource(id = R.string.validate_username),
//                trailingIcon = {
//                    if (registerUiState.usernameText.isNotEmpty()) {
//                        IconButton(onClick = { registerViewModel.onEvent(RegisterUiEvent.EmptyFieldUsername) }) {
//                            Icon(
//                                imageVector = Icons.Outlined.Cancel,
//                                contentDescription = stringResource(R.string.empty_username_field)
//                            )
//                        }
//                    }
//                }
//            )
//
//            SocialTextField(
//                text = registerUiState.passwordText,
//                onValueChange = { password ->
//                    registerViewModel.onEvent(RegisterUiEvent.PasswordInputText(password))
//                },
//                hint = stringResource(id = R.string.enter_password),
//                label = stringResource(id = R.string.password),
//                leadingIcon = {
//                    Icon(
//                        imageVector = Icons.Filled.Password,
//                        contentDescription = stringResource(id = R.string.password)
//                    )
//                },
//                keyboardType = KeyboardType.Password,
//                trailingIcon = {
//                    Row {
//                        if (registerUiState.passwordText.isNotEmpty()) {
//                            IconButton(onClick = { registerViewModel.onEvent(RegisterUiEvent.EmptyFieldPassword) }) {
//                                Icon(
//                                    imageVector = Icons.Outlined.Cancel,
//                                    contentDescription = stringResource(R.string.empty_password_field)
//                                )
//                            }
//                        }
//                        IconButton(onClick = {
//                            registerViewModel.onEvent(RegisterUiEvent.ToggleVisibilityClick(registerUiState.toggleVisibility))
//                        }) {
//                            Icon(
//                                imageVector = if (registerUiState.toggleVisibility) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
//                                contentDescription = ""
//                            )
//                        }
//                    }
//                },
//                visualTransformation = if (registerUiState.toggleVisibility) VisualTransformation.None else PasswordVisualTransformation(),
//                isError = !registerUiState.validatePassword,
//                errorMessage = stringResource(id = R.string.validate_password)
//            )
//            Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
//            Button(
//                onClick = {
//                    registerViewModel.onEvent(
//                        RegisterUiEvent.ValidateForm(
//                            username = registerUiState.usernameText,
//                            password = registerUiState.passwordText
//                        )
//                    )
//                }) {
//                Text(text = stringResource(id = R.string.take_me_in))
//            }
//            Spacer(modifier = Modifier.height(MaterialTheme.spacing.large))
//            Text(
//                text = stringResource(id = R.string.or_continue_with),
//                fontWeight = FontWeight.SemiBold,
//                style = MaterialTheme.typography.titleMedium,
//                color = MaterialTheme.colorScheme.outline
//            )
//            Spacer(modifier = Modifier.height(MaterialTheme.spacing.large))
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//            ) {
//                OutlinedButton(
//                    onClick = { /*TODO*/ },
//                    modifier = Modifier
//                        .weight(1f)
//                        .padding(MaterialTheme.spacing.extraSmall)
//                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.google),
//                        contentDescription = stringResource(
//                            id = R.string.google_signIn
//                        ),
//                        modifier = Modifier.size(30.dp)
//                    )
//                    Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
//                    Text(
//                        text = stringResource(id = R.string.google_signIn),
//                    )
//                }
//                OutlinedButton(
//                    onClick = { /*TODO*/ },
//                    modifier = Modifier
//                        .weight(1f)
//                        .padding(MaterialTheme.spacing.extraSmall)
//                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.facebook),
//                        contentDescription = stringResource(
//                            id = R.string.facebook_signIn
//                        ),
//                        modifier = Modifier.size(30.dp)
//                    )
//                    Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
//                    Text(
//                        text = stringResource(id = R.string.facebook_signIn),
//                    )
//                }
//            }
//        }
//        Row(
//            modifier = Modifier
//                .padding(MaterialTheme.spacing.medium)
//                .align(Alignment.BottomCenter)
//
//        ) {
//            Text(text = stringResource(id = R.string.new_here))
//            Text(
//                modifier = Modifier.clickable { },
//                text = stringResource(id = R.string.apply),
//                color = MaterialTheme.colorScheme.primary
//            )
//        }
//    }
//}