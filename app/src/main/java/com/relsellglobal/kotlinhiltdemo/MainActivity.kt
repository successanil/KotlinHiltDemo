package com.relsellglobal.kotlinhiltdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.relsellglobal.flowdemoapplication.ui.theme.KotlinWeatherDataUI2Theme
import com.relsellglobal.kotlinhiltdemo.uicomponents.UIElements

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    initialView()

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "$name!")
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    KotlinWeatherDataUI2Theme {
//        initialView()
//    }
//}

@Composable
fun initialView() {
    UIElements.ScaffoldDemo()
}

