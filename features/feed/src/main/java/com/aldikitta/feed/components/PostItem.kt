package com.aldikitta.feed.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Comment
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.aldikitta.designsystem.theme.spacing
import com.aldikitta.feed.R
import com.aldikitta.model.Post

@Composable
fun PostItem(
    post: Post,
    onCommentClicked: () -> Unit
) {
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
                        text = post.username,
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
                text = post.likeCount.toString(),
                fontWeight = FontWeight.Medium,
            )
            Spacer(modifier = Modifier.width(MaterialTheme.spacing.medium))
            Icon(
                imageVector = Icons.Outlined.Comment,
                contentDescription = stringResource(id = R.string.comment)
            )
            Text(
                modifier = Modifier.padding(MaterialTheme.spacing.small).clickable {
                    onCommentClicked()
                },
                text = post.commentCount.toString(),
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
            text = post.description
        )
    }
}

//text = "Night is where you see stars on the sky, light on the dark, it's so beautiful and all. Anyway this is comment"
