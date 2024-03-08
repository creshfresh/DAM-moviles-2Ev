package com.example.roomdatabase.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.roomdatabase.ui.viewmodel.QuoteViewModel
import com.example.roomdatabase.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, Observer {
            currenQuote ->
            binding.tvQuote.text= currenQuote?.quote
            binding.tvAuthor.text= currenQuote?.author
        })

        quoteViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible= it;
        })
        binding.viewContainer.setOnClickListener{ quoteViewModel.randomQuote()}
    }
}