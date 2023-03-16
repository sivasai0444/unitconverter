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
            if(binding.spinner1.selectedItem.toString()=="K" && binding.spinner2.selectedItem.toString()=="M"){
                binding.textView2.text = (binding.editText1.editableText.toString().toDouble()*1000.0).toString()
            }
            else if(binding.spinner1.selectedItem.toString()=="K" && binding.spinner2.selectedItem.toString()=="CM"){
                binding.textView2.text = (binding.editText1.editableText.toString().toDouble()*100000.0).toString()
            }
            else if(binding.spinner1.selectedItem.toString()=="K" && binding.spinner2.selectedItem.toString()=="IN"){
                binding.textView2.text = (binding.editText1.editableText.toString().toDouble()*39370.1).toString()
            }
            else if(binding.spinner1.selectedItem.toString()=="M" && binding.spinner2.selectedItem.toString()=="CM"){
                binding.textView2.text = (binding.editText1.editableText.toString().toDouble()*100.0).toString()
            }
            else if(binding.spinner1.selectedItem.toString()=="M" && binding.spinner2.selectedItem.toString()=="IN"){
                binding.textView2.text = (binding.editText1.editableText.toString().toDouble()*39.3701).toString()
            }
            else if(binding.spinner1.selectedItem.toString()=="M" && binding.spinner2.selectedItem.toString()=="KM"){
                binding.textView2.text = (binding.editText1.editableText.toString().toDouble()*0.001).toString()
            }
            else if(binding.spinner1.selectedItem.toString()=="CM" && binding.spinner2.selectedItem.toString()=="IN"){
                binding.textView2.text = (binding.editText1.editableText.toString().toDouble()*0.393701).toString()
            }
            else if(binding.spinner1.selectedItem.toString()=="CM" && binding.spinner2.selectedItem.toString()=="M"){
                binding.textView2.text = (binding.editText1.editableText.toString().toDouble()*0.01).toString()
            }
            else if(binding.spinner1.selectedItem.toString()=="CM" && binding.spinner2.selectedItem.toString()=="KM"){
                binding.textView2.text = (binding.editText1.editableText.toString().toDouble()*0.00001).toString()
            }
            else if(binding.spinner1.selectedItem.toString()=="IN" && binding.spinner2.selectedItem.toString()=="KM"){
                binding.textView2.text = (binding.editText1.editableText.toString().toDouble()*0.0000254).toString()
            }
            else if(binding.spinner1.selectedItem.toString()=="IN" && binding.spinner2.selectedItem.toString()=="CM"){
                binding.textView2.text = (binding.editText1.editableText.toString().toDouble()*2.54).toString()
            }
            else if(binding.spinner1.selectedItem.toString()=="IN" && binding.spinner2.selectedItem.toString()=="M"){
                binding.textView2.text = (binding.editText1.editableText.toString().toDouble()*0.0254).toString()
            }
            else if(binding.spinner1.selectedItem.toString()=="L" && binding.spinner2.selectedItem.toString()=="ML"){
                binding.textView2.text = (binding.editText1.editableText.toString().toDouble()*1000).toString()
            }
            else if(binding.spinner1.selectedItem.toString()=="L" && binding.spinner2.selectedItem.toString()=="BBL"){
                binding.textView2.text = (binding.editText1.editableText.toString().toDouble()*0.00628981).toString()
            }

            else if(binding.spinner1.selectedItem.toString()=="ML" && binding.spinner2.selectedItem.toString()=="L"){
                binding.textView2.text = (binding.editText1.editableText.toString().toDouble()*0.001).toString()
            }
            else if(binding.spinner1.selectedItem.toString()=="ML" && binding.spinner2.selectedItem.toString()=="BBL"){
                binding.textView2.text = (binding.editText1.editableText.toString().toDouble()*6.28981).toString()
            }else if(binding.spinner1.selectedItem.toString()=="BBL" && binding.spinner2.selectedItem.toString()=="ML"){
                binding.textView2.text = (binding.editText1.editableText.toString().toDouble()*158987).toString()
            }
            else if(binding.spinner1.selectedItem.toString()=="BBL" && binding.spinner2.selectedItem.toString()=="L"){
                binding.textView2.text = (binding.editText1.editableText.toString().toDouble()*158.987).toString()
            }

        }

    }

}