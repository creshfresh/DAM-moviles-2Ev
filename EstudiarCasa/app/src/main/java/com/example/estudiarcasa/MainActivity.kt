package com.example.estudiarcasa

import android.app.Dialog
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat


private lateinit var rojo: TextView
private lateinit var azul: TextView
private lateinit var amarillo: TextView
private lateinit var naranja: TextView
private lateinit var verde: TextView
private lateinit var violeta: TextView
private lateinit var negro: TextView
private lateinit var blanco: TextView
private lateinit var cian: TextView
private lateinit var gris: TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponent()
        initListeners()
    }

    private fun initListeners() {
        rojo.setOnClickListener { showDialog(rojo) };
        blanco.setOnClickListener { showDialog(blanco) };
        amarillo.setOnClickListener { showDialog(amarillo) };
        naranja.setOnClickListener { showDialog(naranja) };
        verde.setOnClickListener { showDialog(verde) };
        cian.setOnClickListener { showDialog(cian) };
        azul.setOnClickListener { showDialog(azul) };
        violeta.setOnClickListener { showDialog(violeta) };
        gris.setOnClickListener { showDialog(gris) };
        negro.setOnClickListener { showDialog(negro) };

    }

    private fun initComponent() {
        rojo = findViewById<TextView>(R.id.tvRojo)
        blanco = findViewById<TextView>(R.id.tvBlanco)
        amarillo = findViewById<TextView>(R.id.tvAmarillo)
        naranja = findViewById<TextView>(R.id.tvNaranja)
        verde = findViewById<TextView>(R.id.tvVerde)
        cian = findViewById<TextView>(R.id.tvCian)
        azul = findViewById<TextView>(R.id.tvAzul)
        violeta = findViewById<TextView>(R.id.tvVioleta)
        gris = findViewById<TextView>(R.id.tvGris)
        negro = findViewById<TextView>(R.id.tvNegro)

    }

    private fun showDialog(selectedTextView: TextView) {

        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog)

        var bttnChangeColor: CardView = dialog.findViewById(R.id.bttnChangeColorDialog)
        var rgColors: RadioGroup = dialog.findViewById(R.id.rgColores)

        bttnChangeColor.setOnClickListener {
            val currentColorId = rgColors.checkedRadioButtonId
            val selectedRadioButtonColor: RadioButton =
                rgColors.findViewById(currentColorId)//Como tenemos el id, obtenemos el objeto radioButton a través del ode
            var selectedColorText = selectedRadioButtonColor.text


            val res: Resources = baseContext.getResources()
            val packageName: String = baseContext.getPackageName()
            val colorId: Int = res.getIdentifier(selectedColorText.toString(), "color", packageName)
            val desiredColor: Int = ContextCompat.getColor(baseContext, colorId)

            when (selectedTextView) {

                blanco -> {
                    val text: TextView = findViewById(R.id.tvBlanco)
                    blanco.setBackgroundColor(desiredColor)
                    var colorText = selectedColorText.toString()
                    text.setText(colorText)

                }

                rojo -> {
                    val text: TextView = findViewById(R.id.tvRojo)
                    rojo.setBackgroundColor(desiredColor)
                    var colorText = selectedColorText.toString()
                    text.setText(colorText)

                }

                naranja -> {
                    val text: TextView = findViewById(R.id.tvNaranja)
                    naranja.setBackgroundColor(desiredColor)
                    var colorText = selectedColorText.toString()
                    text.setText(colorText)

                }

                amarillo -> {
                    val text: TextView = findViewById(R.id.tvAmarillo)
                    amarillo.setBackgroundColor(desiredColor)
                    var colorText = selectedColorText.toString()
                    text.setText(colorText)

                }

                verde -> {
                    val text: TextView = findViewById(R.id.tvVerde)
                    verde.setBackgroundColor(desiredColor)
                    var colorText = selectedColorText.toString()
                    text.setText(colorText)

                }

                cian -> {
                    val text: TextView = findViewById(R.id.tvCian)
                    cian.setBackgroundColor(desiredColor)
                    var colorText = selectedColorText.toString()
                    text.setText(colorText)

                }

                azul -> {
                    val text: TextView = findViewById(R.id.tvAzul)
                    azul.setBackgroundColor(desiredColor)
                    var colorText = selectedColorText.toString()
                    text.setText(colorText)

                }

                violeta -> {
                    val text: TextView = findViewById(R.id.tvVioleta)
                    violeta.setBackgroundColor(desiredColor)
                    var colorText = selectedColorText.toString()
                    text.setText(colorText)

                }

                gris -> {
                    val text: TextView = findViewById(R.id.tvGris)
                    gris.setBackgroundColor(desiredColor)
                    var colorText = selectedColorText.toString()
                    text.setText(colorText)

                }

                negro -> {
                    val text: TextView = findViewById(R.id.tvNegro)
                    negro.setBackgroundColor(desiredColor)
                    var colorText = selectedColorText.toString()
                    text.setText(colorText)

                }

            }
            dialog.hide()

        }


        dialog.show()

    }


}