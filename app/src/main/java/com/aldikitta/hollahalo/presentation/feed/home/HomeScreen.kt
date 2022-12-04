package com.aldikitta.hollahalo.presentation.feed.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController
) {
    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }
    val isFormValid by derivedStateOf {
        username.isNotBlank() && password.length >= 7
    }
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = com.aldikitta.hollahalo.R.drawable.greeting_halo),
            contentDescription = "App Logo",
            modifier = Modifier
                .weight(1f)
                .size(200.dp),
        )
        Box(
            Modifier
                .clip(shape = MaterialTheme.shapes.extraLarge)
                .weight(2f)
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(32.dp)
            ) {
                Text(text = "Welcome Back!", fontWeight = FontWeight.Bold, fontSize = 32.sp)
                Column(
                    Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = username,
                        onValueChange = { username = it },
                        label = { Text(text = "Username") },
                        singleLine = true,
                        trailingIcon = {
                            if (username.isNotBlank())
                                IconButton(onClick = { username = "" }) {
                                    Icon(imageVector = Icons.Filled.Clear, contentDescription = "")
                                }
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = username,
                        onValueChange = { username = it },
                        label = { Text(text = "Username") },
                        singleLine = true,
                        trailingIcon = {
                            if (username.isNotBlank())
                                IconButton(onClick = { username = "" }) {
                                    Icon(imageVector = Icons.Filled.Clear, contentDescription = "")
                                }
                        }
                    )
//                    OutlinedTextField(
//                        modifier = Modifier.fillMaxWidth(),
//                        value = password,
//                        onValueChange = { password = it },
//                        label = { Text(text = "Password") },
//                        singleLine = true,
//                        keyboardOptions = KeyboardOptions(
//                            keyboardType = KeyboardType.Password,
//                            imeAction = ImeAction.Done
//                        ),
//                        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
//                        trailingIcon = {
//                            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
//                                Icon(
//                                    imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
//                                    contentDescription = "Password Toggle"
//                                )
//                            }
//                        }
//                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {},
                        enabled = isFormValid,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(text = "Log In")
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        TextButton(onClick = {}) {
                            Text(text = "Sign Up")
                        }
                        TextButton(onClick = { }) {
                            Text(text = "Forgot Password?", color = Color.Gray)
                        }
                    }
                }
            }
        }
    }
}

