package com.relsellglobal.kotlinhiltdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.relsellglobal.flowdemoapplication.ui.theme.JetpackComposeDemoTheme
import com.relsellglobal.kotlinhiltdemo.uicomponents.home.HomeList.Companion.GetBooksList
import com.relsellglobal.kotlinhiltdemo.viewmodels.MainActivityViewModel
import com.relsellglobal.modelslib.BookListModel
import dagger.hilt.android.AndroidEntryPoint

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
                JetpackComposeDemoTheme {
//                    JetpackCompose()
                    GetBooksList(mainActivityViewModel = viewModel)
//                    UIElements.ScaffoldDemo()
                    //ScreenMain()
                }
            }
        }
    }


}