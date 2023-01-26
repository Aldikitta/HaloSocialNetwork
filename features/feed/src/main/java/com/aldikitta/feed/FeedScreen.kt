package com.aldikitta.feed

import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.aldikitta.designsystem.theme.spacing

@Composable
fun FeedScreen() {
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
                Text(text = "Ruby", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
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


//        Row(
//            modifier = Modifier
//                .padding(MaterialTheme.spacing.small)
//                .fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Row() {
//                Icon(
//                    imageVector = Icons.Filled.Favorite,
//                    contentDescription = stringResource(id = R.string.like)
//                )
//                Spacer(modifier = Modifier.width(MaterialTheme.spacing.large))
//                Icon(
//                    imageVector = Icons.Outlined.Comment,
//                    contentDescription = stringResource(id = R.string.comment)
//                )
//            }
//            Icon(
//                imageVector = Icons.Outlined.Send,
//                contentDescription = stringResource(id = R.string.share)
//            )
//        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(MaterialTheme.spacing.small),
                text = "1.333 likes "
            )
//            Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
//            Text(text = "•|/")
            Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
            Text(
                modifier = Modifier.padding(MaterialTheme.spacing.small),
                text = "143 comments"
            )
        }


        Text(
            modifier = Modifier.padding(MaterialTheme.spacing.small),
            text = "Night is where you see stars on the sky, light on the dark, it's so beautiful and all. Anyway this is comment"
        )

    }
}


