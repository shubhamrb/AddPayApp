package com.shubhamahirwar.addpayapp.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.shubhamahirwar.addpayapp.adapter.NewsDetailAdapter
import com.shubhamahirwar.addpayapp.databinding.ActivityNewsDetailBinding
import com.shubhamahirwar.addpayapp.models.NewsModel
import com.shubhamahirwar.addpayapp.viewModels.activity.NewsDetailViewModel

class NewsDetailActivity : AppCompatActivity() {
    private lateinit var viewModel: NewsDetailViewModel
    private lateinit var binding: ActivityNewsDetailBinding
    private var newsList: List<NewsModel> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[NewsDetailViewModel::class.java]

        val list: ArrayList<NewsModel>? = intent.getParcelableArrayListExtra("newsList")

        var position = intent.getIntExtra("position", -1)

        if (list != null) {
            newsList = list.toList()
        }
        /*top banner*/
        val adapter = NewsDetailAdapter(this, this, newsList)
        binding.newsViewPager.adapter = adapter
        binding.newsViewPager.currentItem = position
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}