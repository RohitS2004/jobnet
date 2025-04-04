package com.example.jobnet.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jobnet.JobCard
import com.example.jobnet.R
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun HomeScreen() {
    val systemUiColor = rememberSystemUiController()

    systemUiColor.setStatusBarColor(
        darkIcons = true,
        color = Color.White
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 20.dp)
            .windowInsetsPadding(WindowInsets.statusBars)

    ) {
        Header()
        SearchSection()
        MatchJobSection(
            listOf(
                JobCard(
                    companyLogo = painterResource(R.drawable.spotify_logo),
                    companyName = "Spotify",
                    positionName = "Software Engineer",
                    location = "Remote",
                    jobType = "Full Time",
                    jobLevel = "Entry Level"
                ),
                JobCard(
                    companyLogo = painterResource(R.drawable.spotify_logo),
                    companyName = "Spotify",
                    positionName = "Software Engineer",
                    location = "Remote",
                    jobType = "Full Time",
                    jobLevel = "Entry Level"
                ),
            )
        )
    }
}

@Composable
fun Header(
    // name and profile image will be handled from the backend
    name: String = "Rohit",
    profileImage: Painter = painterResource(id = R.drawable.default_profile_image)
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = "Hello, $name",
                style = MaterialTheme.typography.headlineLarge,
                color = Color.Black
            )
            Text(
                text = "Hope you find some good jobs today",
                style = MaterialTheme.typography.labelSmall,
                color = Color.Gray
            )
        }

        Image(
            painter = profileImage,
            contentDescription = "Profile Image",
            modifier = Modifier
                .clip(CircleShape)
                .size(50.dp)
                .border(width = 1.dp, color = Color.Black, shape = CircleShape)
        )
    }
}

@Composable
fun SearchSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier
            .padding(top = 45.dp, bottom = 20.dp, start = 20.dp, end = 20.dp)
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(0.dp)
                .weight(3.5f)
                .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(40.dp))
                .padding(start = 20.dp, end = 7.dp, top = 8.dp, bottom = 8.dp)
        ) {
            BasicTextField(
                value = "",
                onValueChange = {},
                textStyle = TextStyle(
                    color = Color.Black,
                    fontFamily = interFontFamily,
                    fontSize = 13.sp
                ),
                cursorBrush = SolidColor(Color.Black),
            )

            Button(
                onClick = {},
                shape = RoundedCornerShape(40.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green,
                    contentColor = Color.Black
                ),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical =  5.dp),
            ) {
                Text(
                    text = "Search",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 8.dp)
                )
            }
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(CircleShape)
                .size(50.dp)
                .background(Color.Green)
        ) {
            Image(
                painter = painterResource(id = R.drawable.filter),
                contentDescription = "Filter Button",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(20.dp)
            )
        }

    }
}

@Composable
fun MatchJobSection(
    // We will receive the jobs from the backend and then display them here in LazyRow
    jobCards: List<JobCard>
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(vertical = 20.dp, horizontal = 20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Most Match Jobs",
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Text(
                text = "Change interest",
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
        }

        LazyRow (
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            items(jobCards.size) {
                JobCardComp(
                    companyLogo = jobCards[it].companyLogo,
                    companyName = jobCards[it].companyName,
                    positionName = jobCards[it].positionName,
                    location = jobCards[it].location,
                    jobType = jobCards[it].jobType,
                    jobLevel = jobCards[it].jobLevel
                )
            }
        }
    }
}

@Composable
fun JobCardComp(
    companyLogo: Painter,
    companyName: String,
    positionName: String,
    location: String,
    jobType: String,
    jobLevel: String

) {
    Column(
        // The column will be 1f in ratio
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(40.dp))
            .width(300.dp)
            .aspectRatio(1f)
            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(40.dp))
            .padding(20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            ) {
                Image(
                    painter = companyLogo,
                    contentDescription = "Company Logo",
                    modifier = Modifier
                        .clip(CircleShape)
                )
            }

            Box(
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bookmark_icon),
                    contentDescription = "Bookmark icon",
                    modifier = Modifier
                        .size(30.dp)
                )
            }
        }

        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 65.dp)

        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp),
            ) {
                Text(
                    text = companyName,
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.Black
                )
                Text(
                    text = positionName,
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }

            Text(
                text = location,
                style = MaterialTheme.typography.labelMedium,
                color = Color.Gray
            )
        }

        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button (
                onClick = {},
                shape = RoundedCornerShape(40.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ButtonBlack,
                    contentColor = Color.White
                ),
                contentPadding = PaddingValues(horizontal = 20.dp, vertical =  5.dp),
            ) {
                Text(
                    text = jobType,
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Normal,
                )
            }

            Button(
                onClick = {},
                shape = RoundedCornerShape(40.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ButtonBlack,
                    contentColor = Color.White
                ),
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 5.dp)
            ) {
                Text(
                    text = jobLevel,
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}

@Composable
fun RecentlyViewedSection (
    companyName: String,
    companyLogo: Painter,
    positionName: String,
    jobLocation: String,
    jobWorkType: String,
    jobLevel: String
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .clip(RoundedCornerShape(40.dp))
            .width(300.dp)
            .height(100.dp)
            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(40.dp))
            .padding(20.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        ) {
            Image(
                painter = companyLogo,
                contentDescription = "Company name",
                modifier = Modifier
                    .clip(CircleShape)
            )
        }

        Column {

        }
    }
}



@Composable
fun JobCardComponent (
    companyLogo: Painter,
    companyName: String,
    positionName: String,
    jobLocation: String,
    jobWorkType: String,
    jobLevel: String
) {
    Column {

    }
}

// Essentially this will also be a job card but with some different alignments
// So does that mean I have to make the Job Card Component again?
// Or should I just tweak the JobCard component in order to make it reusable?
// But is it worth it to make the job card reusable

// Making JobCard Reusable

// What are all the things that a Job Card takes?
// Company Logo
// Company Name
// Job Position
// Job Location
// Job Work Type
// Job Level

// In the MostMatchJob Section, How many sections are there: 3
// In the RecentlyViewedSection, How many sections are there: 3, But in this case we do not have a bookmark icon
// In both the case width remain the same but the height changes
