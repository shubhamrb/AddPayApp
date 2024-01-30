package com.shubhamahirwar.addpayapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shubhamahirwar.addpayapp.R
import com.shubhamahirwar.addpayapp.models.NewsModel

class NewsAdapter(private var context: Context, private var listener: OnItemClickListener) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    private var verticalList: List<NewsModel> = ArrayList()

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val news_img: ImageView = itemView.findViewById(R.id.news_img)
        val txt_news_title: AppCompatTextView = itemView.findViewById(R.id.txt_news_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_layout, parent, false)
        return NewsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = verticalList[position]
        holder.txt_news_title.text = news.title
        Glide.with(context).load(news.urlToImage).into(holder.news_img)

        holder.itemView.setOnClickListener {
            listener.onItemClick(position)
        }
    }

    public interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun getItemCount() = verticalList.size

    fun setList(content: List<NewsModel>) {
        verticalList = content
        notifyDataSetChanged()
    }
}
