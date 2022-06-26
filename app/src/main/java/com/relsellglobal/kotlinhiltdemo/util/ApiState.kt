package com.relsellglobal.kotlinhiltdemo.util

import com.relsellglobal.kotlinhiltdemo.repositories.network.BookListModel

sealed class ApiState {
    class Success(val data:BookListModel) : ApiState()
    class Failure(val msg:Throwable) : ApiState()
    object Loading : ApiState()
    object Empty : ApiState()
}