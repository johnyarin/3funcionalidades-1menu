package com.example.tarea2.ejercicio3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tarea2.databinding.FragmentWebsiteDetailBinding

class WebsiteDetailFragment : Fragment() {
    private var _binding: FragmentWebsiteDetailBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWebsiteDetailBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    fun updateWebsiteDetails(website: Website) {
        with(binding) {
            // Parte superior: Nombre de la web
            tvSelectedItem.text = website.name
            // Parte inferior: Detalles de la web
            ivWebsite.setImageResource(website.imageResId)
            tvWebsiteUrl.text = website.url
            tvWebsiteDescription.text = website.description
            tvWebsiteEmail.text = website.email

            containerDetails.visibility = View.VISIBLE
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}