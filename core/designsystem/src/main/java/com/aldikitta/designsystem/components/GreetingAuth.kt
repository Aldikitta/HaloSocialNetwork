package com.aldikitta.designsystem.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.aldikitta.designsystem.R
import com.aldikitta.designsystem.theme.Size
import com.aldikitta.designsystem.theme.sizes
import com.aldikitta.designsystem.theme.spacing

@Composable
fun GreetingAuth(
    modifier: Modifier = Modifier,
    header: String,
    subHeader: String,
) {
    val size: Size = MaterialTheme.sizes.greetingIcon
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.greeting_halo),
                contentDescription = stringResource(
                    id = R.string.icon_greeting
                ),
                modifier = Modifier
                    .width(size.width)
                    .aspectRatio(size.ratio)
            )

            Text(
                text = header,
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
            Text(
                text = subHeader,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.outline,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.large))
        }
    }
}