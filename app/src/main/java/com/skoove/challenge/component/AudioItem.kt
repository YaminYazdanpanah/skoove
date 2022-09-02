package com.skoove.challenge.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.skoove.challenge.domain.audio.result.Audio
import com.skoove.challenge.ui.theme.appTypography
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage
import com.skoove.challenge.R

/**
 * Audio item
 *
 * @param audio
 */
@Composable
fun AudioItem(audio: Audio) {

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .border(1.dp, MaterialTheme.colors.onBackground)
            .background(MaterialTheme.colors.surface)
    ) {
        // audio cover image
        CoilImage(
            imageModel = audio.cover,
            contentDescription = stringResource(id = R.string.contentDescription_audio_cover),
            shimmerParams = ShimmerParams(
                baseColor = MaterialTheme.colors.background,
                highlightColor = MaterialTheme.colors.surface
            ),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .aspectRatio(3f / 2f)
                .fillMaxWidth()
        )
        // title section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(64.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .wrapContentWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.appTypography.body1,
                text = audio.title.toString(),
                color = MaterialTheme.colors.onSurface
            )
        }
    }

}