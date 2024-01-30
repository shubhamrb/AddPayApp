package com.shubhamahirwar.addpayapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shubhamahirwar.addpayapp.adapter.NewsAdapter
import com.shubhamahirwar.addpayapp.databinding.FragmentBussinessBinding
import com.shubhamahirwar.addpayapp.di.BusinessComponent
import com.shubhamahirwar.addpayapp.di.DaggerBusinessComponent
import com.shubhamahirwar.addpayapp.models.NewsModel
import com.shubhamahirwar.addpayapp.ui.activity.NewsDetailActivity
import com.shubhamahirwar.addpayapp.viewModels.fragment.BusinessViewModel
import com.shubhamahirwar.addpayapp.viewModels.fragment.BusinessViewModelFactory
import javax.inject.Inject

class BusinessFragment : Fragment(), NewsAdapter.OnItemClickListener {

    companion object {
        fun newInstance() = BusinessFragment()
    }

    private lateinit var verticalAdapter: NewsAdapter
    private lateinit var businessComponent: BusinessComponent
    private var list: List<NewsModel> = arrayListOf()
    private lateinit var viewModel: BusinessViewModel

    @Inject
    lateinit var businessViewModelFactory: BusinessViewModelFactory

    private lateinit var binding: FragmentBussinessBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBussinessBinding.inflate(inflater, container, false)
        businessComponent = DaggerBusinessComponent.builder().build()
        businessComponent.inject(this)

        viewModel = ViewModelProvider(
            this,
            businessViewModelFactory
        )[BusinessViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        context?.let {
            viewModel.newsList.observe(viewLifecycleOwner, Observer {
                list = it
                verticalAdapter.setList(list)
            })

            setUpNewsRecycler()
            viewModel.getNews()
        }
    }

    private fun setUpNewsRecycler() {
        context?.let {
            verticalAdapter = NewsAdapter(it, this)
            binding.newsRecycler.layoutManager =
                LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            binding.newsRecycler.adapter = verticalAdapter
        }

        binding.newsRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

                if (visibleItemCount + firstVisibleItemPosition >= totalItemCount - 5) {
                    viewModel.getNews()
                }
            }
        })

    }

    override fun onItemClick(position: Int) {
        var intent = Intent(context, NewsDetailActivity::class.java)
        intent.putExtra("position", position)
        intent.putParcelableArrayListExtra("newsList", ArrayList(list))
        startActivity(intent)
    }
}