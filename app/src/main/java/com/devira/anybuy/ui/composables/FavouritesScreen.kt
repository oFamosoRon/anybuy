package com.devira.anybuy.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devira.anybuy.R

@Composable
fun FavouritesScreen(
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
                text = "Favourites",
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
        Image(
            painter = painterResource(id = R.drawable.logo_variant_3),
            contentDescription = "logo",
            modifier = Modifier.size(200.dp)
        )
        Text(
            text = "You haven't added anything yet...",
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                fontSize = 28.sp,
                textAlign = TextAlign.Center
            ),
        )
        Spacer(modifier = Modifier.padding(32.dp))
        Text(
            text = "Let's find your favourite items",
            style = TextStyle(color = MaterialTheme.colorScheme.onPrimary)
        )
        Spacer(modifier = Modifier.padding(32.dp))
        ThemeRoundedCornerFullWidthButton(label = "Order") {
            onBackClick()
        }
    }
}