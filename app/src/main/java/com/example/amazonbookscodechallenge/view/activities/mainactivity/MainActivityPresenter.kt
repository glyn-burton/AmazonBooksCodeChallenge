package com.example.amazonbookscodechallenge.view.activities.mainactivity

import com.example.amazonbookscodechallenge.remote.BooksService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityPresenter() : MainActivityContract.Presenter{
    lateinit var viewContract : MainActivityContract.View

    override fun attatchView(view: MainActivityContract.View) {

    }

    /*override fun requestNewList() {

    }*/


}