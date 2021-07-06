package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity(), View.OnClickListener{
    var operacion = ""
    var operacionPendiente = false
    var existeResultado = false

    lateinit var btnMas : Button
    lateinit var btnMenos : Button
    lateinit var btnEntre : Button
    lateinit var btnIgual : Button
    lateinit var btnPor : Button
    lateinit var btn1 : Button
    lateinit var btn2 : Button
    lateinit var btn3 : Button
    lateinit var btn4 : Button
    lateinit var btn5 : Button
    lateinit var btn6 : Button
    lateinit var btn7 : Button
    lateinit var btn8 : Button
    lateinit var btn9 : Button
    lateinit var btn0 : Button
    lateinit var etVisor : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
    }

    private fun initUI(){
        btnMas = findViewById(R.id.btnMas)
        btnMas.setOnClickListener(this)

        btnMenos = findViewById(R.id.btnMenos)
        btnMenos.setOnClickListener(this)

        btnPor = findViewById(R.id.btnPor)
        btnPor.setOnClickListener(this)

        btnEntre = findViewById(R.id.btnEntre)
        btnEntre.setOnClickListener(this)

        btnIgual = findViewById(R.id.btnIgual)
        btnIgual.setOnClickListener(this)

        btn0 = findViewById(R.id.btn0)
        btn0.setOnClickListener(this)

        btn1 = findViewById(R.id.btn1)
        btn1.setOnClickListener(this)

        btn2 = findViewById(R.id.btn2)
        btn2.setOnClickListener(this)

        btn3 = findViewById(R.id.btn3)
        btn3.setOnClickListener(this)

        btn4 = findViewById(R.id.btn4)
        btn4.setOnClickListener(this)

        btn5 = findViewById(R.id.btn5)
        btn5.setOnClickListener(this)

        btn6 = findViewById(R.id.btn6)
        btn6.setOnClickListener(this)

        btn7 = findViewById(R.id.btn7)
        btn7.setOnClickListener(this)

        btn8 = findViewById(R.id.btn8)
        btn8.setOnClickListener(this)

        btn9 = findViewById(R.id.btn9)
        btn9.setOnClickListener(this)

        etVisor = findViewById(R.id.etVisor)
        etVisor.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn1->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append(getString(R.string.uno))
            }
            R.id.btn2->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("2")
            }
            R.id.btn3->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("3")
            }
            R.id.btn4->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("4")
            }
            R.id.btn5->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("5")
            }
            R.id.btn6->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("6")
            }
            R.id.btn7->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("7")
            }
            R.id.btn8->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("8")
            }
            R.id.btn9->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("9")
            }

            R.id.btnMas->{
                if (!operacionPendiente){
                    operacion = "suma"
                    etVisor.append("+")
                    operacionPendiente = true
                }
            }

            R.id.btnMenos->{
                if (!operacionPendiente){
                    operacion = "resta"
                    etVisor.append("-")
                    operacionPendiente = true
                }
            }

            R.id.btnIgual->{
                if (operacionPendiente){
                    val textoOperacion = etVisor.text.toString()
                    var delimitador = ""
                    when(operacion){
                        "suma"->delimitador="+"
                        "resta"->delimitador="-"
                    }

                    val operandos = textoOperacion.split(delimitador)
                    val operando1 = operandos[0].toDouble()
                    val operando2 = operandos[1].toDouble()
                    var resultado = 0.0
                    when (operacion){
                        "suma"->{
                            resultado = operando1+operando2
                        }
                        "resta"->{
                            resultado = operando1-operando2
                        }
                    }
                    etVisor.setText("${resultado}")
                    existeResultado = true

                }
            }
        }
    }

    fun limpiarPantalla(){
        etVisor.setText("")
        operacionPendiente=false
        existeResultado = false
    }
}
    
