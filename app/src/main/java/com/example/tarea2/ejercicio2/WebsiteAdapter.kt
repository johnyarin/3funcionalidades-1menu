package com.example.tarea2.ejercicio2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea2.databinding.ItemWebsiteBinding

class WebsiteAdapter(
    private val websiteList: List<Website>,
    private val onClickListener: (Website) -> Unit
) : RecyclerView.Adapter<WebsiteAdapter.WebsiteViewHolder>() {
    class WebsiteViewHolder(val binding: ItemWebsiteBinding) :
        RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WebsiteViewHolder {
        val binding = ItemWebsiteBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return WebsiteViewHolder(binding)
    }
    override fun onBindViewHolder(holder: WebsiteViewHolder, position: Int) {
        val website = websiteList[position]
        with(holder.binding) {
            tvWebsiteName.text = website.name
            tvWebsiteUrl.text = website.url
            tvWebsiteDescription.text = website.description
            tvWebsiteEmail.text = website.email
            ivWebsite.setImageResource(website.imageResId)
            root.setOnClickListener {
                onClickListener(website)
            }
        }
    }
    override fun getItemCount(): Int = websiteList.size
}
