package com.example.examencristinaramos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    private var resulado: Int = 0
    private var num: Int = 0
    private var num2: Int = 0
    private var operador: String = ""
    private var hayOperador: Boolean = false

    //Operaciones
    private lateinit var sumar: TextView
    private lateinit var restar: TextView
    private lateinit var multiplicar: TextView
    private lateinit var dividir: TextView
    private lateinit var porcentaje: TextView
    private lateinit var igual: TextView

    //Numeros
    private lateinit var uno: TextView
    private lateinit var dos: TextView
    private lateinit var tres: TextView
    private lateinit var cuatro: TextView
    private lateinit var cinco: TextView
    private lateinit var seis: TextView
    private lateinit var siete: TextView
    private lateinit var ocho: TextView
    private lateinit var nueve: TextView
    private lateinit var cero: TextView

    //Mensaje a mostrar
    private lateinit var resultadoMostrar: TextView

    //Modificar el mensaje
    private lateinit var mensajeMostrar: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        initListeners()
    }

    private fun initComponents() {

        //Operaciones
        sumar = findViewById(R.id.btnAdd)
        restar = findViewById(R.id.btnMinus)
        multiplicar = findViewById(R.id.btnMulti)
        dividir = findViewById(R.id.btnDiv)
        igual = findViewById(R.id.btnIgual)
        porcentaje = findViewById(R.id.btnPercent)

        //Números
        cero = findViewById(R.id.bt0)
        uno = findViewById(R.id.bt1)
        dos = findViewById(R.id.bt2)
        tres = findViewById(R.id.bt3)
        cuatro = findViewById(R.id.bt4)
        cinco = findViewById(R.id.bt5)
        seis = findViewById(R.id.bt6)
        siete = findViewById(R.id.bt7)
        ocho = findViewById(R.id.bt8)
        nueve = findViewById(R.id.bt9)

        //Mensaje y resultado
        mensajeMostrar = findViewById(R.id.instrucciones)
        resultadoMostrar = findViewById(R.id.resultado)
    }

    private fun initListeners() {

        uno.setOnClickListener() {
            primerPaso(uno)
        }
        cero.setOnClickListener() {
            primerPaso(cero)
        }
        dos.setOnClickListener() {
            primerPaso(dos)
        }
        tres.setOnClickListener() {
            primerPaso(tres)
        }
        cuatro.setOnClickListener() {
            primerPaso(cuatro)
        }
        cinco.setOnClickListener() {
            primerPaso(cinco)
        }
        seis.setOnClickListener() {
            primerPaso(seis)
        }
        siete.setOnClickListener() {
            primerPaso(siete)
        }
        ocho.setOnClickListener() {
            primerPaso(ocho)
        }
        nueve.setOnClickListener() {
            primerPaso(nueve)
        }
        // Tengo que asegurarme que lo primero que se le pasa no es un operador
        sumar.setOnClickListener() {
            segundoPaso(sumar)
        }
        restar.setOnClickListener() {
            segundoPaso(restar)
        }
        multiplicar.setOnClickListener() {
            segundoPaso(multiplicar)
        }
        dividir.setOnClickListener() {
            segundoPaso(dividir)
        }
        porcentaje.setOnClickListener() {
            segundoPaso(porcentaje)
        }
        igual.setOnClickListener() {
            tercerPaso(igual)
        }
    }

    private fun primerPaso(numero: TextView) {

        var numeroString: String = numero.text.toString()
        if (resultadoMostrar.text.isNotEmpty()){
            var numeroEntero = numeroString.toInt()
            when (numeroEntero) {

                1 -> {
                    num2=1
                    resultadoMostrar.text = resultadoMostrar.text.toString() + getString(R.string.one)
                    mensajeMostrar.text = getString(R.string.chooOperator)
                }
                2 -> {
                    num2= 2
                    resultadoMostrar.text = resultadoMostrar.text.toString() + getString(R.string.two)
                    mensajeMostrar.text = getString(R.string.chooOperator)
                }
                3 -> {
                    num2= 3
                    resultadoMostrar.text =resultadoMostrar.text.toString() +  getString(R.string.tree)
                    mensajeMostrar.text = getString(R.string.chooOperator)
                }
                4 -> {
                    num2= 4
                    resultadoMostrar.text = resultadoMostrar.text.toString() +  getString(R.string.four)
                    mensajeMostrar.text = getString(R.string.chooOperator)
                }

                5 -> {
                    num2= 5
                    resultadoMostrar.text = resultadoMostrar.text.toString() + getString(R.string.five)
                    mensajeMostrar.text = getString(R.string.chooOperator)
                }

                6 -> {
                    num2= 6
                    resultadoMostrar.text = resultadoMostrar.text.toString() +  getString(R.string.six)
                    mensajeMostrar.text = getString(R.string.chooOperator)
                }

                7 -> {
                    num2= 7
                    resultadoMostrar.text = resultadoMostrar.text.toString() + getString(R.string.seven)
                    mensajeMostrar.text = getString(R.string.chooOperator)
                }

                8 -> {
                    num2= 8
                    resultadoMostrar.text =resultadoMostrar.text.toString() +  getString(R.string.eight)
                    mensajeMostrar.text = getString(R.string.chooOperator)
                }

                9 -> {
                    num2= 9
                    resultadoMostrar.text =resultadoMostrar.text.toString() +  getString(R.string.nine)
                    mensajeMostrar.text = getString(R.string.chooOperator)
                }

                0 -> {
                    num2= 0
                    resultadoMostrar.text = resultadoMostrar.text.toString() + getString(R.string.zero)
                    mensajeMostrar.text = getString(R.string.chooOperator)
                }
                else -> {
                    mensajeMostrar.text = getString(R.string.mendrugo)
                }
        } }else {
            var numeroEntero = numeroString.toInt()
            when (numeroEntero) {
                1 -> {

                    num=1
                    resultadoMostrar.text = getString(R.string.one)
                    mensajeMostrar.text = getString(R.string.chooOperator)
                }

                2 -> {
                    num= 2
                    resultadoMostrar.text = getString(R.string.two)
                    mensajeMostrar.text = getString(R.string.chooOperator)
                }

                3 -> {
                    num= 3
                    resultadoMostrar.text = getString(R.string.tree)
                    mensajeMostrar.text = getString(R.string.chooOperator)
                }

                4 -> {
                    num= 4
                    resultadoMostrar.text = getString(R.string.four)
                    mensajeMostrar.text = getString(R.string.chooOperator)
                }

                5 -> {
                    num= 5
                    resultadoMostrar.text = getString(R.string.five)
                    mensajeMostrar.text = getString(R.string.chooOperator)
                }

                6 -> {
                    num= 6
                    resultadoMostrar.text = getString(R.string.six)
                    mensajeMostrar.text = getString(R.string.chooOperator)
                }

                7 -> {
                    num= 7
                    resultadoMostrar.text = getString(R.string.seven)
                    mensajeMostrar.text = getString(R.string.chooOperator)
                }

                8 -> {
                    num= 8
                    resultadoMostrar.text = getString(R.string.eight)
                    mensajeMostrar.text = getString(R.string.chooOperator)
                }

                9 -> {
                    num= 9
                    resultadoMostrar.text = getString(R.string.nine)
                    mensajeMostrar.text = getString(R.string.chooOperator)
                }

                0 -> {
                    num= 0
                    resultadoMostrar.text = getString(R.string.zero)
                    mensajeMostrar.text = getString(R.string.chooOperator)
                }
                else -> {
                    mensajeMostrar.text = getString(R.string.mendrugo)
                }
            }
        }
    }

    private fun segundoPaso(operador: TextView) {

        if (resultadoMostrar.text.isNotEmpty() && resultadoMostrar.text.count() == 1) {

            var numeroString: String = resultadoMostrar.text.toString()
            when (operador.text) {
                "+" -> {
                    resultadoMostrar.text = numeroString + "+"
                }
                "/" -> {
                    resultadoMostrar.text = numeroString + "/"
                }
                "-" -> {
                    resultadoMostrar.text = numeroString + "-"
                }
                "%" -> {
                    resultadoMostrar.text = numeroString + "%"
                }
                "x" -> {
                    resultadoMostrar.text = numeroString + "x"
                }
            }
        }else if(resultadoMostrar.text.count()==2)
            mensajeMostrar.text = getString(R.string.mendrugo)

        else {
            mensajeMostrar.text = (getString(R.string.fataOperacion))
        }
    }

    private fun tercerPaso(igual: TextView) {
        var nuevoresultado: String
        if(resultadoMostrar.text.isEmpty()){
            mensajeMostrar.text = getString(R.string.mendrugovis)
        }else
        {
            if(resultadoMostrar.text.contains("+")){
               nuevoresultado = calcularOperacion(num, num2, "+").toString()
                resultadoMostrar.text = resultadoMostrar.text.toString() + "=" + nuevoresultado
            }else if(resultadoMostrar.text.contains("-")){
               nuevoresultado = calcularOperacion(num, num2, "-").toString()
                resultadoMostrar.text = resultadoMostrar.text.toString() + "=" + nuevoresultado
            }else if(resultadoMostrar.text.contains("/")){
               nuevoresultado = calcularOperacion(num, num2, "/").toString()
                resultadoMostrar.text = resultadoMostrar.text.toString() + "=" + nuevoresultado
            }else if(resultadoMostrar.text.contains("x")){
               nuevoresultado = calcularOperacion(num, num2, "x").toString()
                resultadoMostrar.text = resultadoMostrar.text.toString() + "=" + nuevoresultado
            }else{
                nuevoresultado = calcularOperacion(num, num2, "%").toString()
                resultadoMostrar.text = resultadoMostrar.text.toString() + "=" + nuevoresultado
            }
        }
    }
    private fun calcularOperacion(num: Int, num2: Int, operador: String): Int {

        when(operador){
            "+" -> {
                resulado = num + num2
            }
            "/" -> {
                resulado = num / num2
            }
            "-" -> {
                resulado = num - num2
            }
            "%" -> {
                resulado = num % num2
            }
            "x" -> {
                resulado = num * num2
            }
        }
        return resulado
    }
}