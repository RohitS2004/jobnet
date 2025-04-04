package com.example.jobnet

import androidx.compose.ui.graphics.painter.Painter

data class JobCard(
    val companyLogo: Painter,
    val companyName: String,
    val positionName: String,
    val location: String,
    val jobType: String,
    val jobLevel: String
)
