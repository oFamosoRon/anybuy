package com.devira.anybuy.ui.composables.productsList

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.devira.anybuy.ui.theme.GradientGray
import com.devira.anybuy.ui.theme.LighterGray

@Composable
fun ItemPlaceHolder() {
    val transition = rememberInfiniteTransition(label = "")
    val translateAnimation = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )

    val shimmerBrush = Brush.linearGradient(
        colors = listOf(
            LighterGray.copy(alpha = 0.9f),
            LighterGray.copy(alpha = 0.3f),
            LighterGray.copy(alpha = 0.9f)
        ),
        start = Offset(translateAnimation.value, 0f),
        end = Offset(translateAnimation.value + 200f, 0f)
    )

    Column(
        modifier = Modifier
            .width(120.dp)
            .height(190.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        LighterGray,
                        GradientGray
                    )
                )
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(shimmerBrush)
        )
    }
}