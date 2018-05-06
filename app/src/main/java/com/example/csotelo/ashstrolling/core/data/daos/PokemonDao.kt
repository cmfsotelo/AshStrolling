package com.example.csotelo.ashstrolling.core.data.daos

import android.arch.paging.LivePagedListProvider
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.support.annotation.VisibleForTesting
import com.example.csotelo.ashstrolling.core.data.entities.Pokemon

import java.lang.reflect.Modifier.PRIVATE

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemon ORDER BY id ASC")
    fun getAllPokemons(): LivePagedListProvider<Int, Pokemon>

    @Query("SELECT * FROM pokemon WHERE id = :index")
    fun getPokemon(index: Int): Pokemon

    @VisibleForTesting(otherwise = PRIVATE)
    @Query("SELECT COUNT(*) FROM pokemon")
    fun count(): Int?

    @Insert
    fun insert(vararg pokemons: Pokemon)

    @VisibleForTesting(otherwise = PRIVATE)
    @Query("DELETE FROM pokemon")
    fun deleteAll()
}
