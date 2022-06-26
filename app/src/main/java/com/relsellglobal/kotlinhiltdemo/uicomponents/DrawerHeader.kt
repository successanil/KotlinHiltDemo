package com.relsellglobal.kotlinhiltdemo.uicomponents

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class DrawerHeader {
    companion object {
        @Composable
        fun showHeader(
            painter: Painter,
            contentDescription: String,
            title: String,
            modifier: Modifier = Modifier
        ) {
            Column(modifier = Modifier.padding(16.dp)) {


                Card(
                    modifier = modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(2.dp),
                    elevation = 5.dp
                ) {
                    Row(modifier = Modifier.fillMaxWidth()) {


                        // when we want to put content stack over each other
                        Box(
                            modifier = Modifier
                                .height(50.dp)
                                .padding(5.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .width(64.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(title, style = TextStyle(color = Color.White, fontSize = 12.sp))
                            }
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Column(

                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {


                                Text("The Business Book", style = TextStyle(color = Color.Black, fontSize = 16.sp))
                                Text("Big Ideas Simply Explained", style = TextStyle(color = Color.Gray, fontSize = 10.sp))
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Row(

                            ) {

                                Column( horizontalAlignment = Alignment.CenterHorizontally) {

                                    Button(
                                        onClick = {

                                        },

//                                        )
                                    ) {
                                        // Inner content including an icon and a text label
                                        Icon(
                                            Icons.Filled.Done,
                                            contentDescription = "Details",
                                            modifier = Modifier.size(ButtonDefaults.IconSize)
                                        )
                                        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                                        Text("Details")
                                    }
                                }
                            }
                        }
                    }

                }
            }

        }
    }
}