package com.example.csotelo.ashstrolling.core.data.daos

import android.arch.paging.LivePagedListProvider
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.support.annotation.VisibleForTesting
import com.example.csotelo.ashstrolling.core.data.entities.Pokemon
import com.example.csotelo.ashstrolling.core.data.entities.PokemonType
import com.example.csotelo.ashstrolling.core.data.entities.PokemonTypeJoin

import java.lang.reflect.Modifier.PRIVATE

@Dao
interface PokemonTypeJoinDao {

    @Query("SELECT * FROM pokemon_type INNER JOIN pokemon_type_join ON pokemon_type.id = pokemon_type_join.typeId WHERE pokemonId = :index")
    fun getTypesForPokemon(index: Int): LivePagedListProvider<Int, PokemonType>

    @Query("SELECT * FROM pokemon INNER JOIN pokemon_type_join ON pokemon.id = pokemon_type_join.typeId WHERE typeId = :index")
    fun getPokemonsOfType(index: Int): LivePagedListProvider<Int, Pokemon>

    @VisibleForTesting(otherwise = PRIVATE)
    @Query("SELECT COUNT(*) FROM pokemon_type_join")
    fun count(): Int?

    @Insert
    fun insert(vararg pokemonTypeJoin: PokemonTypeJoin)

    @VisibleForTesting(otherwise = PRIVATE)
    @Query("DELETE FROM pokemon_type_join")
    fun deleteAll()
}
