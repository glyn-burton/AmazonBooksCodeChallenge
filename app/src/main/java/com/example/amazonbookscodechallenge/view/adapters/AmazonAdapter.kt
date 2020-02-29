package com.example.amazonbookscodechallenge.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.amazonbookscodechallenge.R
import com.example.amazonbookscodechallenge.model.amazonResponse.AmazonResult
import kotlinx.android.synthetic.main.harry_potter_item.view.*

class AmazonAdapter : RecyclerView.Adapter<AmazonAdapter.ViewHolder>() {
    var bookList = ArrayList<AmazonResult>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.harry_potter_item, parent, false))


    override fun getItemCount() = bookList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int)  =
        holder.populateJoke(bookList[position])

    fun addList(list : ArrayList<AmazonResult>)
    {
        bookList = list
        notifyDataSetChanged()
    }


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun populateJoke(amazonResult: AmazonResult) {
            itemView.tvBookTitle.text = amazonResult.title
            itemView.tvAuthor.text = amazonResult.author
            if (amazonResult.imageURL != null) {
                val url = amazonResult.imageURL.replace("http", "https")
                Glide
                    .with(itemView)
                    .load(url)
                    .into(itemView.imItemCover)
            }
        }
        }


    }