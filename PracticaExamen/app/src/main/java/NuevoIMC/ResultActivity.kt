package NuevoIMC

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.practicaexamen.R

class ResultActivity : AppCompatActivity() {
    private lateinit var tvResult: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvDescription: TextView

    private lateinit var btnRecalculate: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var result: Double = intent.extras?.getDouble("IMC_result") ?: -1.0

        initComponents();
        initListeners();
        initUI(result);

    }

    private fun initComponents() {
        tvResult = findViewById(R.id.tvResult)
        tvDescription = findViewById(R.id.tvDescription)
        tvIMC = findViewById(R.id.tvIMC)
        btnRecalculate = findViewById(R.id.btnRecalculate)
    }

    private fun initListeners() {
        btnRecalculate.setOnClickListener {
            onBackPressed()
        }

    }

    private fun initUI(result: Double) {
        tvIMC.text = result.toString()

        when(result){

            in 0.0 .. 18.50 -> {
                tvResult.text = getString(R.string.title_bajo_peso)
                tvResult.setTextColor(getColor(R.color.peso_bajo))
                tvDescription.text = getString(R.string.description_bajo_peso)
            }
            in 18.51 .. 24.99 -> {
                tvResult.text = getString(R.string.title_peso_normal)
                tvResult.setTextColor(getColor(R.color.peso_normal))
                tvDescription.text = getString(R.string.description_peso_normal)
            }

            in 25.00 .. 29.99 -> {
                tvResult.text = getString(R.string.title_sobrepeso)
                tvResult.setTextColor(getColor(R.color.sobrepeso))
                tvDescription.text = getString(R.string.description_sobrepeso)
            }

            in 30.00 .. 99.00 ->{
                tvResult.text = getString(R.string.title_obesidad)
                tvResult.setTextColor(getColor(R.color.obesidad))
                tvDescription.text = getString(R.string.description_obesidad)
            }
            else -> {
                tvIMC.text = getString(R.string.error)
                tvResult.text = getString(R.string.error)
                tvResult.setTextColor(getColor(R.color.obesidad))
                tvDescription.text = getString(R.string.error)
            }
        }
    }

}


