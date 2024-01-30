package com.shubhamahirwar.addpayapp.ui.fragment

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.shubhamahirwar.addpayapp.databinding.FragmentNewsDetailBinding
import com.shubhamahirwar.addpayapp.models.NewsModel
import com.shubhamahirwar.addpayapp.viewModels.activity.NewsDetailViewModel

class NewsDetailFragment : Fragment() {

    companion object {
        fun newInstance(position: Int, model: NewsModel): NewsDetailFragment {
            val fragment = NewsDetailFragment()
            val args = Bundle()
            args.putInt("position", position)
            args.putParcelable("newsModel", model)
            fragment.arguments = args
            return fragment
        }
    }

    private var newsModel: NewsModel? = null

    private lateinit var viewModel: NewsDetailViewModel

    private lateinit var binding: FragmentNewsDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsDetailBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(
            this
        )[NewsDetailViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val position = it.getInt("position")
            newsModel = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.getParcelable("newsModel", NewsModel::class.java)
            } else {
                it.getParcelable("newsModel")
            }
        }
        newsModel?.let {
            Glide.with(requireContext()).load(it.urlToImage).into(binding.newsImg)
            binding.txtNewsTitle.text = it.title
            binding.txtNewsDesc.text = it.description
        }


        binding.btnReadMore.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(newsModel!!.url))
            startActivity(intent)
        }
    }
}