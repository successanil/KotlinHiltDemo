package com.relsellglobal.kotlinhiltdemo

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*


class CoroutineDemoActivity : AppCompatActivity() {

    private val a = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.v("TAG","".getFormattedString())

        CoroutineScope(Dispatchers.IO).launch {
            var parentJob = launch {


                    launch {
                        var res = getNetworkResult1()
                        Log.v("TAG", "res is $res")
                    }

            }
            delay(2000)
            Log.v("TAG","Cancelling parent Job")
            parentJob.cancel()
        }




//        CoroutineScope(Dispatchers.IO).launch {
//            var fbDeffered = CoroutineScope(Dispatchers.IO).async {
//                getDataCountFromFB()
//            }
//            Log.v("TAG","fbDeffered result count is "+fbDeffered.await())
//        }



    }

    suspend fun getNetworkResult1() : String{

        var i=0

        while(i < 1000) {
            delay(10)
            i ++
        }
        ////
        return "1133"
    }

    suspend fun makeNetworkCall() {
        getNetworkResult1()
    }

    suspend fun getDataCountFromFB() : Int {
        delay(1000)
        return 1
    }

    suspend fun getDataCountFromInsta() : Int {
        return 1
    }

    fun String.getFormattedString() : String {
        return "I am getting called from extension function for string ${this@CoroutineDemoActivity}"
    }






}