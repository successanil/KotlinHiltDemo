package com.relsellglobal.kotlinhiltdemo.uicomponents


import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import com.relsellglobal.kotlinhiltdemo.R
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage


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
        fun ScaffoldNetworkList(title : String) {
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
                    val scrollState = rememberScrollState()
                    val painter = painterResource(id = R.drawable.ic_launcher_background)
                    val description = "Hello painter"

                    Column( modifier = Modifier.verticalScroll(scrollState) ) {
//                        WelcomeCard()
//                        ImageCardWithNetworkData(
//                            painter = painter, contentDescription = description,
//                            title = title
//                        )

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
                    ImageCard(painter = painter, contentDescription = description, title = title)
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
                                        onClick = {  launchCheck() },

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

        @Composable
        fun MenuCard(
            painter: Painter,
            contentDescription: String,
            title: String,
            modifier: Modifier = Modifier
        ) {
            Column(modifier = Modifier.padding(16.dp,5.dp,16.dp,5.dp)) {



                    Row(modifier = Modifier
                        .fillMaxWidth()

                    ) {
                        Column(

                        ) {
                            Column(
                                horizontalAlignment = Alignment.Start,
                            ) {


                                Text("Menu Item", style = TextStyle(color = Color.Black, fontSize = 16.sp))

                            }

                            Spacer(modifier = Modifier.height(5.dp))

                            Row(

                            ) {

                                Column(
                                    modifier = Modifier
                                        .background(Color.LightGray)
                                        .fillMaxWidth()
                                        .height(1.dp)
                                ) {
                                }
                            }
                        }
                    }


            }

        }

        @Composable
        fun ImageCardWithNetworkData(
            painter: Painter,
            contentDescription: String,
            imageUrl:String,
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
                                .height(90.dp)
                                .padding(5.dp)
                        ) {
//                            Image(
//                                modifier = Modifier
//                                    .width(64.dp)
//                                    .clip(RoundedCornerShape(5.dp))
//                                    .fillMaxHeight(),
//                                painter = painter,
//                                contentDescription = contentDescription,
//                                contentScale = ContentScale.Crop
//                            )

                            GlideImage(
                                imageModel = imageUrl,
                                modifier = Modifier
                                    .width(64.dp)
                                    .clip(RoundedCornerShape(5.dp))
                                    .fillMaxHeight(),
                                // Crop, Fit, Inside, FillHeight, FillWidth, None
                                contentScale = ContentScale.Crop,
                                // shows an image with a circular revealed animation.
                                circularReveal = CircularReveal(duration = 250),
                                // shows a placeholder ImageBitmap when loading.
                                //placeHolder = ImageBitmap.imageResource(R.drawable.placeholder),
                                // shows an error ImageBitmap when the request failed.
                                //error = ImageBitmap.imageResource(R.drawable.error)
                            )
                            Box(
                                modifier = Modifier
                                    .width(64.dp),
                                contentAlignment = Alignment.Center
                            ) {
//                                Text(title, style = TextStyle(color = Color.White, fontSize = 12.sp))
                            }
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Column(

                        ) {
                            Column(

                            ) {


                                Text(title, style = TextStyle(color = Color.Black, fontSize = 16.sp))
                                Text("Big Ideas Simply Explained", style = TextStyle(color = Color.Gray, fontSize = 10.sp))
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Row(

                            ) {

                                Column( horizontalAlignment = Alignment.CenterHorizontally) {

                                    Button(
                                        onClick = {  launchCheck() },

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

        private fun launchCheck() {
            Log.v("TAG","launchCheck")
        }

        @Composable
        fun JetpackCompose() {
            Card (modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(Color.White)) {
                var expanded by remember { mutableStateOf(false)}
                Column(Modifier.clickable { },
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally){
                    Image(painterResource(id = R.drawable.ic_launcher_background),"",Modifier.clickable { expanded = !expanded
                    })
                    AnimatedVisibility(visible = expanded) {
                        Text(
                            text = "Anil Kukreti",
                            style= MaterialTheme.typography.h2)
                    }
                }

            }
        }


    }






}

