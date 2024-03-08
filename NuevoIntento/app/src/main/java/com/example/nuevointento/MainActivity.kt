package com.example.nuevointento

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.cardview.widget.CardView

private lateinit var rojo: TextView
private lateinit var blanco: TextView
private lateinit var amarillo: TextView
private lateinit var naranja: TextView
private lateinit var gris: TextView
private lateinit var verde: TextView
private lateinit var violeta: TextView
private lateinit var cian: TextView
private lateinit var azul: TextView
private lateinit var negro: TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        initListeners()
    }

    private fun initListeners() {
        rojo.setOnClickListener { showDialog(rojo) };
        blanco.setOnClickListener { showDialog(blanco) };
        amarillo.setOnClickListener { showDialog(amarillo) };
        cian.setOnClickListener { showDialog(cian) };
        azul.setOnClickListener { showDialog(azul) };
        naranja.setOnClickListener { showDialog(naranja) };
        verde.setOnClickListener { showDialog(verde) };
        negro.setOnClickListener { showDialog(negro) };
        gris.setOnClickListener { showDialog(gris) };
        violeta.setOnClickListener { showDialog(violeta) };
    }

    private fun initComponents() {
        rojo = findViewById<TextView>(R.id.rojo)
        blanco = findViewById<TextView>(R.id.blanco)
        amarillo = findViewById<TextView>(R.id.amarillo)
        cian = findViewById<TextView>(R.id.cian)
        azul = findViewById<TextView>(R.id.azul)
        naranja = findViewById<TextView>(R.id.naranja)
        negro = findViewById<TextView>(R.id.negro)
        verde = findViewById<TextView>(R.id.verde)
        gris = findViewById<TextView>(R.id.gris)
        violeta = findViewById<TextView>(R.id.violeta)
    }

    private fun showDialog(selectedTextView: TextView) {

        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog)
        dialog.show()


        var bttnChangeColor: CardView = dialog.findViewById(R.id.bttnChangeColorDialog)
        var rgColors: RadioGroup = dialog.findViewById(R.id.rgColors)


        bttnChangeColor.setOnClickListener {

            val currentColorId = rgColors.checkedRadioButtonId
            val selectedRadioButtonColor: RadioButton =
                rgColors.findViewById(currentColorId)//Como tenemos el id, obtenemos el objeto radioButton a través del ode
            var selectedColorText = selectedRadioButtonColor.text

            when (selectedColorText) {

                getString(R.string.white) -> {
                    selectedTextView.text = getString(R.string.white)
                    selectedTextView.setTextColor(getColor(R.color.black))
                    selectedTextView.setBackgroundColor(getColor(R.color.white))
                }

                getString(R.string.black) -> {
                    selectedTextView.text = getString(R.string.black)
                    selectedTextView.setTextColor(getColor(R.color.white))
                    selectedTextView.setBackgroundColor(getColor(R.color.black))
                }

                getString(R.string.red) -> {
                    selectedTextView.text = getString(R.string.red)
                    selectedTextView.setTextColor(getColor(R.color.white))
                    selectedTextView.setBackgroundColor(getColor(R.color.red))
                }

                getString(R.string.cian) -> {
                    selectedTextView.text = getString(R.string.cian)
                    selectedTextView.setTextColor(getColor(R.color.black))
                    selectedTextView.setBackgroundColor(getColor(R.color.cian))
                }

                getString(R.string.blue) -> {
                    selectedTextView.text = getString(R.string.blue)
                    selectedTextView.setTextColor(getColor(R.color.white))
                    selectedTextView.setBackgroundColor(getColor(R.color.blue))
                }

                getString(R.string.orange) -> {
                    selectedTextView.text = getString(R.string.orange)
                    selectedTextView.setTextColor(getColor(R.color.black))
                    selectedTextView.setBackgroundColor(getColor(R.color.orange))
                }

                getString(R.string.yellow) -> {
                    selectedTextView.text = getString(R.string.yellow)
                    selectedTextView.setTextColor(getColor(R.color.black))
                    selectedTextView.setBackgroundColor(getColor(R.color.yellow))
                }

                getString(R.string.green) -> {
                    selectedTextView.text = getString(R.string.green)
                    selectedTextView.setTextColor(getColor(R.color.black))
                    selectedTextView.setBackgroundColor(getColor(R.color.green))
                }

                getString(R.string.grey) -> {
                    selectedTextView.text = getString(R.string.grey)
                    selectedTextView.setTextColor(getColor(R.color.white))
                    selectedTextView.setBackgroundColor(getColor(R.color.grey))
                }

                getString(R.string.violet) -> {
                    selectedTextView.text = getString(R.string.violet)
                    selectedTextView.setTextColor(getColor(R.color.white))
                    selectedTextView.setBackgroundColor(getColor(R.color.violet))
                }
            }

            dialog.hide()
        }


    }

}