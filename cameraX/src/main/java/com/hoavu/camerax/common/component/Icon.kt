package com.hoavu.camerax.common.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.isSpecified
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hoavu.camerax.R
import com.hoavu.camerax.ui.theme.CameraXColors

val LocalIconSize = compositionLocalOf {
    Dp.Unspecified
}

val LocalIconTintColor = compositionLocalOf {
    Color.Unspecified
}

@Composable
fun Icon(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    colorFilter: ColorFilter? = null,
    contentScale: ContentScale = ContentScale.Fit
) {
    val iconSize = LocalIconSize.current
    val contentColor = LocalIconTintColor.current

    Box(
        modifier = Modifier
            .requiredWidthIn(iconSize)
            .requiredHeightIn(iconSize)
            .then(modifier)
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            modifier = Modifier.matchParentSize(),
            colorFilter = colorFilter ?: contentColor
                .takeIf { it.isSpecified }?.let { ColorFilter.tint(it) },
            contentScale = contentScale
        )
    }
}

@Preview
@Composable
internal fun PreviewIcon() {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        CompositionLocalProvider(
            LocalIconTintColor provides CameraXColors.White,
            LocalIconSize provides 40.dp
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_flash_on),
                contentDescription = null
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_flash_off),
                contentDescription = null
            )
        }
    }
}