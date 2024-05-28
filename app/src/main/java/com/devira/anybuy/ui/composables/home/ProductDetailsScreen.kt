package com.devira.anybuy.ui.composables.home

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.devira.anybuy.R
import com.devira.anybuy.model.Product
import com.devira.anybuy.ui.MainViewModel
import com.devira.anybuy.ui.composables.utils.NavigateBackButton
import com.devira.anybuy.ui.theme.White
import com.devira.anybuy.ui.theme.Yellow

@Composable
fun ProductDetailsScreen(
    viewModel: MainViewModel,
    onBackClick: () -> Unit,
) {
    val state = viewModel.state.collectAsState()
    BackHandler(enabled = true) { Unit }
    Column {
        header {
            onBackClick()
        }
        body(state.value.selectedProduct)
    }
}

@Composable
private fun body(product: Product?) {
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Box(
                modifier = Modifier
                    .weight(1F)
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                AsyncImage(
                    model = product?.image,
                    contentDescription = "product image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Column(
                modifier = Modifier
                    .weight(1F)
                    .background(MaterialTheme.colorScheme.tertiary)
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Spacer(modifier = Modifier.padding(16.dp))
                Text(
                    text = product?.title ?: "",
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                )
                Spacer(modifier = Modifier.padding(16.dp))
                Text(text = product?.description ?: "")
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
        Box(
            modifier = Modifier
                .padding(end = 16.dp)
                .align(Alignment.CenterEnd)
        ) {
            Card(
                colors = CardDefaults.cardColors(containerColor = Yellow),
                shape = RoundedCornerShape(10.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 24.dp),
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .width(100.dp)
                    .height(60.dp)
                    .shadow(
                        elevation = 24.dp,
                        shape = RoundedCornerShape(10.dp),
                        ambientColor = Color.Black,
                        spotColor = Color.Black
                    )
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "$${product?.price}",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp,
                            color = Color.Black
                        )
                    )
                }
            }
        }
    }
}

@Composable
private fun header(onBackClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Box(modifier = Modifier.padding(16.dp)) {
            NavigateBackButton {
                onBackClick()
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