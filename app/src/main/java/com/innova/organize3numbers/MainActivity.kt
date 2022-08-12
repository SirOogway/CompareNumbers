package com.innova.organize3numbers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var etNumberOne: EditText = findViewById(R.id.etNumberOne)
        var etNumberTwo: EditText = findViewById(R.id.etNumberTwo)
        var etNumberThree: EditText = findViewById(R.id.etNumberThree)
        val btnOrganize: Button = findViewById(R.id.btnOrganize)
        var tvResult: TextView = findViewById(R.id.tvResult)

        btnOrganize.setOnClickListener {
            try {
                val a = etNumberOne.text.toString().toDouble()
                val b = etNumberTwo.text.toString().toDouble()
                val c = etNumberThree.text.toString().toDouble()

                val numberList = listOf(a, b, c).sorted()

                tvResult.text = """
                minor number: ${numberList[0]}
                middle number: ${numberList[1]}
                major number: ${numberList[2]}
            """.trimIndent()

                tvResult.text = "${numberList[0]} < ${numberList[1]} < ${numberList[2]}"

            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Ingrese todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}