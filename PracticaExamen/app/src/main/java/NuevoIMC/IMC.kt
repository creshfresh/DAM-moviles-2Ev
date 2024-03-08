package NuevoIMC

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.practicaexamen.R
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat
import kotlin.math.pow

class IMC : AppCompatActivity() {
    private var currentWeight: Int = 70
    private var currentAge: Int = 30
    private var currentHeight: Int = 120

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView

    private lateinit var btnSubtractWeight: CardView
    private lateinit var btnAddWeight: CardView
    private lateinit var tvWeight: TextView

    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider

    private lateinit var btnAddAge: CardView
    private lateinit var btnSubtractAge: CardView
    private lateinit var tvAge: TextView

    private lateinit var btnCalculate: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        initComponents()
        initListeners()
        setWeight()
        setAge()

    }


    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        btnSubtractWeight = findViewById(R.id.minusWeight)
        btnAddWeight = findViewById(R.id.addWeight)
        tvWeight = findViewById(R.id.tvWeight)
        tvAge = findViewById(R.id.tvAge)
        btnSubtractAge = findViewById(R.id.minusAge)
        btnAddAge = findViewById(R.id.addAge)
        btnCalculate = findViewById(R.id.bttnCal)
    }
    private fun initListeners() {
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#")
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight cm"

        }
        viewMale.setOnClickListener{
            setComponentColorMale();
        }

        viewFemale.setOnClickListener{
            setComponentColorFemale();
        }

        btnSubtractAge.setOnClickListener{
            currentAge-= 1
            setAge()
        }
        btnAddAge.setOnClickListener{
            currentAge+=1
            setAge()
        }

        btnAddWeight.setOnClickListener{
            currentWeight+=1
            setWeight()
        }
        btnSubtractWeight.setOnClickListener{
            currentWeight-=1
            setWeight()
        }
        btnCalculate.setOnClickListener {
            val result = calculateIMC()
            //Log.i("IMC", "El IMC es $result")
            navigateResultApp(result)
        }

    }

    private fun setComponentColorFemale() {
        if(!isFemaleSelected){
            viewFemale.setBackgroundColor(getColor(R.color.background_component_selected))
            viewMale.setBackgroundColor(getColor(R.color.background_component))

            isMaleSelected = false;
            isFemaleSelected = true;
        }
    }

    private fun setComponentColorMale() {
        if(!isMaleSelected){
            viewMale.setBackgroundColor(getColor(R.color.background_component_selected))
            viewFemale.setBackgroundColor(getColor(R.color.background_component))

            isMaleSelected = true;
            isFemaleSelected = false;
        }
    }

    private fun setAge() {

        tvAge.text = currentAge.toString()
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }
    private fun calculateIMC(): Double {
        val df = DecimalFormat("#.##")
        val imc = currentWeight / (currentHeight.toDouble() / 100).pow(2.0)

        return df.format(imc).toDouble()
    }

    private fun navigateResultApp (result: Double) {
        var resultintent = Intent(this, ResultActivity ::class.java)
        resultintent.putExtra("IMC_result", result)
        startActivity(resultintent)

    }


}