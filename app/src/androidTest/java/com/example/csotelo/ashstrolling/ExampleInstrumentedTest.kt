package com.example.csotelo.ashstrolling

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.example.csotelo.ashstrolling.core.PokemonRestAPI
import com.example.csotelo.ashstrolling.core.data.PokemonDBPopulator
import com.example.csotelo.ashstrolling.core.data.PokemonDataBase
import com.example.csotelo.ashstrolling.core.data.entities.Pokemon
import com.google.gson.Gson
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import java.net.URL

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
//        PokemonDBPopulator.with(appContext).populateDB()
        val poke = testGetPokemon(212) as Pokemon
        assertEquals("com.example.csotelo.ashstrolling", appContext.packageName)
    }

    fun testGetPokemon(index: Int): Pokemon {
        var pokemon: Pokemon = PokemonDataBase.getInstance(AshstrollingApplication.context!!).pokemonDao().getPokemon(0)
        var pok: com.example.csotelo.ashstrolling.core.data.json.Pokemon;
        if (pokemon == null) {
            val pokeAsString: String = URL(PokemonRestAPI.POKEMON_URL + index).readText()
            pok = Gson().fromJson(pokeAsString, com.example.csotelo.ashstrolling.core.data.json.Pokemon::class.java)
        }
        return pokemon;
    }
}
