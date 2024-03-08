package com.example.repasoevaluacion

import android.app.Dialog
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {


    private lateinit var blanco: TextView
    private lateinit var negro: TextView
    private lateinit var azul: TextView
    private lateinit var amarillo: TextView
    private lateinit var naranja: TextView
    private lateinit var verde: TextView
    private lateinit var cian: TextView
    private lateinit var violeta: TextView
    private lateinit var rojo: TextView
    private lateinit var gris: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        initListeners()

    }

    private fun initComponents() {
        rojo = findViewById<TextView>(R.id.rojo)
        gris = findViewById<TextView>(R.id.gris)
        violeta = findViewById<TextView>(R.id.violeta)
        azul = findViewById<TextView>(R.id.azul)
        amarillo = findViewById<TextView>(R.id.amarillo)
        blanco = findViewById<TextView>(R.id.blanco)
        cian = findViewById<TextView>(R.id.cian)
        negro = findViewById<TextView>(R.id.negro)
        verde = findViewById<TextView>(R.id.verde)
        naranja = findViewById<TextView>(R.id.naranja)

    }

    private fun initListeners() {
        rojo.setOnClickListener { showDialog(rojo) }
        gris.setOnClickListener { showDialog(gris) }
        violeta.setOnClickListener { showDialog(violeta) }
        azul.setOnClickListener { showDialog(azul) }
        cian.setOnClickListener { showDialog(cian) }
        amarillo.setOnClickListener { showDialog(amarillo) }
        blanco.setOnClickListener { showDialog(blanco) }
        negro.setOnClickListener { showDialog(negro) }
        verde.setOnClickListener { showDialog(verde) }
        naranja.setOnClickListener { showDialog(naranja) }

    }

    private fun showDialog(clickedTextView: TextView) {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog)

        var btnChangeColorDialog: CardView =
            dialog.findViewById(R.id.bttnChangeColorDialog) // -> identifica el boton
        var rgColors: RadioGroup = dialog.findViewById(R.id.rgColores)


        btnChangeColorDialog.setOnClickListener {
            val currentColorId = rgColors.checkedRadioButtonId
            val selectedRadioButtonColor: RadioButton =
                rgColors.findViewById(currentColorId)//Como tenemos el id, obtenemos el objeto radioButton a través del ode
            var selectedColorText = selectedRadioButtonColor.text

            //Tengo que seleccionar el TexView que ha accionado el dialog y cambiar sus propiedades
            //conforme al radio button seleccionado
            val res: Resources = baseContext.getResources()
            val packageName: String = baseContext.getPackageName()
            val colorId: Int = res.getIdentifier(selectedColorText.toString(), "color", packageName)
            val desiredColor: Int = ContextCompat.getColor(baseContext, colorId)


            when (clickedTextView) {

                //hay que evaluar el texto seleccionado del radiobuttton
                rojo -> { //getString(R.id."buttonText")

                    var text: TextView = findViewById(R.id.rojo)
                    rojo.setBackgroundColor(desiredColor)
                    var colorText = selectedColorText.toString()
                    text.setText(colorText)
                    //newColorText
                    //asignarle el valor de textColor y darselo al texto
                }

                azul -> {

                    var text: TextView = findViewById(R.id.azul)
                    azul.setBackgroundColor(desiredColor)
                    var colorText = selectedColorText.toString()
                    text.setText(colorText)
                }

                blanco -> {

                    var text: TextView = findViewById(R.id.blanco)
                    blanco.setBackgroundColor(desiredColor)
                    var colorText = selectedColorText.toString()
                    text.setText(colorText)
                }

                naranja -> {

                    var text: TextView = findViewById(R.id.naranja)
                    naranja.setBackgroundColor(desiredColor)
                    var colorText = selectedColorText.toString()
                    text.setText(colorText)
                }

                amarillo -> {

                    var text: TextView = findViewById(R.id.amarillo)
                    amarillo.setBackgroundColor(desiredColor)
                    var colorText = selectedColorText.toString()
                    text.setText(colorText)
                }

                azul -> {

                    var text: TextView = findViewById(R.id.azul)
                    azul.setBackgroundColor(desiredColor)
                    var colorText = selectedColorText.toString()
                    text.setText(colorText)
                }

                verde -> {

                    var text: TextView = findViewById(R.id.verde)
                    verde.setBackgroundColor(desiredColor)
                    var colorText = selectedColorText.toString()
                    text.setText(colorText)
                }

                cian -> {

                    var text: TextView = findViewById(R.id.cian)
                    cian.setBackgroundColor(desiredColor)
                    var colorText = selectedColorText.toString()
                    text.setText(colorText)
                }

                gris -> {

                    var text: TextView = findViewById(R.id.gris)
                    gris.setBackgroundColor(desiredColor)
                    var colorText = selectedColorText.toString()
                    text.setText(colorText)
                }

                azul -> {

                    var text: TextView = findViewById(R.id.azul)
                    azul.setBackgroundColor(desiredColor)
                    var colorText = selectedColorText.toString()
                    text.setText(colorText)
                }

                violeta -> {

                    var text: TextView = findViewById(R.id.violeta)
                    violeta.setBackgroundColor(desiredColor)
                    var colorText = selectedColorText.toString()
                    text.setText(colorText)
                }

                negro -> {

                    var text: TextView = findViewById(R.id.negro)
                    negro.setBackgroundColor(desiredColor)
                    var colorText = selectedColorText.toString()
                    text.setText(colorText)
                }

            }
            var newColorText =
                when (colorId) {
                    R.color.Amarillo -> clickedTextView.setTextColor(getColor(R.color.Negro))
                    R.color.Negro -> clickedTextView.setTextColor(getColor(R.color.Blanco))
                    R.color.Azul -> clickedTextView.setTextColor(getColor(R.color.Blanco))
                    R.color.Violeta -> clickedTextView.setTextColor(getColor(R.color.Blanco))
                    R.color.Verde -> clickedTextView.setTextColor(getColor(R.color.Negro))
                    R.color.Gris -> clickedTextView.setTextColor(getColor(R.color.Blanco))
                    R.color.Blanco -> clickedTextView.setTextColor(getColor(R.color.Negro))
                    R.color.Cian -> clickedTextView.setTextColor(getColor(R.color.Negro))
                    R.color.Rojo -> clickedTextView.setTextColor(getColor(R.color.Blanco))
                    R.color.Naranja -> clickedTextView.setTextColor(getColor(R.color.Negro))
                    else -> clickedTextView.setTextColor(getColor(R.color.Negro))
                }
            dialog.hide()
        }
        dialog.show()
    }
}