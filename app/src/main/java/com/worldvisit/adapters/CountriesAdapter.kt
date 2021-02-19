package com.worldvisit.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.worldvisit.R
import com.worldvisit.bdd.AppDatabaseHelper
import com.worldvisit.bdd.CountryDTO
import com.worldvisit.webservice.RetourWSGetCountry

class CountriesAdapter(private var listCountries: List<RetourWSGetCountry>) :
RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder>()
{
    // Crée chaque vue item à afficher :
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder
    {
        val viewCourse = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_country, parent, false)
        return CountriesViewHolder(viewCourse)
    }
    // Renseigne le contenu de chaque vue item :
    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int)
    {
        holder.textViewNameCountry.text = listCountries[position].name
    }
    override fun getItemCount(): Int = listCountries.size
    // ViewHolder :
    inner class CountriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val textViewNameCountry: TextView = itemView.findViewById(R.id.name_country)
        init
        {
            textViewNameCountry.setOnClickListener {
                val country = listCountries[adapterPosition]
                Log.d("montag", country.name)
                // AJOUTER PAYS EN BASE
                // AppDatabaseHelper.getDatabase(this).countryDAO().insert(CountryDTO(0, country.name, country.capital, country.region, country.alphaCode))

            }
        }
    }
}