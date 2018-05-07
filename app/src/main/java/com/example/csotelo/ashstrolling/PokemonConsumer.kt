package com.example.csotelo.ashstrolling

import com.example.csotelo.ashstrolling.core.data.DbUtils
import com.example.csotelo.ashstrolling.core.data.entities.Pokemon
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class PokemonConsumer : Consumer<Pokemon> {
    override fun accept(t: Pokemon?) {
        DbUtils.getPokemonObservable(t!!.id + 1)
                .observeOn(Schedulers.computation())
                .subscribeOn(Schedulers.computation())
                .subscribe(PokemonConsumer())
    }

}