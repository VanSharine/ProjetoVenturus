package com.example.desafiomarveldh.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.desafiomarveldh.R
import com.example.desafiomarveldh.view.adapter.HomeAdapter
import com.example.desafiomarveldh.databinding.ActivityComicsBinding
import com.example.desafiomarveldh.utils.Constants.ComicsDetail.KEY_INTENT_COMICS_ID
import com.example.desafiomarveldh.viewModel.HomeViewModel



class ComicsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityComicsBinding
    private lateinit var viewModelHome: HomeViewModel


    private val HomeAdapter: HomeAdapter by lazy {
        HomeAdapter { comicsId ->
            val intent = Intent(this@ComicsActivity, DetailsActivity::class.java)
            intent.putExtra(KEY_INTENT_COMICS_ID, comicsId)
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.show()
        supportActionBar?.title = "MARVEL"
        setTheme(R.style.Theme_MaterialComponents_DayNight_DarkActionBar)

        viewModelHome = ViewModelProvider(this).get(HomeViewModel::class.java)

        setUpRecyclerView()
        loadContentComic()
    }

    private fun setUpRecyclerView() {
        binding.rvComicsList.apply {
            layoutManager = GridLayoutManager(this@ComicsActivity, 3)
            adapter = HomeAdapter
        }
    }

    private fun loadContentComic() {
        viewModelHome.homePagedList?.observe(this) { pagedList ->
            HomeAdapter.submitList(pagedList)
        }
    }
}