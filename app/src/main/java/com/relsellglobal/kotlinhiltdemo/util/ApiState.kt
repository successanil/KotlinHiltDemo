package com.relsellglobal.kotlinhiltdemo.util

import com.relsellglobal.modelslib.VolumeInfo


sealed class ApiState {
    class Success(val data:List<VolumeInfo>) : ApiState()
    class Failure(val msg:Throwable) : ApiState()
    object Loading : ApiState()
    object Empty : ApiState()
}