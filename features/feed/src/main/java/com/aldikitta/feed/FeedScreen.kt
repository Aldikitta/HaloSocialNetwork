package com.aldikitta.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Comment
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.aldikitta.designsystem.theme.spacing

@Composable
fun FeedScreen() {
    PostScreenVersion2()
}

@Composable
fun PostScreenVersion2() {
    Card(
        modifier = Modifier.systemBarsPadding()
    ) {
        Box(
            modifier = Modifier.padding(MaterialTheme.spacing.small)
        ) {
            Image(
                modifier = Modifier.clip(MaterialTheme.shapes.extraLarge),
                painter = painterResource(id = R.drawable.post),
                contentDescription = stringResource(id = R.string.profile_picture)
            )
            Row(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(MaterialTheme.spacing.medium)
            ) {
                Image(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(MaterialTheme.spacing.extraLarge),
                    painter = painterResource(id = R.drawable.cat),
                    contentDescription = stringResource(id = R.string.profile_picture),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
                Column {
                    Text(
                        text = "Ruby",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "The Cat", style = MaterialTheme.typography.titleMedium)
                }
            }
//            Column(
//                modifier = Modifier
//                    .align(Alignment.BottomEnd)
//                    .padding(MaterialTheme.spacing.medium),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Icon(
//                    imageVector = Icons.Outlined.Favorite,
//                    contentDescription = stringResource(id = R.string.like)
//                )
//                Text(
//                    modifier = Modifier.padding(MaterialTheme.spacing.small),
//                    text = "1290",
//                    fontWeight = FontWeight.Medium,
//                )
//                Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
//                Icon(
//                    imageVector = Icons.Outlined.Comment,
//                    contentDescription = stringResource(id = R.string.comment)
//                )
//                Text(
//                    modifier = Modifier.padding(MaterialTheme.spacing.small),
//                    text = "111",
//                    fontWeight = FontWeight.Medium,
//                )
//                Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
//                Icon(
//                    imageVector = Icons.Outlined.Send,
//                    contentDescription = stringResource(id = R.string.share)
//                )
//                Text(
//                    modifier = Modifier.padding(MaterialTheme.spacing.small),
//                    text = "100.0k",
//                    fontWeight = FontWeight.Medium,
//                )
//            }
        }
        Row(
            modifier = Modifier
                .padding(MaterialTheme.spacing.medium),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Outlined.Favorite,
                contentDescription = stringResource(id = R.string.like)
            )
            Text(
                modifier = Modifier.padding(MaterialTheme.spacing.small),
                text = "1290",
                fontWeight = FontWeight.Medium,
            )
            Spacer(modifier = Modifier.width(MaterialTheme.spacing.medium))
            Icon(
                imageVector = Icons.Outlined.Comment,
                contentDescription = stringResource(id = R.string.comment)
            )
            Text(
                modifier = Modifier.padding(MaterialTheme.spacing.small),
                text = "111",
                fontWeight = FontWeight.Medium,
            )
            Spacer(modifier = Modifier.width(MaterialTheme.spacing.medium))
            Icon(
                imageVector = Icons.Outlined.Send,
                contentDescription = stringResource(id = R.string.share)
            )
            Text(
                modifier = Modifier.padding(MaterialTheme.spacing.small),
                text = "100.0k",
                fontWeight = FontWeight.Medium,
            )
        }
        Text(
            modifier = Modifier.padding(MaterialTheme.spacing.small),
            text = "Night is where you see stars on the sky, light on the dark, it's so beautiful and all. Anyway this is comment"
        )
    }


}

@Composable
fun PostScreenVersion1() {
    Card(
        modifier = Modifier
            .systemBarsPadding()
            .padding(MaterialTheme.spacing.small),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Row(
            modifier = Modifier
                .padding(MaterialTheme.spacing.small),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(MaterialTheme.spacing.extraLarge),
                painter = painterResource(id = R.drawable.cat),
                contentDescription = stringResource(id = R.string.profile_picture),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
            Column {
                Text(
                    text = "Ruby",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "The Cat", style = MaterialTheme.typography.titleMedium)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.small),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(MaterialTheme.spacing.large)),
                painter = painterResource(id = R.drawable.cat),
                contentDescription = stringResource(id = R.string.profile_picture)
            )
            Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
            Column() {
                Icon(
                    imageVector = Icons.Outlined.Favorite,
                    contentDescription = stringResource(id = R.string.like)
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.large))
                Icon(
                    imageVector = Icons.Outlined.Comment,
                    contentDescription = stringResource(id = R.string.comment)
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.large))
                Icon(
                    imageVector = Icons.Outlined.Send,
                    contentDescription = stringResource(id = R.string.share)
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(MaterialTheme.spacing.small),
                text = "1.333 likes",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
            Text(
                modifier = Modifier.padding(MaterialTheme.spacing.small),
                text = "143 comments",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Text(
            modifier = Modifier.padding(MaterialTheme.spacing.small),
            text = "Night is where you see stars on the sky, light on the dark, it's so beautiful and all. Anyway this is comment"
        )
    }
}



