package com.devira.anybuy.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devira.anybuy.R
import com.devira.anybuy.ui.composables.utils.NavigateBackButton
import com.devira.anybuy.ui.composables.utils.ThemeRoundedCornerFullWidthButton
import com.devira.anybuy.ui.composables.utils.ThemeTextField

@Composable
fun SignUpScreen(
    onNavigateBackClick: () -> Unit,
    onRegisterClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            NavigateBackButton { onNavigateBackClick() }
            Image(
                painterResource(id = R.drawable.logo_variant_3),
                contentDescription = "logo",
                modifier = Modifier
                    .align(
                        Alignment.TopCenter
                    )
                    .size(70.dp)
            )
        }
        Spacer(modifier = Modifier.padding(32.dp))
        Text(
            text = "sign up".uppercase(),
            style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 22.sp)
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Text(text = "Please, fill in the details")
        Spacer(modifier = Modifier.padding(16.dp))
        ThemeTextField(initialState = "", placeholder = "email")
        Spacer(modifier = Modifier.padding(8.dp))
        ThemeTextField(initialState = "", placeholder = "password", isPassword = true)
        Spacer(modifier = Modifier.padding(8.dp))
        ThemeTextField(initialState = "", placeholder = "phone number")
        Spacer(modifier = Modifier.padding(16.dp))
        ThemeRoundedCornerFullWidthButton(label = "register now") {
            onRegisterClick()
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "having issues? ",
                style = TextStyle(color = MaterialTheme.colorScheme.onTertiaryContainer)
            )
            Text(
                text = "Contact customer service",
                style = TextStyle(color = MaterialTheme.colorScheme.tertiary)
            )
        }
    }
}