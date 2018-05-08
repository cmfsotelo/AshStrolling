package com.example.csotelo.ashstrolling.core.data

import android.util.Log
import com.example.csotelo.ashstrolling.AshstrollingApplication
import com.example.csotelo.ashstrolling.core.PokemonRestAPI
import com.example.csotelo.ashstrolling.core.data.entities.Pokemon
import com.example.csotelo.ashstrolling.core.data.entities.PokemonType
import com.example.csotelo.ashstrolling.core.data.entities.PokemonTypeJoin
import com.example.csotelo.ashstrolling.core.data.json.PokemonTypeSlot
import com.google.gson.Gson
import io.reactivex.Observable
import java.net.URL


class DbUtils {
    companion object {

        fun getPokemonObservable(index: Int): Observable<Pokemon> {
            return Observable.create { emitter -> emitter.onNext(getPokemon(index)) }
        }

        fun getAllPokemonsObservable(): Observable<Pokemon> {
            return Observable.create { emitter -> for (i in 1..800) emitter.onNext(getPokemon(i)) }
        }

        fun getPokemonsListObservable(indexes: IntArray): Observable<Pokemon> {
            return Observable.create { emitter -> for (i in indexes) emitter.onNext(getPokemon(i)) }
        }

        fun getPokemonsList(indexes: List<Int>): List<Pokemon> {
            return indexes.map { i -> getPokemon(i) }
        }

        fun getPokemon(index: Int): Pokemon {
            val db = PokemonDataBase.getInstance(AshstrollingApplication.context!!)
            val pokemonDao = db.pokemonDao()
            var pokemon: Pokemon = pokemonDao.getPokemon(index)
            if (pokemon == null) {
                val pok = getPokemonRest(index)
                pokemon = Pokemon.convert(pok!!)
                pokemonDao.insert(pokemon)
                //treat types
                for (slot: PokemonTypeSlot in pok.types) {
                    slot.type.url = slot.type.url // FIXME ID IS MISSING, thats why url must be refreshed
                    val pokemonType = getPokemonType(slot.type)
                    db.pokemonTypeJoinDao().insert(PokemonTypeJoin(pokemon.id, pokemonType.id))
                }
                Log.i("NEWPOKEMON", "Got new pokemon #${pokemon.id} -> ${pokemon.name}")
            } else {
                Log.i("OldPokemon", "Got  pokemon #${pokemon.id} -> ${pokemon.name}")
            }
            return pokemon
        }

        fun getPokemonType(type: com.example.csotelo.ashstrolling.core.data.json.PokemonType): PokemonType {
            val db = PokemonDataBase.getInstance(AshstrollingApplication.context!!)
            val pokemonTypeDao = db.pokemonTypeDao()
            var pokemonType: PokemonType = pokemonTypeDao.getType(type.id)
            if (pokemonType == null) {
                pokemonType = PokemonType(type.id, type.name, type.url)
                pokemonTypeDao.insert(pokemonType)
            }
            return pokemonType
        }

        fun getPokemonType(index: Int): PokemonType {
            val db = PokemonDataBase.getInstance(AshstrollingApplication.context!!)
            val pokemonTypeDao = db.pokemonTypeDao()
            var pokemonType: PokemonType = pokemonTypeDao.getType(index)
            if (pokemonType == null) {
                pokemonTypeDao.insert(PokemonType.convert(getPokemonTypeRest(index)!!))
            }
            return pokemonType
        }

        fun getPokemonRest(index: Int): com.example.csotelo.ashstrolling.core.data.json.Pokemon? {
            val pokeAsString: String = URL(PokemonRestAPI.POKEMON_URL + index).readText()
            val pok = Gson().fromJson(pokeAsString, com.example.csotelo.ashstrolling.core.data.json.Pokemon::class.java)
            pok.spriteUrl = "${PokemonRestAPI.POKEMON_FRONT_DEFAULT_URL}${pok.id}.png"
            return pok
        }

        fun getPokemonTypeRest(index: Int): com.example.csotelo.ashstrolling.core.data.json.PokemonType? {
            val pokeTypeAsString: String = URL(PokemonRestAPI.POKEMON_TYPE_URL + index).readText()
            var retVal = Gson().fromJson(pokeTypeAsString, com.example.csotelo.ashstrolling.core.data.json.PokemonType::class.java)
            retVal.url = retVal.url
            return retVal
        }
    }
}