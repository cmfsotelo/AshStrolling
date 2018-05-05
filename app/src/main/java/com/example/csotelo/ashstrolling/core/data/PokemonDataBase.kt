package com.example.csotelo.ashstrolling.core.data


import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.csotelo.ashstrolling.core.data.daos.PokemonDao
import com.example.csotelo.ashstrolling.core.data.daos.PokemonTypeDao
import com.example.csotelo.ashstrolling.core.data.daos.PokemonTypeJoinDao
import com.example.csotelo.ashstrolling.core.data.entities.Pokemon
import com.example.csotelo.ashstrolling.core.data.entities.PokemonType
import com.example.csotelo.ashstrolling.core.data.entities.PokemonTypeJoin

@Database(entities = arrayOf(Pokemon::class, PokemonType::class, PokemonTypeJoin::class), version = 1)
abstract class PokemonDataBase : RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao
    abstract fun pokemonTypeDao(): PokemonTypeDao
    abstract fun pokemonTypeJoinDao(): PokemonTypeJoinDao

    companion object {

        private const val POKEMON_DB = "pokemon.db"
        private var pokemonDB: PokemonDataBase? = null

        fun getInstance(context: Context): PokemonDataBase {
            if (pokemonDB == null) {
                pokemonDB = Room.databaseBuilder(context.applicationContext, PokemonDataBase::class.java, POKEMON_DB).build()
            }
            return pokemonDB as PokemonDataBase
        }
    }
}
