package com.relsellglobal.kotlinhiltdemo.di

import android.content.Context
import com.relsellglobal.kotlinhiltdemo.BaseApplication
import com.relsellglobal.kotlinhiltdemo.repositories.network.BookInfo
import com.relsellglobal.kotlinhiltdemo.repositories.network.BookListModel
import com.relsellglobal.kotlinhiltdemo.repositories.network.VolumeInfo
import com.relsellglobal.networklib.apiservice.BooksApiService
import com.relsellglobal.networklib.fakes.FakeBookApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app : Context) : BaseApplication {
        return app as BaseApplication
    }



    @Singleton
    @Provides
    fun providesBookModel() : BookListModel {
        var list = ArrayList<VolumeInfo>()
        return BookListModel(list)
    }

    @Singleton
    @Provides
    fun providesBaseUrl () : String {
        return "http://arcane-wildwood-52412.herokuapp.com/books/"
    }

    @Singleton
    @Provides
    fun providesRetrofit(baseUrl : String) : Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun providesBooksApiService(retrofit: Retrofit) : BooksApiService {
//        return retrofit.create(BooksApiService::class.java)
        //return retrofit.create(FakeBookApiService::class.java)
        return FakeBookApiService()
    }

}