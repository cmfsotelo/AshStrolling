package com.example.csotelo.ashstrolling


import com.example.csotelo.ashstrolling.core.Ash
import org.junit.Test

class PathTestUnit {
    private val ash = Ash()

    @Test
    fun emptyPathCheck() {
        assert(ash.catchPokemonInPath("") == 1)
    }

    @Test
    fun fstPathCheck() {
        assert(ash.catchPokemonInPath("neso") == 4)
    }

    @Test
    fun sndPathCheck() {
        assert(ash.catchPokemonInPath("NSNSNSNSNS") == 2)
    }

    @Test
    fun trdPathCheck() {
        assert(ash.catchPokemonInPath("eennesssonoo") == 10)
    }

    @Test
    fun fourthPathCheck() {
        assert(ash.catchPokemonInPath("eenneesososssneoo") == 15)
    }
}