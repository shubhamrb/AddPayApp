package com.shubhamahirwar.addpayapp.repository

import com.shubhamahirwar.addpayapp.models.NewsResponse
import com.shubhamahirwar.addpayapp.retrofit.NewsAPI
import com.shubhamahirwar.addpayapp.utils.Constants
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsAPI: NewsAPI) {

    suspend fun getBusinessNews(currentPage: Int): NewsResponse? {
        //https://newsapi.org/v2/top-headlines?apiKey=73aa0fe4cd7f4632bc918fc22093b824&country=in&category=business&page=1&pageSize=1
        val result = newsAPI.getNews(Constants.API_KEY, "in", "business", currentPage, 10)
        return result.body()
    }
}