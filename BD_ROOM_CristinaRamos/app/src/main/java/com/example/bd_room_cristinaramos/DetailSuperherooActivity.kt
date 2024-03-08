package com.example.bd_room_cristinaramos

import android.annotation.SuppressLint
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.room.Room
import com.example.bd_room_cristinaramos.SuperHeroListActivity.Companion.EXTRA_ID
import com.example.bd_room_cristinaramos.data.database.SuperHeroDao
import com.example.bd_room_cristinaramos.data.database.SuperHeroDataBase
import com.example.bd_room_cristinaramos.data.entities.SuperHeroDetailEntity
import com.example.bd_room_cristinaramos.data.entities.SuperHeroEntity
import com.example.bd_room_cristinaramos.databinding.ActivityDetailSuperherooBinding
import com.example.bd_room_cristinaramos.network.ApiService
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log
import kotlin.math.roundToInt

class DetailSuperherooActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailSuperherooBinding
    private lateinit var room: SuperHeroDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSuperherooBinding.inflate(layoutInflater)
        room = Room.databaseBuilder(this, SuperHeroDataBase::class.java,"superheroDB").build()
        setContentView(R.layout.activity_detail_superheroo)
        setContentView(binding.root)
        getRetrofit()

        val id: String = intent.getStringExtra(EXTRA_ID).orEmpty()
        Log.i("", id)
        getSuperheroInformation(id.toInt())
    }
    private fun createUI(superhero: SuperHeroDetailEntity) {
        Picasso.get().load(superhero.image).into(binding.ivSuperhero)

        binding.tvSuperheroName.text = superhero.name
        binding.tvSuperheroRealName.text = superhero.fullname
        binding.tvPublisher.text = superhero.publisher

        //Mostrar los atributos del superhéroe seleccionado en las gráficas
        //Le va a dar altura a cada view de la gráfica
        prepareStats(superhero)

    }
    private fun getSuperheroInformation(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
           val superheroDetail =
               room.getSuperHeroDetail().getDetailSuperHeros(id)

                runOnUiThread {
                    createUI(superheroDetail)
                }
        }
    }
    private fun prepareStats(superhero: SuperHeroDetailEntity) {
        //Aquí le damos los valores para setear cada view con la función updateHeight
        updateHeight(binding.viewIntelligence, superhero.intelligence)
        updateHeight(binding.viewStrength, superhero.strength)
        updateHeight(binding.viewSpeed, superhero.speed)
        updateHeight(binding.viewDurability, superhero.durability)
        updateHeight(binding.viewPower, superhero.power)
        updateHeight(binding.viewCombat, superhero.combat)
    }
    private fun updateHeight(view: View, stat:String){
        //Funcion que contiene la lógica
        // -> Recibe un view donde el paránetro (params) de la altura
        val params = view.layoutParams

        // -> Modificamos los parámetros
        if (stat != "null") {
            params.height = pxToDp(stat.toFloat())
        } else {
            params.height = pxToDp(0.toFloat())
        }

        //->  a la view asignanos los nuevos parámetros
        view.layoutParams = params
    }
    private fun pxToDp(px:Float):Int{

        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, Resources.getSystem().displayMetrics).roundToInt()
    }
    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}