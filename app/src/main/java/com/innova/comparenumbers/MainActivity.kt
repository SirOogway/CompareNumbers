package com.innova.comparenumbers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.innova.comparenumbers.databinding.ActivityMainBinding
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

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
                    Toast.makeText(
                        this@MainActivity,
                        "Ingrese todos los campos",
                        Toast.LENGTH_SHORT
                    ).show()
                }
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