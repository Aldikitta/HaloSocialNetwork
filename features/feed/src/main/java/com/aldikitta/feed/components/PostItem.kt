package com.aldikitta.feed.components

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color.parseColor
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Comment
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.palette.graphics.Palette
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.aldikitta.designsystem.theme.spacing
import com.aldikitta.feed.R
import com.aldikitta.model.Post

@Composable
fun PostItem(
    post: Post,
    onCommentClicked: () -> Unit,
//    imageUrl: String,
//    colors: Map<String, String>,

) {
//    var vibrant by remember { mutableStateOf("") }
//    var darkVibrant by remember { mutableStateOf("") }
//    var lightVibrant by remember { mutableStateOf("") }
//    var domainSwatch by remember { mutableStateOf("") }
//    var mutedSwatch by remember { mutableStateOf("") }
//    var lightMutedSwatch by remember { mutableStateOf("") }
//    var darkMutedSwatch by remember { mutableStateOf("") }
//    var onDarkVibrant by remember { mutableStateOf("") }
//
//    val brushColor: List<Color> =
//        listOf(Color(parseColor(vibrant)).copy(alpha = 0.5f), Color.Transparent)
//
//    LaunchedEffect(key1 = true) {
//        vibrant = colors["vibrant"]!!
//        darkVibrant = colors["darkVibrant"]!!
//        lightVibrant = colors["lightVibrant"]!!
//        domainSwatch = colors["domainSwatch"]!!
//        mutedSwatch = colors["mutedSwatch"]!!
//        lightMutedSwatch = colors["lightMuted"]!!
//        darkMutedSwatch = colors["darkMuted"]!!
//        onDarkVibrant = colors["onDarkVibrant"]!!
//    }

    Card(
        modifier = Modifier.systemBarsPadding(),
        colors = CardDefaults.cardColors(
            MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Box(
            modifier = Modifier.padding(MaterialTheme.spacing.small)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(post.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = stringResource(id = R.string.profile_picture),
                modifier = Modifier
                    .clip(MaterialTheme.shapes.extraLarge)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop,
            )
            Row(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(MaterialTheme.spacing.medium)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(post.profilePictureUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = stringResource(id = R.string.profile_picture),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(MaterialTheme.spacing.extraLarge),
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
                modifier = Modifier
                    .padding(MaterialTheme.spacing.small)
                    .clickable {
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