package com.example.csotelo.ashstrolling.core.data.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.v7.recyclerview.extensions.DiffCallback
import com.example.csotelo.ashstrolling.core.data.json.PokemonTypeSlot

@Entity(tableName = "pokemon_type")
class PokemonType(@field:PrimaryKey
                  @field:ColumnInfo(name = "id")
                  var id: Int,
                  @field:ColumnInfo(name = "url")
                  var url: String,
                  @field:ColumnInfo(name = "name")
                  var name: String) {
    companion object {

        val DIFF_CALLBACK: DiffCallback<PokemonType> = object : DiffCallback<PokemonType>() {
            override fun areItemsTheSame(oldPokemon: PokemonType, newPokemon: PokemonType): Boolean {
                return oldPokemon.id == newPokemon.id
            }

            override fun areContentsTheSame(oldPokemon: PokemonType, newPokemon: PokemonType): Boolean {
                return oldPokemon.name == newPokemon.name
            }
        }

        fun convert(pokemonType: com.example.csotelo.ashstrolling.core.data.json.PokemonType): PokemonType {
            return PokemonType(pokemonType.id, pokemonType.name, pokemonType.url)
        }

        fun convert(pokemonTypeSlot: PokemonTypeSlot): PokemonType {
            val pokemonType = pokemonTypeSlot.type
            return PokemonType(pokemonType.id, pokemonType.name, pokemonType.url)
        }
    }
}
