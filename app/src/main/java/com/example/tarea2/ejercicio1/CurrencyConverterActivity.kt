package com.example.tarea2.ejercicio1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tarea2.databinding.ActivityCurrencyConverterBinding

class CurrencyConverterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCurrencyConverterBinding
    private val DOLLAR_TO_EURO_RATE = 0.85
    private val EURO_TO_DOLLAR_RATE = 1.2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCurrencyConverterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupTextWatchers()
    }
    private fun setupTextWatchers() {
        binding.etDolar.addTextChangedListener(SimpleTextWatcher {
            if (binding.rbDolEur.isChecked) {
                convertDollarToEuro()
            }
        })

        binding.etEuro.addTextChangedListener(SimpleTextWatcher {
            if (binding.rbEurDol.isChecked) {
                convertEuroToDollar()
            }
        })
    }
    private fun convertDollarToEuro() {
        try {
            val dollarText = binding.etDolar.text.toString()
            if (dollarText.isNotEmpty()) {
                val dollar = dollarText.toDouble()
                val euro = dollar * DOLLAR_TO_EURO_RATE
                binding.etCambio.setText(String.format("%.2f", euro))
            } else {
                binding.etCambio.text.clear()
            }
        } catch (e: Exception) {
            binding.etCambio.text.clear()
        }
    }
    private fun convertEuroToDollar() {
        try {
            val euroText = binding.etEuro.text.toString()
            if (euroText.isNotEmpty()) {
                val euro = euroText.toDouble()
                val dollar = euro * EURO_TO_DOLLAR_RATE
                binding.etCambio.setText(String.format("%.2f", dollar))
            } else {
                binding.etCambio.text.clear()
            }
        } catch (e: Exception) {
            binding.etCambio.text.clear()
        }
    }
    class SimpleTextWatcher(val afterTextChanged: (() -> Unit)) : android.text.TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: android.text.Editable?) = afterTextChanged()
    }
}