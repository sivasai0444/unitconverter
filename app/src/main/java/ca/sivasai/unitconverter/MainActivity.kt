package ca.sivasai.unitconverter

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import ca.sivasai.unitconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var items= arrayListOf("Select A Value")
        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner2.adapter=adapter
        binding.spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                when (position) {
                    0 -> {
                        items.clear()
                        items.add("M")
                        items.add("CM")
                        items.add("IN")
                        adapter.notifyDataSetChanged()
                    }
                    1 -> {
                        items.clear()
                        items.add("KM")
                        items.add("CM")
                        items.add("IN")
                        adapter.notifyDataSetChanged()
                    }
                    2 -> {
                        items.clear()
                        items.add("KM")
                        items.add("M")
                        items.add("IN")
                        adapter.notifyDataSetChanged()
                    }
                    3 -> {
                        items.clear()
                        items.add("KM")
                        items.add("M")
                        items.add("CM")
                        adapter.notifyDataSetChanged()
                    }
                    4 -> {
                        items.clear()
                        items.add("ML")
                        items.add("BBL")
                        adapter.notifyDataSetChanged()
                    }
                    5 -> {
                        items.clear()
                        items.add("L")
                        items.add("BBL")
                        adapter.notifyDataSetChanged()
                    }
                    6 -> {
                        items.clear()
                        items.add("L")
                        items.add("ML")
                        adapter.notifyDataSetChanged()
                    }
                    7 -> {
                        items.clear()
                        items.add("G")
                        items.add("LB")
                        adapter.notifyDataSetChanged()
                    }
                    8 -> {
                        items.clear()
                        items.add("KG")
                        items.add("LB")
                        adapter.notifyDataSetChanged()
                    }
                    9 -> {
                        items.clear()
                        items.add("KG")
                        items.add("G")
                        adapter.notifyDataSetChanged()
                    }
                    10 -> {
                        items.clear()
                        items.add("C")
                        items.add("F")
                        adapter.notifyDataSetChanged()
                    }
                    11 -> {
                        items.clear()
                        items.add("K")
                        items.add("F")
                        adapter.notifyDataSetChanged()
                    }
                    12 -> {
                        items.clear()
                        items.add("K")
                        items.add("C")
                        adapter.notifyDataSetChanged()
                    }
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }
        binding.submit.setOnClickListener {
            val input = binding.editText1.text.toString().toDoubleOrNull()

            if (input == null) {
                binding.textView2.text = ""
                return@setOnClickListener
            }

            val fromUnit = binding.spinner1.selectedItem.toString()
            val toUnit = binding.spinner2.selectedItem.toString()
            var result = input

            when (fromUnit) {
                "KM" -> {
                    when (toUnit) {
                        "M" -> result *= 1000.0
                        "CM" -> result *= 100000.0
                        "IN" -> result *= 39370.1
                    }
                }
                "M" -> {
                    when (toUnit) {
                        "CM" -> result *= 100.0
                        "IN" -> result *= 39.3701
                        "KM" -> result *= 0.001
                    }
                }
                "CM" -> {
                    when (toUnit) {
                        "IN" -> result *= 0.393701
                        "M" -> result *= 0.01
                        "KM" -> result *= 0.00001
                    }
                }
                "IN" -> {
                    when (toUnit) {
                        "KM" -> result *= 0.0000254
                        "CM" -> result *= 2.54
                        "M" -> result *= 0.0254
                    }
                }
                "L" -> {
                    when (toUnit) {
                        "ML" -> result *= 1000.0
                        "BBL" -> result *= 0.00628981
                    }
                }
                "ML" -> {
                    when (toUnit) {
                        "L" -> result *= 0.001
                        "BBL" -> result *= 6.28981
                    }
                }
                "BBL" -> {
                    when (toUnit) {
                        "L" -> result *= 158.987
                        "ML" -> result *= 158987.0
                    }
                }
                "KG" -> {
                    when (toUnit) {
                        "G" -> result *=1000
                        "LB" -> result *= 2.20462
                    }
                }
                "G" -> {
                    when (toUnit) {
                        "KG" -> result *= 0.001
                        "LB" -> result *= 0.00220462
                    }
                }
                "LB" -> {
                    when (toUnit) {
                        "G" -> result *= 453.592
                        "KG" -> result *= 0.453592
                    }
                }
                "K" -> {
                    when (toUnit) {
                        "C" -> result-=273.15
                        "F" -> result = (result- 273.15) *9/5 +32
                    }
                }
                "C" -> {
                    when (toUnit) {
                        "K" -> result +=273.15
                        "F" -> result = result *9/5 +32
                    }
                }
                "F" -> {
                    when (toUnit) {
                        "C" -> result = (result - 32)* 5/9
                        "K" -> result =(result - 32) * 5/9 + 273.15
                    }
                }
            }

            binding.textView2.text = result.toString()
        }


    }

}