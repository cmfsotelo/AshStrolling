package com.example.csotelo.ashstrolling.listing


import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import com.example.csotelo.ashstrolling.AshstrollingApplication
import com.example.csotelo.ashstrolling.core.data.entities.Pokemon
import com.example.csotelo.ashstrolling.core.data.PokemonDataBase

class MainViewModel : ViewModel() {

    internal val pokemonList: LiveData<PagedList<Pokemon>>

    init {
        val pokemonDao = PokemonDataBase.getInstance(AshstrollingApplication.context!!).pokemonDao()
        pokemonList = pokemonDao.pokemons().create(INITIAL_LOAD_KEY, PagedList.Config.Builder()
                .setPageSize(PAGE_SIZE)
                .setPrefetchDistance(PREFETCH_DISTANCE)
                .setEnablePlaceholders(true)
                .build()
        )
    }

    companion object {

        private val INITIAL_LOAD_KEY = 0
        private val PAGE_SIZE = 20
        private val PREFETCH_DISTANCE = 5
    }
}
