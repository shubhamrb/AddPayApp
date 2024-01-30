package com.shubhamahirwar.addpayapp.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shubhamahirwar.addpayapp.R
import com.shubhamahirwar.addpayapp.viewModels.fragment.Category2ViewModel

class Category2Fragment : Fragment() {

    companion object {
        fun newInstance() = Category2Fragment()
    }

    private lateinit var viewModel: Category2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Category2ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}