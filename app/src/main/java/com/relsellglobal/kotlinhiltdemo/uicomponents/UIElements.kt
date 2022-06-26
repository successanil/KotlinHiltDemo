package com.relsellglobal.kotlinhiltdemo.uicomponents


import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class UIElements {

    companion object {
        @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
        @Composable
        fun ScaffoldDemo() {
            val materialBlue700 = Color(0xFF1976D2)
            val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
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
                            Icon(Icons.Filled.Menu, "")
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
//                        WelcomeCard()
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
            val painter = painterResource(id = com.relsellglobal.kotlinhiltdemo.R.drawable.ic_launcher_background)
            val description = "Hello painter"
            val title = "Book title"

            Column(
                modifier = Modifier.verticalScroll(scrollState)
            ) {
                for (i in 1..50) {
                    ImageCard(painter = painter, contentDescription = description,title=title)
//                    BooksIndividualItemUI()
//                    Text(
//                        text = "Item $i",
//                        fontSize = 24.sp,
//                        fontWeight = FontWeight.Bold,
//                        textAlign = TextAlign.Center,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(vertical = 24.dp)
//
//
//                    )
                }

            }
        }

        @Composable
        fun addSearchBox() {
            var text by remember { mutableStateOf(TextFieldValue("")) }
            Row(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)) {

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    singleLine = true,
                    placeholder = { Text("Enter Search term") },
                    label = { Text("Enter Search term") },
                    value = text,
                    onValueChange = { newText ->
                        text = newText
                    }
                )

                //removedRowLayoutSearchbox()


            }


        }

        @Composable
        private fun removedRowLayoutSearchbox() {
//            Row(modifier = Modifier
//                .weight(1.4f, true)
//                .border(1.dp,Color.Green)
//                .height(60.dp)
//
//            ) {
//
//                OutlinedTextField(
//                    modifier = Modifier
//                        .fillMaxHeight()
//                    ,
//                    shape = RoundedCornerShape(8.dp),
//                    singleLine = true,
//                    placeholder = { Text("Enter Search term") },
//                    label  = { Text("Enter Search term") },
//                    value = text,
//                    onValueChange = { newText ->
//                        text = newText
//                    }
//                )
//
//            }
//
//            Row(modifier = Modifier
//                .height(60.dp)
//                .border(1.dp,Color.Red)
//                .weight(0.6f, true),
//                verticalAlignment = Alignment.CenterVertically
//
//            ) {
//
//                Button(onClick = { },
//                    modifier = Modifier
//                        .fillMaxWidth()) {
//                    Icon(Icons.Filled.Search,"",tint=Color.White)
//                }
//
//            }
        }

        @Composable
        fun WelcomeCard() {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .clickable { },
                elevation = 10.dp
            ) {
                Column(
                    modifier = Modifier.padding(15.dp)
                ) {
                    Text(
                        buildAnnotatedString {
                            append("Welcome to ")
                            withStyle(
                                style = SpanStyle(fontWeight = FontWeight.W900, color = Color(0xFF4552B8))
                            ) {
                                append("Book Search App")
                            }
                        }
                    )
                    Text(
                        buildAnnotatedString {
                            append("You can search ")
                            withStyle(style = SpanStyle(fontWeight = FontWeight.W900)) {
                                append("books")
                            }
                            append(" here")
                        }
                    )
                }
            }
        }

        @Composable
        fun BooksIndividualItemUI() {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .clickable { },
                elevation = 10.dp
            ) {
                Column(
                    modifier = Modifier.padding(15.dp)
                ) {
                    Text(
                        buildAnnotatedString {
                            append("Welcome to ")
                            withStyle(
                                style = SpanStyle(fontWeight = FontWeight.W900, color = Color(0xFF4552B8))
                            ) {
                                append("Book Search App")
                            }
                        }
                    )
                    Text(
                        buildAnnotatedString {
                            append("You can search ")
                            withStyle(style = SpanStyle(fontWeight = FontWeight.W900)) {
                                append("books")
                            }
                            append(" here")
                        }
                    )
                }
            }
        }

        @Composable
        fun ImageCard(
            painter: Painter,
            contentDescription: String,
            title: String,
            modifier: Modifier = Modifier
        ) {
            Column ( modifier = Modifier.padding(16.dp)) {




                Card(
                    modifier = modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(2.dp),
                    elevation = 5.dp
                ) {
                    // when we want to put content stack over each other
                    Box(modifier = Modifier.height(90.dp).padding(5.dp)) {
                        Image(
                            modifier = Modifier
                                .width(64.dp)
                                .clip(RoundedCornerShape(5.dp))
                                .fillMaxHeight(),
                            painter = painter,
                            contentDescription = contentDescription,
                            contentScale = ContentScale.Crop
                        )
                        Box(
                            modifier = Modifier
                                .width(64.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(title, style = TextStyle(color = Color.White, fontSize = 12.sp))
                        }
                    }

                }
            }

        }


    }

}

