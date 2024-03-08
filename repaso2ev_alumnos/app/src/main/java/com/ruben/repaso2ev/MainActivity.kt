package com.ruben.repaso2ev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.room.Room
import com.ruben.repaso2ev.data.database.MoviesDatabase
import com.ruben.repaso2ev.data.entities.MoviesEntity
import com.ruben.repaso2ev.data.entities.toDatabase
import com.ruben.repaso2ev.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_ID = "extra_id"
    }
    private lateinit var binding: ActivityMainBinding
    private lateinit var room: MoviesDatabase
    private lateinit var adapter: MoviesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        room = Room.databaseBuilder(this, MoviesDatabase::class.java,"moies").build()
        setContentView(binding.root)

        fillDatabase ()
        initUI()
    }

    private fun fillDatabase() {
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse : List<Movie>  = MoviesProvider.getMovies()

            if (myResponse.isNotEmpty()){
                    Log.i("", "llenado :) 1")
                    room.gestMovies().deleteAllMovies()
                    room.gestMovies().insertAllMovies(myResponse.map { it.toDatabase() })
                Log.i("", myResponse.toString())

            }

        }
    }

    private fun initUI(){

        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean { //cuando le des a la lupa
                searchByName(query.orEmpty())
                return false
            }
            override fun onQueryTextChange(newText: String?) = false
        })
        adapter = MoviesAdapter()

        binding.rvMovies.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvMovies.setHasFixedSize(true)
     //   binding.rvMovies.layoutManager = LinearLayoutManager(this)
        binding.rvMovies.adapter = adapter
    }


    private fun searchByName(query: String) {


        binding.progressBar.isVisible = true

        var peticion : String = "%".plus(query).plus("%")
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: List <MoviesEntity> =
                room.gestMovies().getAllMovies(peticion)

            Log.i("", peticion)

            if (myResponse != null) {
                Log.i("Consulta", "Funciona :)")
                runOnUiThread{
                    Log.i("", myResponse[0].id.toString())
                    adapter.updateList(myResponse)
                    binding.progressBar.isVisible = false
                }
            }else {
                Log.i("Consulta", "No funciona :(")
            }
        }
    }

}