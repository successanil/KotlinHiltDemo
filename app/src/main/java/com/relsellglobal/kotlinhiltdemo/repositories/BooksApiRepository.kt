package com.relsellglobal.kotlinhiltdemo.repositories

import com.relsellglobal.networklib.apiservice.BooksApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class BooksApiRepository @Inject constructor(
    private val booksApiService: BooksApiService
){
    fun getBooksListFromApi(queryString:String) = flow {
        emit(booksApiService.getBookListFromApi(queryString))
    }.flowOn(Dispatchers.IO)
}