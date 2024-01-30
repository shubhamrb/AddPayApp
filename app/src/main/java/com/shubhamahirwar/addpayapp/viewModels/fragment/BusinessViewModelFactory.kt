package com.shubhamahirwar.addpayapp.viewModels.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shubhamahirwar.addpayapp.repository.NewsRepository
import javax.inject.Inject

class BusinessViewModelFactory @Inject constructor(private val newsRepository: NewsRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BusinessViewModel(newsRepository) as T
    }
}