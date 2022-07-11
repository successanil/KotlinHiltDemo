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
import com.relsellglobal.kotlinhiltdemo.uicomponents.home.HomeList.Companion.GetBooksList
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


}