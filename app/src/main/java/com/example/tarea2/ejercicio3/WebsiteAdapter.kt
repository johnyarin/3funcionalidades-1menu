package com.example.tarea2.ejercicio3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea2.databinding.ItemWebsiteSimpleBinding

class WebsiteAdapter(
    private val websiteList: List<Website>,
    private val onClickListener: (Website) -> Unit
    ) : RecyclerView.Adapter<WebsiteAdapter.WebsiteViewHolder>() {
    class WebsiteViewHolder(val binding: ItemWebsiteSimpleBinding) :
        RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WebsiteViewHolder {
        val binding = ItemWebsiteSimpleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return WebsiteViewHolder(binding)
    }
    override fun onBindViewHolder(holder: WebsiteViewHolder, position: Int) {
        val website = websiteList[position]
        holder.binding.tvWebsiteName.text = website.name
        holder.binding.root.setOnClickListener {
            onClickListener(website)
        }
    }
    override fun getItemCount(): Int = websiteList.size
}