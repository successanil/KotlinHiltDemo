package com.relsellglobal.domainlib.usecases

import com.relsellglobal.domainlib.appinterfaces.IGWeatherDataFetchUseCase
import com.relsellglobal.repositorylib.BooksApiRepository
import javax.inject.Inject

class WeatherDataFetchUseCase @Inject constructor(val booksApiRepository: BooksApiRepository) : IGWeatherDataFetchUseCase {
    override fun getBooksListFromApi(queryString:String) = booksApiRepository.getBooksListFromApi(queryString)

}