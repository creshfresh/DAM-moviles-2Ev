package com.example.practicaexamen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

import androidx.cardview.widget.CardView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_layout)
        val btnLayaoutLoco = findViewById<CardView>(R.id.btnSend)
        var textoEnviar = findViewById<EditText>(R.id.respuesta)

        btnLayaoutLoco.setOnClickListener {
            var texto = textoEnviar.text.toString()
            if (texto.isNotEmpty()){
                var textoIntent = Intent(this, Message::class.java)
                textoIntent.putExtra("extraTexto", texto)
                startActivity(textoIntent)
            }
        }
    }


}