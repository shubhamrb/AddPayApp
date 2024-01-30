package com.shubhamahirwar.addpayapp.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.shubhamahirwar.addpayapp.models.NewsModel
import com.shubhamahirwar.addpayapp.ui.fragment.NewsDetailFragment

class NewsDetailAdapter(
    context: Context,
    fragmentActivity: FragmentActivity,
    private var newsList: List<NewsModel>
) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun createFragment(position: Int): Fragment {
        return NewsDetailFragment.newInstance(position, newsList[position])
    }
}