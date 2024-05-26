package com.devira.anybuy.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devira.anybuy.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    onForgotPasswordClick: () -> Unit,
    onLoginClick: () -> Unit,
    onNavigateBack: () -> Unit,
    onSignUpClick: () -> Unit
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
        ) {
            NavigateBackButton(onNavigateBack)
            Image(
                painter = painterResource(id = R.drawable.sign_in_png),
                contentDescription = "any buy sign in logo",
                modifier = Modifier
                    .size(270.dp)
                    .align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.padding(16.dp))
        ThemeTextField(email, placeholder = "email address")
        Spacer(modifier = Modifier.padding(8.dp))
        ThemeTextField(password, placeholder = "password", isPassword = true)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(onClick = { onForgotPasswordClick() }) {
                Text(
                    text = "Forgot password?",
                    style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                )
            }
        }
        ThemeRoundedCornerFullWidthButton(label = "log in", onLoginClick)
        Text(
            text = "OR",
            style = TextStyle(color = MaterialTheme.colorScheme.onTertiaryContainer),
            modifier = Modifier.padding(top = 8.dp)
        )
        OutlinedButton(
            onClick = { onLoginClick() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp),
            border = BorderStroke(2.dp, MaterialTheme.colorScheme.tertiaryContainer),
            contentPadding = PaddingValues(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_google),
                    contentDescription = "google icon",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.padding(horizontal = 16.dp))
                Text(
                    text = "continue with google".uppercase(),
                    style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold)
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
                .clickable {
                    onSignUpClick()
                },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = "No account? ".uppercase(),
                style = TextStyle(color = MaterialTheme.colorScheme.onTertiaryContainer)
            )
            Text(
                text = "Sign Up".uppercase(),
                style = TextStyle(color = MaterialTheme.colorScheme.tertiary)
            )
        }
    }
}