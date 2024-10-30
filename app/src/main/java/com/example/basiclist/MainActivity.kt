package com.example.basiclist

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputNumber = findViewById<EditText>(R.id.inputNumber)
        val radioEven = findViewById<RadioButton>(R.id.radioEven)
        val radioOdd = findViewById<RadioButton>(R.id.radioOdd)
        val radioPerfectSquare = findViewById<RadioButton>(R.id.radioPerfectSquare)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        btnCalculate.setOnClickListener {
            val n = inputNumber.text.toString().toIntOrNull()

            if (n == null || n < 0) {
                Toast.makeText(this, "Vui lòng nhập số nguyên dương", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val result = when {
                radioEven.isChecked -> getEvenNumbers(n)
                radioOdd.isChecked -> getOddNumbers(n)
                radioPerfectSquare.isChecked -> getPerfectSquareNumbers(n)
                else -> ""
            }

            txtResult.text = result
        }
    }
    private fun getEvenNumbers(n: Int): String {
        return (0..n).filter { it % 2 == 0 }.joinToString(", ")
    }

    private fun getOddNumbers(n: Int): String {
        return (0..n).filter { it % 2 != 0 }.joinToString(", ")
    }

    private fun getPerfectSquareNumbers(n: Int): String {
        return (0..n).filter { isPerfectSquare(it) }.joinToString(", ")
    }

    private fun isPerfectSquare(num: Int): Boolean {
        val root = sqrt(num.toDouble()).toInt()
        return root * root == num
    }
}
