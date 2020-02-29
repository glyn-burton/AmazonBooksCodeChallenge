package com.example.amazonbookscodechallenge.view.activities.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.amazonbookscodechallenge.R
import com.example.amazonbookscodechallenge.model.amazonResponse.AmazonResult
import com.example.amazonbookscodechallenge.remote.BooksService
import com.example.amazonbookscodechallenge.view.adapters.AmazonAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    val presenterContract = MainActivityPresenter() as MainActivityContract.Presenter
    val adapter by lazy { AmazonAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvHarryPotter.layoutManager = LinearLayoutManager(this)
        rvHarryPotter.adapter = adapter
        requestNewList()
    }

    fun requestNewList()
    {
        val service = BooksService.getBooks()
        var response = ArrayList<AmazonResult>()
        CoroutineScope(Dispatchers.IO).launch {
            val amazonRequest = service.getBookList()
            withContext(Dispatchers.Main) {
                response = amazonRequest.await()
                adapter.addList(response)
            }
        }
    }
}
