package com.example.practicaexamen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent

class Message : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        var textoRecibido = findViewById<TextView>(R.id.doneSeEnvia)
        var recibido: String = intent.extras?.getString("extraTexto").orEmpty()

        textoRecibido.text = recibido


    }
}