package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvResult: TextView
    private var operand1 = ""
    private var operator = ""
    private var lastButtonWasOperator = false

    companion object {
        private const val OPERAND1_KEY = "operand1"
        private const val OPERATOR_KEY = "operator"
        private const val LAST_BUTTON_KEY = "lastButtonWasOperator"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tvResult)

        val buttons = arrayOf(
            findViewById<Button>(R.id.btn0), findViewById(R.id.btn1), findViewById(R.id.btn2),
            findViewById(R.id.btn3), findViewById(R.id.btn4), findViewById(R.id.btn5),
            findViewById(R.id.btn6), findViewById(R.id.btn7), findViewById(R.id.btn8),
            findViewById(R.id.btn9), findViewById(R.id.btnAdd), findViewById(R.id.btnSubtract),
            findViewById(R.id.btnMultiply), findViewById(R.id.btnDivide),
            findViewById(R.id.btnClear), findViewById(R.id.btnEquals)
        )
        for (button in buttons) {
            button.setOnClickListener(this)
        }

        // Restaurar el estado si existe
        savedInstanceState?.let {
            operand1 = it.getString(OPERAND1_KEY, "")
            operator = it.getString(OPERATOR_KEY, "")
            lastButtonWasOperator = it.getBoolean(LAST_BUTTON_KEY, false)
            tvResult.text = operand1
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(OPERAND1_KEY, operand1)
        outState.putString(OPERATOR_KEY, operator)
        outState.putBoolean(LAST_BUTTON_KEY, lastButtonWasOperator)
    }

    override fun onClick(v: View?) {
        val button = v as Button // Se convierte la vista en un botón
        when (button.id) { // Se manejan las acciones para cada botón según su id
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9 -> appendDigit(button.text.toString())
            R.id.btnAdd, R.id.btnSubtract, R.id.btnMultiply, R.id.btnDivide -> setOperator(button.text.toString())
            R.id.btnEquals -> calculateResult()
            R.id.btnClear -> clear()
        }
    }

    // Para añadir un dígito al resultado
    private fun appendDigit(digit: String) {
        if (lastButtonWasOperator) {
            tvResult.text = ""
        }
        tvResult.append(digit)
        lastButtonWasOperator = false
    }

    // Para decidir qué operador usar
    private fun setOperator(op: String) {
        if (tvResult.text.isNotEmpty()) {
            operand1 = tvResult.text.toString()
            operator = op
            lastButtonWasOperator = true
        }
    }

    // Resultado de operación
    private fun calculateResult() {
        if (operand1.isNotEmpty() && operator.isNotEmpty() && tvResult.text.isNotEmpty()) {
            val operand2 = tvResult.text.toString()
            val result = when (operator) {
                "+" -> operand1.toInt() + operand2.toInt()
                "-" -> operand1.toInt() - operand2.toInt()
                "*" -> operand1.toInt() * operand2.toInt()
                "/" -> operand1.toInt() / operand2.toInt()
                else -> 0
            }
            tvResult.text = result.toString()
            operand1 = ""
            operator = ""
        }
    }

    // Método para reiniciar la calculadora
    private fun clear() {
        operand1 = ""
        operator = ""
        tvResult.text = "0"
        lastButtonWasOperator = false
    }
}

