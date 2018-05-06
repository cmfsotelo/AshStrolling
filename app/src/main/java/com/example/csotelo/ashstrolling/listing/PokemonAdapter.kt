package com.example.csotelo.ashstrolling.listing


import android.arch.paging.PagedListAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.csotelo.ashstrolling.AshstrollingApplication

import com.example.csotelo.ashstrolling.R
import com.example.csotelo.ashstrolling.core.data.entities.Pokemon


class PokemonAdapter : PagedListAdapter<Pokemon, PokemonViewHolder>(Pokemon.DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val itemView = LayoutInflater.from(AshstrollingApplication.context).inflate(R.layout.item_pokemon, parent, false)
        return PokemonViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = getItem(position)

        if (pokemon != null) {
            holder.bindTo(pokemon)
        } else {
            holder.clear()
        }
    }
}
