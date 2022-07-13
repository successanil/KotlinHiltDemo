package com.relsellglobal.kotlinhiltdemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.relsellglobal.jpcloginmod.LoginActivity
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

//        var t = TestClass()
//        t.createThread()

        startActivity(Intent(this@MainActivity, LoginActivity::class.java))





//        supportFragmentManager.beginTransaction().replace(R.id.rootL, fragmentFactory.instantiate(
//            classLoader,
//            ComposeDemoFrgment::class.java.getName()
//        )).commit()

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



