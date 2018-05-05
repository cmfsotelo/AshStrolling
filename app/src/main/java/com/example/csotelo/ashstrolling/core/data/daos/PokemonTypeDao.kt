package com.example.csotelo.ashstrolling.core.data.daos

import android.arch.paging.LivePagedListProvider
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.support.annotation.VisibleForTesting
import com.example.csotelo.ashstrolling.core.data.entities.PokemonType

import java.lang.reflect.Modifier.PRIVATE

@Dao
interface PokemonTypeDao {

    @Query("SELECT * FROM pokemon_type ORDER BY id ASC")
    fun types(): LivePagedListProvider<Int, PokemonType>

    @Query("SELECT * FROM pokemon_type WHERE id = :index")
    fun getType(index: Int): PokemonType

    @VisibleForTesting(otherwise = PRIVATE)
    @Query("SELECT COUNT(*) FROM pokemon_type")
    fun typesCount(): Int?

    @Insert
    fun insert(vararg pokemons: PokemonType)

    @VisibleForTesting(otherwise = PRIVATE)
    @Query("DELETE FROM pokemon_type")
    fun deleteAll()
}
