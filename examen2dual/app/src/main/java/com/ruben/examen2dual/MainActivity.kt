package com.ruben.examen2dual

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.ruben.examen2dual.data.MoviesEntity
import com.ruben.examen2dual.data.toDataBase
import com.ruben.examen2dual.database.MoviesDatabase
import com.ruben.examen2dual.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivityMainBinding
    private lateinit var room : MoviesDatabase
    private lateinit var adapter: MoviesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        binding = ActivityMainBinding.inflate(layoutInflater)
        room = Room.databaseBuilder(this, MoviesDatabase::class.java, "movies").build()
        setContentView(binding.root)

        fillDatabase()
        initUI()
    }


    private fun searchbyGenre () {

        CoroutineScope(Dispatchers.IO).launch {
            val movies : List <MoviesEntity> =
                room.getMoviesDao().getAcctionMovie()

            if (movies.isNotEmpty()){
                Log.i("Los génereos", movies.toString())
                runOnUiThread {
                    adapter.updateList(movies)
                }
            }

        }
    }

    private fun searchAllCatalog () {

        CoroutineScope(Dispatchers.IO).launch {
            val movies : List <MoviesEntity> =
                room.getMoviesDao().getAll()

            if (movies.isNotEmpty()){
                Log.i("Todo el catálogo", movies.toString())
                runOnUiThread {
                    adapter.updateList(movies)
                }
            }

        }
    }

    private fun fillDatabase() {
        val titles = listOf("Beekeeper: El protector", "Cazadores en tierra inhóspita", "The Marvels",
            "El aprendiz de tigre", "The Painter", "Juego de roles", "Con todos menos contigo",
            "Napoleón", "Plan en familia", "Borderlands", "Deadpool 3", "Wonka",
            "Wish: El poder de los deseos", "Migración: un viaje patas arriba", "Los Mercen4rios")

        val images = listOf(
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/bHZQYKJV1rV01S3kNZ3hEYz8VNM.jpg",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/jPGbcbMlzGUECukPhkEMVt1Kvs5.jpg",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vpuuFM032yiX8tox4L84Wl9MGjG.jpg",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6AgafVcJ03sbxpOebGDGwsZWT9R.jpg",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/UZ0ydgbXtnrq8xZCI5lHVXVcH9.jpg",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/bnG0VwIw9oBFVn58Z9cixVLsn93.jpg",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/3ltpe5KJt8c8hxHiF2u4jCinD4U.jpg",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/re6SSQS1HgBGG9AMiNuPGISOfMx.jpg",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7mEX07jWRYrjarW84sBeFghGMfa.jpg",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qXpQBgsasf60CBkevYJReZzbkDU.jpg",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/3e9RToA9tGMl1T994T9T8zLW3CU.jpg",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/tFyQa5WQqldIL44HBLaCmn5eERD.jpg",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1VXMrUioKfPAPSsezHKexx77Dbz.jpg",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/brAqSBoSXzxEYV6rGYwbRvhlXCE.jpg",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/2jmE7xH0R0dikmc8iplCPCit4MD.jpg"
        )

        val directors = listOf("David Ayer", "Heo Myeong-haeng", "Nia DaCosta", "Raman Hui",
            "Kimani Ray Smith", "Thomas Vincent", "Will Gluck", "Ridley Scott", "Simon Cellan Jones",
            "Eli Roth", "Shawn Levy", "Paul King", "Chris Buck", "Benjamin Renner", "Scott Waugh")

        val durations = listOf( "1h 45m", "1h 47m", "1h 45m", "1h 24m", "1h 40m", "1h 41m", "1h 44m",
            "2h 38m", "1h 58m", "Desconocida", "Desconocida", "1h 57m", "1h 35m", "1h 23m", "1h 43m")

        val releaseDates = listOf( "12/01/2024", "25/01/2024", "9/11/2023", "2/02/2024", "5/01/2024",
            "12/01/2024", "19/01/2024", "24/11/2023", "15/12/2023", "9/08/2024", "26/07/2024",
            "6/12/2023", "24/11/2023", "22/12/2023", "29/09/2023")

        val genres = listOf( "Acción", "Acción", "Ciencia ficción", "Aventura", "Acción", "Romance",
            "Comedia", "Historia", "Comedia", "Aventura", "Acción", "Fantasía", "Fantasía",
            "Animación", "Acción")


        //Crear un "provider"
        val moviesProvider = mutableListOf<Movie>()

        for (i in titles.indices){
            moviesProvider.add(Movie(title = titles[i], image = images[i], director = directors[i], duration = durations[i], releaseDate = releaseDates[i], genre = genres[i] ))
        }

        //LLenar la BBDD room+

        if(moviesProvider.isNotEmpty()) {
            Log.i("LLenar BBDD", moviesProvider.toString())
            CoroutineScope(Dispatchers.IO).launch {
                room.getMoviesDao().deleteAll()
                room.getMoviesDao().insertAll(moviesProvider.map { it.toDataBase() })
                Log.i("DesdeBBDD", room.getMoviesDao().getAll().toString())
            }
        }
    }

    private fun initUI() {
        Picasso.get().load("https://i.kym-cdn.com/photos/images/original/000/316/241/37a.gif").into(binding.ivLogo)

        adapter = MoviesAdapter()
        binding.rvMovies.setHasFixedSize(true)
        binding.rvMovies.layoutManager = LinearLayoutManager(this)
        binding.rvMovies.adapter = adapter
        CoroutineScope(Dispatchers.IO).launch {
            val listEntity: List<MoviesEntity> = room.getMoviesDao().getAll()
            runOnUiThread {
                adapter.updateList(listEntity)
            }
        }
            binding.tvCatalogue.setOnClickListener(){
                searchAllCatalog()
            }

        binding.tvActionMovies.setOnClickListener(){
            searchbyGenre()
        }



    }
}