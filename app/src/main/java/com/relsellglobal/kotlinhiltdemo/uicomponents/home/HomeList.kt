package com.relsellglobal.kotlinhiltdemo.uicomponents.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import com.relsellglobal.kotlinhiltdemo.uicomponents.DrawerHeader
import com.relsellglobal.kotlinhiltdemo.uicomponents.UIElements
import com.relsellglobal.kotlinhiltdemo.util.ApiState
import com.relsellglobal.kotlinhiltdemo.viewmodels.MainActivityViewModel
import com.relsellglobal.kotlinhiltdemo.R

class HomeList {
    companion object {
        @Composable
        fun GetBooksList(mainActivityViewModel: MainActivityViewModel) {
            when (val result = mainActivityViewModel.response.value) {
                is ApiState.Loading -> {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                    ) {
                        CircularProgressIndicator()
                    }

                }
                is ApiState.Success -> {
                    //print(result.data.items[0])

                    val materialBlue700 = Color(0xFF1976D2)
                    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
                    val colorOne = Color(0xFF20014D)
                    val colorTwo = Color(0xFF24123D)
                    Scaffold(
                        backgroundColor = colorOne,
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
                        drawerContent = {

                            val scrollState = rememberScrollState()
                            val painter = painterResource(id = R.drawable.ic_launcher_background)
                            val description = "Hello painter"
                            val title = "Menu title"
                            Column(
                                modifier = Modifier.verticalScroll(scrollState)
                            ) {
                                DrawerHeader.showHeader(painter = painter, contentDescription = description, title = title)
                                for (i in 1..5) {
                                    UIElements.MenuCard(painter = painter, contentDescription = description, title = title)
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

                        },
                        content = {
                            val scrollState = rememberScrollState()
                            val painter = painterResource(id = R.drawable.ic_launcher_background)
                            val description = "Hello painter"

                            Column(modifier = Modifier
                                .fillMaxWidth()
                                .background(Brush.horizontalGradient(0f to colorOne, 1000f to colorTwo))

                            ) {
                                LazyColumn {
                                    items(result.data) { response ->
                                        // each row (response)
//                        val scrollState = rememberScrollState()
                                        val painter = painterResource(id = R.drawable.ic_launcher_background)
                                        val description = "Hello painter"
                                        val imageUrlThubmnail = response.volumeInfo.imageLinks.smallThumbnail
                                        val title = response.volumeInfo.title
                                        UIElements.ImageCardWithNetworkData(
                                            painter = painter,
                                            contentDescription = description,
                                            imageUrl = imageUrlThubmnail,
                                            title = title
                                        )


                                    }

                                }
                            }


                        },
                        bottomBar = {
//                    BottomAppBar(backgroundColor = materialBlue700) { Text("BottomAppBar") }
                        }
                    )


                }
                is ApiState.Failure -> {
                    Text(text = "${result.msg}")
                }
                is ApiState.Empty -> {

                }
            }
        }
    }
}