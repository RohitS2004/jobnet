package com.example.jobnet.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jobnet.R
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SplashScreen() {
    Scaffold(
        contentWindowInsets = WindowInsets.statusBars
    ) { innerPadding ->

        val systemUiColor = rememberSystemUiController()

        systemUiColor.setStatusBarColor(
            darkIcons = true,
            color = Color.White
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
        ) {
            DotGrid(
                R.drawable.dot_grid
            )
            BottomGraphics(
                painterResource(R.drawable.zig_zag_image),
                painterResource(R.drawable.wavy_image),
                painterResource(R.drawable.nerdy_man_image),
            )
            MainSection {
                println("Button Clicked")
            }
        }
    }

}

@Composable
fun DotGrid(
    @DrawableRes dotGrid: Int
) {
    Box(
        contentAlignment = Alignment.TopStart, modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = dotGrid),
            contentDescription = "Dot Grid",
            modifier = Modifier
                .offset(x = -(20.dp))
        )
    }
}

@Composable
fun BottomGraphics(
    leftGraphic: Painter, // painter is something which can be drawn to the UI
    rightGraphic: Painter, centerNerdyMan: Painter
) {
    Box(
        contentAlignment = Alignment.BottomCenter, modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = leftGraphic,
            contentDescription = "Left Zig Zag Lines",
            modifier = Modifier.offset(
                x = -(LocalConfiguration.current.screenWidthDp.dp / 2),
                y = -(100.dp)
            )
        )

        Image(
            painter = centerNerdyMan, contentDescription = "Nerdy Man"
        )

        Image(
            painter = rightGraphic,
            contentDescription = "Right Curvy Lines",
            modifier = Modifier.offset(
                x = LocalConfiguration.current.screenWidthDp.dp - 210.dp,
                y = -(300.dp)
            )
        )
    }
}

@Composable
fun MainSection(
    projectName: String = "Jobnet",
    mainTagLine: String = "We Help You Find Your Job More Easily",
    subMainTagLine: String = "Find jobs like drinking water from a glass no obstacles just flow into your body",
    buttonText: String = "Get started",
    buttonBackgroundColor: Color = LightGreen,
    onClick: () -> Unit,
) {
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(start = 55.dp, end = 55.dp, top = 75.dp)
        ){
            Text(
                text = projectName,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                modifier = Modifier
                    .padding(bottom = 90.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,

            )

            Text(
                text = mainTagLine,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                textAlign = TextAlign.Center
            )

            Text(
                text = subMainTagLine,
                style = MaterialTheme.typography.labelMedium,
                color = Color.Gray,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 40.dp),
                textAlign = TextAlign.Center
            )

            Button(
                onClick = { onClick() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonBackgroundColor,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = buttonText,
                    style = MaterialTheme.typography.labelMedium,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}