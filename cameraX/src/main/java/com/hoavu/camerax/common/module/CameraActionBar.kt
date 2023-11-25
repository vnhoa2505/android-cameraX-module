package com.hoavu.camerax.common.module

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hoavu.camerax.R
import com.hoavu.camerax.common.component.Icon
import com.hoavu.camerax.common.component.IconButton
import com.hoavu.camerax.common.component.IconButtonSize
import com.hoavu.camerax.ui.theme.CameraXColors

@Composable
fun CameraXActionBar(
    onToggleFlashClick: () -> Unit,
    onToggleCaptureClick: () -> Unit,
    onSwitchCameraClick: () -> Unit,
    modifier: Modifier = Modifier,
    itemSpacedBy: Dp = 60.dp
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(itemSpacedBy)
    ) {
        IconButton(
            onClick = onToggleFlashClick,
            iconColor = CameraXColors.White,
            size = IconButtonSize.Small
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_flash_on),
                contentDescription = null,
            )
        }

        IconButton(
            onClick = onToggleCaptureClick,
            iconColor = Color.Unspecified,
            size = IconButtonSize.Huge
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_capture),
                contentDescription = null
            )
        }

        IconButton(
            onClick = onSwitchCameraClick,
            iconColor = CameraXColors.White,
            size = IconButtonSize.Small
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_flip),
                contentDescription = null,
            )
        }
    }
}

@Preview
@Composable
internal fun PreviewCameraXActionBar() {
    CameraXActionBar(
        onToggleFlashClick = { },
        onToggleCaptureClick = { },
        onSwitchCameraClick = { }
    )
}