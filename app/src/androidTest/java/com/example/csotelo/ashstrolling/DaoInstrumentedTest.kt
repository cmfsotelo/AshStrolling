package com.example.csotelo.ashstrolling

import android.support.test.runner.AndroidJUnit4
import com.example.csotelo.ashstrolling.core.data.DbUtils
import com.example.csotelo.ashstrolling.core.data.PokemonDataBase
import com.example.csotelo.ashstrolling.utils.Utils
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class DaoInstrumentedTest {
    private val db = PokemonDataBase.getInstance(AshstrollingApplication.context!!)

    @Before
    fun setupTests() {
        db.pokemonTypeJoinDao().deleteAll()
        db.pokemonDao().deleteAll()
        db.pokemonTypeDao().deleteAll()
    }

    @Test
    fun testPokemonDaoInsertion1stGen() {
        println("Pokemons cought:")
        for (i in 1..151) {
            val pok = DbUtils.getPokemon(i)
            println("#$i -> ${pok.name}")
        }
        assert(db.pokemonDao().count() == 151 && db.pokemonTypeDao().count() == 17)
    }

    @Test
    fun testPokemonDaoInsertion() {
        // Context of the app under test.
        val pok = DbUtils.getPokemon(Utils.randomInt(802))
        println(pok.name)
        assert(db.pokemonDao().count() == 1)
    }

    @Test
    fun testPokemonTypeDaoInsertion() {
        // Context of the app under test.
        val pokeType = DbUtils.getPokemonType(4)
        assertEquals("poison", pokeType.name)
    }

    @Test
    fun testPokemonDaoInsertionRandomList() {
        // Context of the app under test.
        TestUtils.cleanPokemonDb(db)
        val randomList = Utils.randomIntList(151, 1, 15)
        val pokelist = DbUtils.getPokemonsList(randomList)
        assertEquals("poison", pokelist.size == 15)
    }

    @Test
    fun testGetPokemonRest() {
        // Context of the app under test.
        val pok = DbUtils.getPokemonRest(212)
        assertEquals("scizor", pok!!.name)
    }


}
