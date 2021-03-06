package com.example.csotelo.ashstrolling.core


class PokemonRestAPI {
    companion object {
        val BASE_URL = "https://pokeapi.co/api/"
        val V2 = "v2/"
        val POKEMON_URL = BASE_URL + V2 + "pokemon/"
        val POKEMON_FRONT_DEFAULT_URL = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"
        val POKEMON_TYPE_URL = BASE_URL + V2 + "type/"
    }
}
