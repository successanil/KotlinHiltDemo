package com.relsellglobal.domainlib.appinterfaces

import com.relsellglobal.modelslib.BookListModel
import kotlinx.coroutines.flow.Flow

interface IGWeatherDataFetchUseCase {
    fun getBooksListFromApi(queryString:String) : Flow<BookListModel>
}