package com.example.tarea2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.tarea2.ejercicio1.CurrencyConverterActivity
import com.example.tarea2.ejercicio2.WebListActivity
import com.example.tarea2.ejercicio3.TwoFragmentActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEjercicio1 = findViewById<Button>(R.id.btnEjercicio1)
        val btnEjercicio2 = findViewById<Button>(R.id.btnEjercicio2)
        val btnEjercicio3 = findViewById<Button>(R.id.btnEjercicio3)



        btnEjercicio1.setOnClickListener {
            val intent = Intent(this, CurrencyConverterActivity::class.java)
            startActivity(intent)
        }
        btnEjercicio2.setOnClickListener {
            val intent = Intent(this, WebListActivity::class.java)
            startActivity(intent)
        }
        btnEjercicio3.setOnClickListener {
            val intent = Intent(this, TwoFragmentActivity::class.java)
            startActivity(intent)
        }
    }
    }
