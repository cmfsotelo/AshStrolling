package com.example.csotelo.ashstrolling

import com.example.csotelo.ashstrolling.core.data.PokemonDataBase

class TestUtils {
    companion object {

        fun cleanPokemonDb(db: PokemonDataBase) {
            db.pokemonTypeJoinDao().deleteAll()
            db.pokemonDao().deleteAll()
            db.pokemonTypeDao().deleteAll()
        }

    }
}
