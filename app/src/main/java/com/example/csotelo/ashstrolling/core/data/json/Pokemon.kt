package com.example.csotelo.ashstrolling.core.data.json

import com.example.csotelo.ashstrolling.core.PokemonRestAPI

data class Pokemon(val id: Int,
                   val order: Int,
                   val name: String,
                   val weight: Float,
                   val height: Float,
                   val types: Array<PokemonTypeSlot>,
                   var spriteUrl: String = "${PokemonRestAPI.POKEMON_FRONT_DEFAULT_URL}$id.png")