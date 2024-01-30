package com.shubhamahirwar.addpayapp.viewModels.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shubhamahirwar.addpayapp.models.NewsModel
import com.shubhamahirwar.addpayapp.repository.NewsRepository
import kotlinx.coroutines.launch

class BusinessViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    private val _newsList = MutableLiveData<List<NewsModel>>()
    val newsList: LiveData<List<NewsModel>> get() = _newsList

    private var currentPage = 1
    private var isFetching = false

    fun getNews() {
        if (!isFetching) {
            isFetching = true
            viewModelScope.launch {
                val response = newsRepository.getBusinessNews(currentPage)

                response?.let {
                    if (response.status == "ok") {
                        val newList = _newsList.value.orEmpty().toMutableList()
                        newList.addAll(response.articles)
                        _newsList.value = newList
                        currentPage++
                    }
                    isFetching = false

                }
            }
        }
    }
}