package com.example.tarea2.ejercicio3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tarea2.databinding.FragmentWebsiteListBinding

class WebsiteListFragment : Fragment() {
    private var _binding: FragmentWebsiteListBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: WebsiteAdapter
    private var listener: OnWebsiteSelectedListener? = null
    interface OnWebsiteSelectedListener {
        fun onWebsiteSelected(website: Website)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWebsiteListBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = WebsiteAdapter(WebsiteProvider.websiteList) { website ->
            (activity as? OnWebsiteSelectedListener)?.onWebsiteSelected(website)
        }
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@WebsiteListFragment.adapter
        }
    }
    override fun onAttach(context: android.content.Context) {
        super.onAttach(context)
        listener = context as? OnWebsiteSelectedListener
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}