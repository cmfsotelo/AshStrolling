package com.example.csotelo.ashstrolling.core.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey

@Entity(tableName = "pokemon_type_join", primaryKeys = arrayOf("pokemonId", "typeId"), foreignKeys = arrayOf(ForeignKey(entity = Pokemon::class, parentColumns = arrayOf("id"), childColumns = arrayOf("pokemonId")), ForeignKey(entity = PokemonType::class, parentColumns = arrayOf("id"), childColumns = arrayOf("typeId"))))
class PokemonTypeJoin(val pokemonId: Int, val typeId: Int)
