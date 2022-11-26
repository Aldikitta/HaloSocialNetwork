package com.aldikitta.hollahalo.presentation.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SocialTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    hint: String = "",
    label: String = "",
    isError: Boolean = false,
    onValueChange: (String) -> Unit,
    leadingIcon: @Composable() (() -> Unit)?,
    keyboardType: KeyboardType = KeyboardType.Text,
    trailingIcon: @Composable() (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = text,
        onValueChange = onValueChange,
        label = {
            Text(text = label)
        },
        isError = isError,
        placeholder = {
            Text(text = hint)
        },
        leadingIcon = leadingIcon,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        singleLine = true,
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation
    )
}