package com.devira.anybuy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.devira.anybuy.ui.theme.AnybuyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnybuyTheme {

            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AnybuyTheme {
       
    }
}