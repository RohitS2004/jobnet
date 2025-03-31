package com.example.jobnet.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.jobnet.R
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun SplashScreen() {
    val systemUiColor = rememberSystemUiController();

    systemUiColor.setStatusBarColor(
        darkIcons = true,
        color = Color.White
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 20.dp)
            .windowInsetsPadding(WindowInsets.statusBars)
    ) {
        DotGrid()
        ProjectName()
        MainSection()
        BottomNerdyMan()
        ZigZagSideIcon()
        WavySideIcon()
    }
}

@Composable
fun DotGrid() {
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.dot_grid),
            contentDescription = "Dot Grid Graphics",
        )
    }
}

@Composable
fun ProjectName(
    name: String = "JOBNET"
) {
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.labelMedium,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 85.dp)
        )
    }
}

@Composable
fun MainSection() {
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 55.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 195.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "We Help You Find Your Job More Easily",
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Find jobs like drink water from a glass no obstacles just flow into your body",
                    color = Color.Gray,
                    style = MaterialTheme.typography.labelSmall,
                    textAlign = TextAlign.Center
                )
            }
            Button(
                onClick = {},
                shape = RoundedCornerShape(40.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green,
                    contentColor = Color.Black
                ),
                modifier = Modifier
                    .padding(vertical = 12.dp, horizontal = 20.dp)
            ) {
                Text(
                    text = "Get Started",
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }

    }
}

@Composable
fun BottomNerdyMan () {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.nerdy_man_image),
            contentDescription = "Nerdy Man"
        )
    }
}

@Composable
fun ZigZagSideIcon () {
    Box(
        contentAlignment = Alignment.BottomStart ,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.zig_zag_image),
            contentDescription = "Zig Zag Lines",
            modifier = Modifier
                .offset(x = (-25).dp, y = (-80).dp)
        )
    }
}

@Composable
fun WavySideIcon () {
    Box (
        contentAlignment = Alignment.BottomEnd,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.wavy_image),
            contentDescription = "Wavy Lines",
            modifier = Modifier
                .offset(x = 25.dp, y = (-280).dp)
        )
    }
}