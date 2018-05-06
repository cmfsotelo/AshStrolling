package com.example.csotelo.ashstrolling.core

object AshStroll {
    @JvmStatic
    fun main(args: Array<String>) {

        try {
            var path = ""
            if (args.isNotEmpty()) {
                path = args[0]
            }
            val ash = Ash()
            val totalPokemon = ash.catchPokemonInPath(path.toLowerCase())
            println("Ash cought $totalPokemon pokemon!")

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}