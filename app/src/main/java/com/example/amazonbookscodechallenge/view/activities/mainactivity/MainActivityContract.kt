package com.example.amazonbookscodechallenge.view.activities.mainactivity

import com.example.amazonbookscodechallenge.model.amazonResponse.AmazonResult

interface MainActivityContract {

    interface View {
        //fun onAddListToRecyclerView(amazonResult: AmazonResult)
    }
    interface Presenter {
        fun attatchView(view : MainActivityContract.View)
        //fun requestNewList()
    }
}