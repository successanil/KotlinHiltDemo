package com.relsellglobal.kotlinhiltdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.relsellglobal.kotlinhiltdemo.repositories.network.BookListModel
import com.relsellglobal.kotlinhiltdemo.uicomponents.DrawerHeader
import com.relsellglobal.kotlinhiltdemo.uicomponents.UIElements
import com.relsellglobal.kotlinhiltdemo.uicomponents.UIElements.Companion.JetpackCompose
import com.relsellglobal.kotlinhiltdemo.util.ApiState
import com.relsellglobal.kotlinhiltdemo.viewmodels.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ComposeDemoFrgment constructor(val bookListModel: BookListModel) : Fragment() {

//    @Inject
//    lateinit var viewModel : MainActivityViewModel

    val viewModel: MainActivityViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        //return super.onCreateView(inflater, container, savedInstanceState)
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(
                ViewCompositionStrategy.DisposeOnLifecycleDestroyed(viewLifecycleOwner)
            )

            setContent {
                MaterialTheme {
//                    JetpackCompose()
                    GetBooksList(mainActivityViewModel = viewModel)
//                    UIElements.ScaffoldDemo()
                }
            }
        }
    }

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


//                        WelcomeCard()
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