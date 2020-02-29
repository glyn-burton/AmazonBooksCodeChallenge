package com.example.amazonbookscodechallenge.remote

import com.example.amazonbookscodechallenge.model.amazonResponse.AmazonResult
import com.examples.coding.rxjavademo.datasource.remote.retrofit.RetrofitHelper
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface BooksService{

    companion object{
        fun getBooks() =
            RetrofitHelper.retrofitInstance.create(BooksService::class.java)
    }


    @GET("books.json")
    fun getBookList()
            : Deferred<ArrayList<AmazonResult>>

}
