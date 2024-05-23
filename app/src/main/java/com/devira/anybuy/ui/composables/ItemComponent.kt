package com.devira.anybuy.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devira.anybuy.ui.theme.GradientGray
import com.devira.anybuy.ui.theme.LighterGray

@Composable
fun ItemComponent() {
    Column(
        modifier = Modifier
            .width(120.dp)
            .height(170.dp)
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

    }
}

@Preview
@Composable
fun PreviewItemComponent() {
    ItemComponent()
}