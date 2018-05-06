package com.example.csotelo.ashstrolling.core.data.json

class PokemonType {
    val name: String = ""
    var url: String = ""
        set(value) {
            field = value
            id = value.split("type/")[1].split("/")[0].toInt()
        }
    var id: Int = 0
}