package com.aldikitta.signup.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign

@Composable
fun AlertDialogSuccessSignUp(
    onDismissRequest: () -> Unit,
    onConfirmButton: () -> Unit,
    message: String
) {
    AlertDialog(
        onDismissRequest = {
            onDismissRequest()
        },
        icon = {
            Icon(
                Icons.Filled.Check,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        },
        title = {
            Text(text = "Registered Success")
        },
        text = {
            Text(
                message, textAlign = TextAlign.Center
            )
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmButton()
                }
            ) {
                Text("OK")
            }
        }
    )
}