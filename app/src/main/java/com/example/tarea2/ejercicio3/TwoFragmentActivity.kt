package com.example.tarea2.ejercicio3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tarea2.R
import com.example.tarea2.databinding.ActivityTwoFragmentBinding
import com.example.tarea2.ejercicio3.WebsiteListFragment.OnWebsiteSelectedListener

class TwoFragmentActivity : AppCompatActivity(), OnWebsiteSelectedListener {
    private lateinit var binding: ActivityTwoFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwoFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupFragments()
    }
    private fun setupFragments() {
        val fragmentA = WebsiteListFragment()
        val fragmentB = WebsiteDetailFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerA, fragmentA)
            .replace(R.id.fragmentContainerB, fragmentB)
            .commit()
    }
    override fun onWebsiteSelected(website: Website) {
        val fragmentB = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerB) as WebsiteDetailFragment
        fragmentB.updateWebsiteDetails(website)
    }
}