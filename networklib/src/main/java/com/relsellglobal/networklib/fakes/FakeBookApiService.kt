package com.relsellglobal.networklib.fakes

import com.relsellglobal.kotlinhiltdemo.repositories.network.BookInfo
import com.relsellglobal.kotlinhiltdemo.repositories.network.BookListModel
import com.relsellglobal.kotlinhiltdemo.repositories.network.ImageLinks
import com.relsellglobal.kotlinhiltdemo.repositories.network.VolumeInfo
import com.relsellglobal.networklib.apiservice.BooksApiService


class FakeBookApiService : BooksApiService {
    override suspend fun getBookListFromApi(query: String): BookListModel {
        var list = mutableListOf<VolumeInfo>()
        var bookInfo = BookInfo(title="Dummy b", publisher= "Dummy publisher", description = "Dummy description", imageLinks
        = ImageLinks(smallThumbnail = "https://cdn-icons-png.flaticon.com/512/4/4325.png"), averageRating = 4)
        var volumeInfo = VolumeInfo(volumeInfo = bookInfo)
        list.add(volumeInfo)

        bookInfo = BookInfo(title="Dummy b", publisher= "Dummy publisher", description = "Dummy description", imageLinks
        = ImageLinks(smallThumbnail = "https://cdn-icons-png.flaticon.com/512/4/4325.png"), averageRating = 4)
        volumeInfo = VolumeInfo(volumeInfo = bookInfo)
        list.add(volumeInfo)

        bookInfo = BookInfo(title="Dummy b", publisher= "Dummy publisher", description = "Dummy description", imageLinks
        = ImageLinks(smallThumbnail = "https://cdn-icons-png.flaticon.com/512/4/4325.png"), averageRating = 4)
        volumeInfo = VolumeInfo(volumeInfo = bookInfo)
        list.add(volumeInfo)

        bookInfo = BookInfo(title="Dummy b", publisher= "Dummy publisher", description = "Dummy description", imageLinks
        = ImageLinks(smallThumbnail = "https://cdn-icons-png.flaticon.com/512/4/4325.png"), averageRating = 4)
        volumeInfo = VolumeInfo(volumeInfo = bookInfo)
        list.add(volumeInfo)

        var fakeBookListModel = BookListModel(items = list as ArrayList<VolumeInfo>)
        return fakeBookListModel
    }

}