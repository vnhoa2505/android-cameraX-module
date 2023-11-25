package com.hoavu.camerax.ui.screen

import androidx.camera.core.CameraSelector
import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hoavu.camerax.common.component.CameraPreview
import com.hoavu.camerax.common.module.CameraXActionBar

@Composable
fun ViewFinderScreen(
    controller: LifecycleCameraController,
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues(
        start = 0.dp,
        end = 0.dp,
        top = 16.dp,
        bottom = 80.dp
    )
) {
    Box(modifier = modifier) {
        CameraPreview(
            modifier = Modifier.fillMaxSize(),
            controller = controller
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(paddingValues),
            horizontalArrangement = Arrangement.Center
        ) {
            CameraXActionBar(
                onToggleFlashClick = {
                    toggleFlash(controller = controller)
                },
                onToggleCaptureClick = {

                },
                onSwitchCameraClick = {
                    switchCamera(controller = controller)
                }
            )
        }
    }
}

private fun toggleFlash(controller: LifecycleCameraController) {
    controller.cameraInfo?.apply {
        if (hasFlashUnit()) {
            torchState.value?.let {
                controller.cameraControl?.enableTorch(it == 0)
            }
        }
    }
}

private fun switchCamera(controller: LifecycleCameraController) {
    controller.cameraSelector =
        if (controller.cameraSelector == CameraSelector.DEFAULT_BACK_CAMERA) {
            CameraSelector.DEFAULT_FRONT_CAMERA
        } else CameraSelector.DEFAULT_BACK_CAMERA
}