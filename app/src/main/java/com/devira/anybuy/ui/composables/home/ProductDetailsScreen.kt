package com.devira.anybuy.ui.composables.home

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devira.anybuy.R
import com.devira.anybuy.ui.composables.NavigateBackButton
import com.devira.anybuy.ui.theme.White
import com.devira.anybuy.ui.theme.Yellow

@Composable
fun ProductDetailsScreen(
    onBackClick: () -> Unit,
) {
    BackHandler(enabled = true) { Unit }
    Column {
        header()
        body()
    }

}

@Composable
private fun body() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .width(100.dp)
                    .height(60.dp)
                    .background(Yellow)
                    .align(Alignment.BottomEnd)
            ) {

            }
        }
        Column(
            modifier = Modifier
                .weight(1F)
                .background(MaterialTheme.colorScheme.tertiary)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Nintendo switch",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )
            Spacer(modifier = Modifier.padding(16.dp))
            Text(text = "height")
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Buy now".uppercase(), style = TextStyle(color = White))
            }
        }
    }
}

@Composable
private fun header() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Box(modifier = Modifier.padding(16.dp)) {
            NavigateBackButton {

            }
        }
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(bottomStart = 20.dp))
                .width(70.dp)
                .height(100.dp)
                .background(MaterialTheme.colorScheme.surface)
                .align(Alignment.TopEnd),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.heart),
                contentDescription = "HEART ICON",
                tint = White,
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ProductDetailsScreenPreview() {
    ProductDetailsScreen {

    }
}