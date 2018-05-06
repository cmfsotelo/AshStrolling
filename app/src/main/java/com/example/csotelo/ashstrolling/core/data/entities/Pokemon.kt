package com.example.csotelo.ashstrolling.core.data.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.v7.recyclerview.extensions.DiffCallback

@Entity
class Pokemon(@field:PrimaryKey
              @field:ColumnInfo(name = "id")
              var id: Int,
              @field:ColumnInfo(name = "order")
              var order: Int,
              @field:ColumnInfo(name = "name")
              var name: String,
              @field:ColumnInfo(name = "weight")
              var weight: Float,
              @field:ColumnInfo(name = "height")
              var height: Float) {
    companion object {

        val DIFF_CALLBACK: DiffCallback<Pokemon> = object : DiffCallback<Pokemon>() {
            override fun areItemsTheSame(oldPokemon: Pokemon, newPokemon: Pokemon): Boolean {
                return oldPokemon.id == newPokemon.id
            }

            override fun areContentsTheSame(oldPokemon: Pokemon, newPokemon: Pokemon): Boolean {
                return oldPokemon.name == newPokemon.name
            }
        }

        fun convert(pokemon: com.example.csotelo.ashstrolling.core.data.json.Pokemon): Pokemon {
            return Pokemon(pokemon.id, pokemon.order, pokemon.name, pokemon.weight, pokemon.height)
        }
    }
}
