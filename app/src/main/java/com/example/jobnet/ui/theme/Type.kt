package com.example.jobnet.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.jobnet.R

val interFontFamily = FontFamily(
    Font(R.font.inter_black, FontWeight.Black),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_semibold, FontWeight.SemiBold),
    Font(R.font.inter_bold, FontWeight.Bold),
    Font(R.font.inter_extrabold, FontWeight.ExtraBold),
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_light, FontWeight.Light),
    Font(R.font.inter_extralight, FontWeight.ExtraLight)
);

val sourceSerifFontFamily = FontFamily(
    Font(R.font.source_serif_regular, FontWeight.Normal),
    Font(R.font.source_serif_black, FontWeight.Black),
    Font(R.font.source_serif_medium, FontWeight.Medium),
    Font(R.font.source_serif_semibold, FontWeight.SemiBold),
    Font(R.font.source_serif_black, FontWeight.Bold),
    Font(R.font.source_serif_extrabold, FontWeight.ExtraBold),
    Font(R.font.source_serif_light, FontWeight.Light),
    Font(R.font.source_serif_extralight, FontWeight.ExtraLight)
)

val typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = sourceSerifFontFamily,
        fontWeight = FontWeight.Black,
        fontSize = 26.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = sourceSerifFontFamily,
        fontWeight = FontWeight.Black,
        fontSize = 24.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    labelSmall = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
    ),
)