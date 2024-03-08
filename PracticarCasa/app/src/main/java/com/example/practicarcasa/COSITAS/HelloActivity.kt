package com.example.practicarcasa.COSITAS

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.practicarcasa.R

class HelloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        var btnVolver = findViewById<Button>(R.id.btnVolver)
        var textHola = findViewById<TextView>(R.id.helloText)
        var etResponder = findViewById<EditText>(R.id.etResponder)


        var nombre = intent.extras?.getString("extra_name").orEmpty()
        textHola.text = "Hola $nombre"


        btnVolver.setOnClickListener {
            var textRespuesta = etResponder.text.toString()
            //ponerlo dentro porque si se deja fuera la cadena se deja vacia
            //Aún no se le habia metido datos como para que se pudieran mostrar
            var textIntent = Intent(this, MainActivity::class.java)
            textIntent.putExtra("respuesta", textRespuesta)
            startActivity(textIntent)
        }
    }
}