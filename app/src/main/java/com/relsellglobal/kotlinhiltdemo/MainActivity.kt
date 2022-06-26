package com.relsellglobal.kotlinhiltdemo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import com.relsellglobal.kotlinhiltdemo.uicomponents.UIElements
import com.relsellglobal.kotlinhiltdemo.util.ApiState
import com.relsellglobal.kotlinhiltdemo.viewmodels.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var fragmentFactory: DefaultFragmentFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.rootL, fragmentFactory.instantiate(
            classLoader,
            ComposeDemoFrgment::class.java.getName()
        )).commit()

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "$name!")
}


@Composable
fun initialView(mainActivityViewModel: MainActivityViewModel) {
    //UIElements.ScaffoldDemo()
//    GetBooksList(mainActivityViewModel)
}



