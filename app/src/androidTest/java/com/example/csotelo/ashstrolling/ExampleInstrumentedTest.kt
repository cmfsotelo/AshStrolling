package com.example.csotelo.ashstrolling

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.example.csotelo.ashstrolling.core.PokemonRestAPI
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
        assertEquals("com.example.csotelo.ashstrolling", appContext.packageName)
    }

    @Test
    fun testPokemonAPI() {
        // Context of the app under test.
        val poke = testGetPokemon(212) as Pokemon
        assertEquals("scythor", poke.name)
    }

    fun testGetPokemon(index: Int): Pokemon {
        var pokemon: Pokemon = PokemonDataBase.getInstance(AshstrollingApplication.context!!).pokemonDao().getPokemon(0)
        if (pokemon == null) {
            val pokeAsString: String = URL(PokemonRestAPI.POKEMON_URL + index).readText()
            val pok = Gson().fromJson(pokeAsString, com.example.csotelo.ashstrolling.core.data.json.Pokemon::class.java)
            pokemon = Pokemon.convert(pok)
        }
        return pokemon;
    }
}
