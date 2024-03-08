package com.example.consumoapis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.consumoapis.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: VideGamesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()
    }

    private fun initUI() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }
            override fun onQueryTextChange(newText: String?) = false
        })
        adapter = VideGamesAdapter()
        binding.rvVideoGame.setHasFixedSize(true)
        binding.rvVideoGame.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvVideoGame.adapter=adapter

    }

    private fun searchByName(query: String) {
    CoroutineScope(Dispatchers.IO).launch {
        val myResponse : Response<VideoGameDataResponse> =
            retrofit.create(ApiService::class.java).getVideoGames(query)

        if (myResponse.isSuccessful) {
            val response: VideoGameDataResponse? = myResponse.body()

            Log.i("Consulta", "Funciona :)")
            if (response != null) {
                Log.i("Cuerpo de la consulta", response.toString())
                runOnUiThread{
                    adapter.updateList(response.videoGames)
                    binding.progressBar.isVisible= false
                }
            }
        } else {
            Log.i("Consulta", "No funciona :(")
        } }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://api.rawg.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}