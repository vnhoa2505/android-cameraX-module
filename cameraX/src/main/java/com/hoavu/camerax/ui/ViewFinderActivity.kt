package com.hoavu.camerax.ui

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.hoavu.camerax.ui.screen.ViewFinderScreen
import com.hoavu.camerax.ui.theme.CameraXColors
import com.hoavu.camerax.ui.theme.CameraXTheme

class ViewFinderActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        settingEdgeToEdgeUI()

        super.onCreate(savedInstanceState)

        setContent {
            CameraXTheme {
                val scaffoldState = rememberBottomSheetScaffoldState()
                val controller = remember {
                    LifecycleCameraController(applicationContext).apply {
                        setEnabledUseCases(
                            CameraController.IMAGE_CAPTURE or CameraController.VIDEO_CAPTURE
                        )
                    }
                }

                BottomSheetScaffold(
                    scaffoldState = scaffoldState,
                    sheetPeekHeight = 0.dp,
                    sheetContent = {

                    }
                ) { paddingValues ->
                    ViewFinderScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                        controller = controller
                    )
                }
            }
        }
    }

    private fun settingEdgeToEdgeUI() {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                CameraXColors.Transparent.hashCode(),
                CameraXColors.Transparent.hashCode()
            ),
            navigationBarStyle = SystemBarStyle.light(
                CameraXColors.Transparent.hashCode(),
                CameraXColors.Transparent.hashCode()
            )
        )

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }
}