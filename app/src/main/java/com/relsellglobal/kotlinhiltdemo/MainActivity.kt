package com.relsellglobal.kotlinhiltdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.relsellglobal.flowdemoapplication.ui.theme.KotlinWeatherDataUI2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinWeatherDataUI2Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    //initialView()
                    loadList()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "$name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KotlinWeatherDataUI2Theme {
        initialView()
    }
}

@Composable
fun initialView() {
    Column {
        Greeting("Anil")
        Greeting("Sunil")

        Row {
            Greeting("Anil")
            Greeting("Sunil")
        }
    }
}

@Composable
fun loadList() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        for(i in 1..50) {
            Text(text="Item $i",
                fontSize=24.sp,
                fontWeight= FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp)


            )
        }

    }
}