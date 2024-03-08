package com.example.bd_room_cristinaramos

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.bd_room_cristinaramos.data.database.SuperHeroDao
import com.example.bd_room_cristinaramos.data.database.SuperHeroDataBase
import com.example.bd_room_cristinaramos.data.entities.SuperHeroEntity
import com.example.bd_room_cristinaramos.data.entities.toDatabase
import com.example.bd_room_cristinaramos.databinding.ActivitySuperHeroListBinding
import com.example.bd_room_cristinaramos.network.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperHeroListActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extra_id"
    }
    // Binding permite acceder a los views asociados a la actividad
    private lateinit var binding: ActivitySuperHeroListBinding
    private lateinit var retrofit: Retrofit
    private lateinit var room: SuperHeroDataBase
    private lateinit var adapter: SuperheroAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Accedemos al layout inflater con el binding
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        retrofit = getRetrofit()
        room = Room.databaseBuilder(this, SuperHeroDataBase::class.java,"superheroDB").build()
        setContentView(binding.root)

        fillDatabase ()
        initUI()
    }

    private fun initUI(){

        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean { //cuando le des a la lupa
                searchByName(query.orEmpty())
                return false
            }
            override fun onQueryTextChange(newText: String?) = false
        })
        adapter = SuperheroAdapter {superheroId -> navigateToDetail(superheroId)}
        binding.rvSuperhero.setHasFixedSize(true)
        binding.rvSuperhero.layoutManager = LinearLayoutManager(this)
        binding.rvSuperhero.adapter = adapter
    }

    private fun fillDatabase (){

        CoroutineScope(Dispatchers.IO).launch {
            val myResponse : Response<SuperHeroDataResponse> = retrofit.create(ApiService::class.java).getSuperheroes()
            if (myResponse.isSuccessful){
                val respone : SuperHeroDataResponse? = myResponse.body()
                if(respone != null){
                    Log.i("", "llenado :) 1")
                  room.getSuperheroes().deleteAllHeroes()
                  room.getSuperheroes().insertAllSuperheros(respone.superheroes.map { it.toDatabase() })

                    Log.i("", respone.toString())
                }
            }

            val myResponsev2 :Response<SuperHeroDetailResponse> =  retrofit.create(ApiService::class.java).getSuperheroDetail()
            if (myResponsev2.isSuccessful){

                val respone : SuperHeroDetailResponse? = myResponsev2.body()

                if(respone != null){
                    Log.i("", "llenado :) 2")

                    room.getSuperHeroDetail().deleteAllHeroes()
                    room.getSuperHeroDetail().insertAllSuperheros(respone.superheroes.map { it.toDatabase() })
                    binding.progressBar.isVisible = false
               Log.i("lleno", respone.superheroes.map { it.toDatabase() }.toString())
                }
            }
        }
    }


    private fun searchByName(query: String) {


        binding.progressBar.isVisible = true

        var peticion : String = "%".plus(query).plus("%")
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: List <SuperHeroEntity> =
                room.getSuperheroes().getAllSuperHeros(peticion)

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
    private fun navigateToDetail(id: String) {
        val intent = Intent(this, DetailSuperherooActivity::class.java)
        intent.putExtra(EXTRA_ID, id)
        startActivity(intent)
    }

    private fun getRetrofit():Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }


}