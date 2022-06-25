package com.relsellglobal.kotlinhiltdemo.uicomponents


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class UIElements {

    companion object {
        @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
        @Composable
        fun ScaffoldDemo() {
            val materialBlue700 = Color(0xFF1976D2)
            val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))
            Scaffold(
                scaffoldState = scaffoldState,
                topBar = {
                    TopAppBar(
                        modifier = Modifier
                            .clip(RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp))
                    ) {
                        IconButton(
                            onClick = {
                                //scope.launch { scaffoldState.drawerState.open() }
                            }
                        ) {
                            Icon(Icons.Filled.Menu,"")
                        }
                    }
                },
                floatingActionButtonPosition = FabPosition.End,
                floatingActionButton = {
//                    FloatingActionButton(onClick = {}) {
//                        Text("X")
//                    }
                },
                drawerContent = { Text(text = "drawerContent") },
                content = {
                    Column() {
                        addSearchBox()
                        loadList()
                    }
                },
                bottomBar = {
//                    BottomAppBar(backgroundColor = materialBlue700) { Text("BottomAppBar") }
                }
            )
        }

        @Composable
        fun loadList() {
            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier.verticalScroll(scrollState)
            ) {
                for (i in 1..50) {
                    Text(
                        text = "Item $i",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp)


                    )
                }

            }
        }

        @Composable
        fun addSearchBox() {
            var text by remember { mutableStateOf(TextFieldValue("")) }
            Row {

                TextField(
                    value = text,
                    onValueChange = { newText ->
                        text = newText
                    }
                )

                Button(onClick = { }) {

                }

            }


        }
    }

}

