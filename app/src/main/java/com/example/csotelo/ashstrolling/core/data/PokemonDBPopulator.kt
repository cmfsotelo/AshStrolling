package com.example.csotelo.ashstrolling.core.data


import android.content.Context
import android.util.Log

import com.example.csotelo.ashstrolling.R
import com.example.csotelo.ashstrolling.core.data.entities.Pokemon

import java.util.ArrayList

import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PokemonDBPopulator private constructor(private val context: Context) {

//    fun populateDB() {
//        Completable.fromAction { PokemonDataBase.getInstance(context).pokemonDao().insert(*pokemonList()) }
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ this.onDBPopulationSuccess() }, { this.onDBPopulationFailure(it) })
//    }


//
//    private fun pokemonList(): Array<Pokemon> {
//        val pokemons = ArrayList<Pokemon>()
//        val pokemonNames = context.resources.getStringArray(R.array.pokemon_names)
//        for (i in pokemonNames.indices)
//            pokemons.add(Pokemon(i + 1, pokemonNames[i]))
//        return pokemons.toTypedArray()
//    }

    private fun onDBPopulationSuccess() {
        Log.d(TAG, "Pokemons inserted successfully")
    }

    private fun onDBPopulationFailure(t: Throwable) {
        Log.e(TAG, "Pokemons failed to be inserted, error:" + t.message)
    }

    companion object {

        private val TAG = PokemonDBPopulator::class.java.name

        fun with(context: Context): PokemonDBPopulator {
            return PokemonDBPopulator(context)
        }
    }
}
