package com.example.desafiomarveldh.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.desafiomarveldh.R
import com.example.desafiomarveldh.databinding.ActivityDetailsBinding
import com.example.desafiomarveldh.model.Result
import com.example.desafiomarveldh.utils.Constants.ComicsDetail.KEY_INTENT_COMICS_ID

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
   // private var comic: Result? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        var comicsId = intent.getParcelableExtra<Result>(KEY_INTENT_COMICS_ID)

        comicsId?.images?.forEach {
            Glide.with(this).load(it?.path)
                .placeholder(R.drawable.notfound_big)
                .into(binding.ivHero)
        }

        Glide.with(this).load(comicsId?.thumbnail?.path)
            .placeholder(R.drawable.notfound)
            .into(binding.ivPoster)

        binding.tvTitle.text = comicsId?.title

        binding.tvDetails.text = comicsId?.description ?: "" +
                 "Nenhuma descrição encontrada!\n" +
                "Descrição Padrão:\n" +
                "Looking for the one superhero comic you just have to read? You've found it! Amazing Spider-Man is the cornerstone" +
                " of the Marvel Universe. This is where you'll find all the big-time action, major storylines and iconic Spider-Man" +
                " magic you'd come to expect from the Wall-Crawler"

        comicsId?.prices?.forEach {
            binding.tvPrice.text =  it.price.toString()
        }

        binding.tvPages.text =  comicsId?.pageCount.toString()

        comicsId?.dates?.forEach {
            val c = it.date.substring(0,10 )
            binding.tvPublished.text = c
        }
    }
}