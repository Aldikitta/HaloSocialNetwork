package com.aldikitta.ui.alertdialog

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign

@Composable
fun HaloAlertDialog(
    onDismissRequest: () -> Unit,
    onConfirmButton: () -> Unit,
    message: String,
    title: String,
    heroIcon: ImageVector
) {
    AlertDialog(
        onDismissRequest = {
            onDismissRequest()
        },
        icon = {
            Icon(
                heroIcon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        },
        title = {
            Text(text = title)
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