package com.innova.comparenumbers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.innova.comparenumbers.R
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNumberOne: EditText = findViewById(R.id.etNumberOne)
        val etNumberTwo: EditText = findViewById(R.id.etNumberTwo)
        val etNumberThree: EditText = findViewById(R.id.etNumberThree)
        val btnOrganize: Button = findViewById(R.id.btnOrganize)
        val tvResult: TextView = findViewById(R.id.tvResult)

        btnOrganize.setOnClickListener {
            try {
                val a = etNumberOne.text.toString().toDouble()
                val b = etNumberTwo.text.toString().toDouble()
                val c = etNumberThree.text.toString().toDouble()

                val numberList = listOf(a, b, c)
                val comparisonSignList = defComparativeSigns(numberList)

                tvResult.text =
                    "${numberList[0]} ${comparisonSignList[0]} ${numberList[1]} ${comparisonSignList[1]} ${numberList[2]}"

            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Ingrese todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun defComparativeSigns(list: List<Double>): Array<String?> {
        val signList = arrayOfNulls<String>(3)
        list.forEachIndexed { index, value ->
            if (index < list.lastIndex) {
                val nextValue = list[index + 1]
                signList[index] = when {
                    value > nextValue -> ">"
                    value < nextValue -> "<"
                    else -> "="
                }
            }
        }
        return signList
    }
}