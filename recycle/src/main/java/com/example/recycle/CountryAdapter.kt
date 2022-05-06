package com.example.recycle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(private val countries: List<String>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(){

    override fun getItemCount() = countries.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder{
        val items = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle_items,parent,false)
        return CountryViewHolder(items)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int){
        holder.country.text = countries[position]
    }

    inner class CountryViewHolder(view: View): RecyclerView.ViewHolder(view){
        val country: TextView = view.findViewById(R.id.item_text)
    }
}