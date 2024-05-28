package com.devira.anybuy.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devira.anybuy.R
import com.devira.anybuy.ui.composables.utils.NavigateBackButton

@Composable
fun ProfileScreen(
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.primary),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            NavigateBackButton {
                onBackClick()
            }
            Text(
                text = "About Me",
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                ),
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 8.dp)
            )
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Image(
            painter = painterResource(id = R.drawable.devira_profile),
            contentDescription = "profile pic",
            modifier = Modifier.clip(CircleShape)
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = "Roney Aguiar",
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                fontSize = 28.sp,
                textAlign = TextAlign.Center
            ),
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = "As an experienced Android Software Engineer, I am dedicated to crafting seamless user experiences by leveraging the latest Android technologies. With a strong background in Android app development and a passion for innovation, I thrive on creating, optimizing, and troubleshooting Android applications to meet the highest standards.",
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            ),
        )
    }
}