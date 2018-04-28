package com.example.csotelo.ashstrolling


import com.example.csotelo.ashstrolling.core.Ash
import org.junit.Test

class PathTestUnit {
    private val ash = Ash()

    @Test
    fun fstPathCheck() {
        assert(ash.moveInPath("neso") == 4)
    }

    @Test
    fun sndPathCheck() {
        assert(ash.moveInPath("NSNSNSNSNS") == 2)
    }

    @Test
    fun trdPathCheck() {
        assert(ash.moveInPath("eennesssonoo") == 10)
    }

    @Test
    fun fourthPathCheck() {
        assert(ash.moveInPath("eenneesososssneoo") == 15)
    }
}