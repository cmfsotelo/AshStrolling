package com.example.csotelo.ashstrolling.core.data.json

data class Pokemon(val id: Int,
                   val order: Int,
                   val name: String,
                   val weight: Float,
                   val height: Float,
                   val types: Array<PokemonTypeSlot>)