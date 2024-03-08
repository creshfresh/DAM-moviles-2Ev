package com.example.practicarcasa.COSITAS

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.practicarcasa.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hola_mundo)

        var btnSend = findViewById<Button>(R.id.btnSend)
        var userText = findViewById<EditText>(R.id.etName)
        var texRespuesta = findViewById<TextView>(R.id.tvRespuesta)



        btnSend.setOnClickListener {
            var name = userText.text.toString()
            if (name.isNotEmpty()){
                //Vamos a la nueva pantalla
                var textIntent = Intent(this, HelloActivity::class.java)
                textIntent.putExtra("extra_name", name)
                startActivity(textIntent)
            }
        }

        var respuesta =  intent.extras?.getString("respuesta").orEmpty()
        texRespuesta.text = "$respuesta"
    }
}