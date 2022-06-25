package com.relsellglobal.kotlinhiltdemo.repositories.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {
    @GET("booksVolumeListForBusiness")
    fun getBookListFromApi(@Query("q") query: String): Observable<BookListModel>
}