package com.example.tarea2.ejercicio2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea2.R
import com.example.tarea2.databinding.ActivityWebListBinding
import com.google.android.material.snackbar.Snackbar
class WebListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebListBinding
    private val websiteList = WebsiteProvider.websiteList.toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        initSwipe()
        setupButton()
    }
    private fun initRecyclerView() {
        binding.recyclerWebsites.layoutManager = LinearLayoutManager(this)
        binding.recyclerWebsites.adapter = WebsiteAdapter(websiteList) { website ->
            // Click: mostrar descripción y email
            AlertDialog.Builder(this)
                .setTitle(website.name)
                .setMessage("${website.description}\n\nEmail: ${website.email}")
                .setPositiveButton("Aceptar", null)
                .show()
        }
    }
    private fun initSwipe() {
        // Swipe para borrar (muy simple)
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ) = false
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val deleted = websiteList[position]
                websiteList.removeAt(position)
                binding.recyclerWebsites.adapter?.notifyItemRemoved(position)
                Snackbar.make(binding.root, "Borrado: ${deleted.name}", Snackbar.LENGTH_LONG)
                    .setAction("Deshacer") {
                        websiteList.add(position, deleted)
                        binding.recyclerWebsites.adapter?.notifyItemInserted(position)
                    }
                    .show()
            }
        }).attachToRecyclerView(binding.recyclerWebsites)
    }
    private fun setupButton() {
        binding.btnAdd.setOnClickListener {
            // Botón simple que solo muestra un mensaje
            Toast.makeText(this, "Nueva Web añadida",
                Toast.LENGTH_SHORT).show()

            // Para ser completo pero SIMPLE, añadimos uno fijo
            val newWebsite = Website(
                "Nueva Web",
                "https://ejemplo.com",
                "Descripción de ejemplo",
                "email@ejemplo.com",
                R.drawable.ejemplo
            )
            websiteList.add(newWebsite)
            binding.recyclerWebsites.adapter?.notifyItemInserted(websiteList.size - 1)
        }
    }
}