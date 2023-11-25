package com.hoavu.camerax.common.component

import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hoavu.camerax.R
import com.hoavu.camerax.ui.theme.CameraXColors

enum class IconButtonSize {
    Small, Normal, Huge
}

object IconButtonDefault {
    val Shape = CircleShape

    object Size {
        val Small = 30.dp
        val Normal = 50.dp
        val Huge = 70.dp
    }

    object IconSize {
        val Small = 30.dp
        val Normal = 50.dp
        val Huge = 70.dp
    }
}

@Composable
fun IconButton(
    onClick: () -> Unit,
    iconColor: Color,
    modifier: Modifier = Modifier,
    size: IconButtonSize = IconButtonSize.Normal,
    interactionSource: MutableInteractionSource = remember {
        MutableInteractionSource()
    },
    indication: Indication? = null,
    shape: Shape = IconButtonDefault.Shape,
    backgroundColor: Color = CameraXColors.Transparent,
    icon: @Composable () -> Unit
) {
    val sizeDp = when (size) {
        IconButtonSize.Small -> {
            IconButtonDefault.Size.Small
        }

        IconButtonSize.Normal -> {
            IconButtonDefault.Size.Normal
        }

        IconButtonSize.Huge -> {
            IconButtonDefault.Size.Huge
        }
    }

    val iconSize = when (size) {
        IconButtonSize.Small -> {
            IconButtonDefault.IconSize.Small
        }

        IconButtonSize.Normal -> {
            IconButtonDefault.IconSize.Normal
        }

        IconButtonSize.Huge -> {
            IconButtonDefault.IconSize.Huge
        }
    }

    BoxWithConstraints(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .requiredHeightIn(sizeDp)
            .requiredWidthIn(sizeDp)
            .clip(shape)
            .clickable(
                onClick = onClick,
                role = Role.Button,
                interactionSource = interactionSource,
                indication = indication
            )
            .background(
                color = backgroundColor,
                shape = shape
            )
    ) {
        CompositionLocalProvider(
            LocalIconSize provides iconSize,
            LocalIconTintColor provides iconColor
        ) {
            icon()
        }
    }
}

@Preview
@Composable
internal fun PreViewIconButton() {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(
            onClick = { },
            iconColor = CameraXColors.White
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_flip),
                contentDescription = null,
            )
        }

        IconButton(
            onClick = {  },
            iconColor = CameraXColors.White,
            size = IconButtonSize.Huge
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_capture),
                contentDescription = null
            )
        }

        IconButton(
            onClick = {  },
            iconColor = Color.Unspecified,
            size = IconButtonSize.Huge
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_recording),
                contentDescription = null
            )
        }
    }
}