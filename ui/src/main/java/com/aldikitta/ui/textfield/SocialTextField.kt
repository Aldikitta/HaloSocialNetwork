package com.aldikitta.ui.textfield

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import com.aldikitta.designsystem.theme.spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SocialTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    hint: String = "",
    label: String = "",
    isError: Boolean = false,
    onValueChange: (String) -> Unit,
    leadingIcon: @Composable (() -> Unit)?,
    keyboardType: KeyboardType = KeyboardType.Text,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    errorMessage: String = "",
    maxLength: Int = 20,
    imeAction: ImeAction = ImeAction.Next
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = MaterialTheme.spacing.small),
        value = text,
        onValueChange = {
            if (it.length <= maxLength) {
                onValueChange(it)
            }
        },
        label = {
            Text(text = label)
        },
        isError = isError,
        placeholder = {
            Text(text = hint)
        },
        leadingIcon = leadingIcon,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        singleLine = true,
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation,
        supportingText = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Limit: ${text.length}/20",
                textAlign = TextAlign.End,
            )
        }
    )
    if (isError) {
        Text(
            text = errorMessage,
            color = MaterialTheme.colorScheme.error,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium
        )
    }
    Spacer(modifier = modifier.height(MaterialTheme.spacing.medium))
}