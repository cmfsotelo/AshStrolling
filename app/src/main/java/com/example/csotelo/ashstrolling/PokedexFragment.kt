package com.example.csotelo.ashstrolling

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.arch.paging.PagedList
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import com.example.csotelo.ashstrolling.core.data.DbUtils
import com.example.csotelo.ashstrolling.core.data.entities.Pokemon
import com.example.csotelo.ashstrolling.listing.PokemonAdapter
import com.example.csotelo.ashstrolling.listing.PokemonViewModel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers


class PokedexFragment : Fragment() {
    @BindView(R.id.rv_pokemons)
    lateinit var recyclerView: RecyclerView
    val TAG = PokedexFragment::class.java.name
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater!!.inflate(R.layout.fragment_pokedex, container, false)
        ButterKnife.bind(this, rootView)


        val viewModel = ViewModelProviders.of(this).get(PokemonViewModel::class.java)
        val adapter = PokemonAdapter()
        viewModel.pokemonList.observe(this, Observer<PagedList<Pokemon>> { adapter.setList(it) })
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = adapter
        return rootView
    }

    lateinit var pokemonObs: Observable<Pokemon>

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        pokemonObs = DbUtils.getAllPokemonsObservable()
                .observeOn(Schedulers.computation())
                .subscribeOn(Schedulers.computation())
    }

    override fun onStart() {
        super.onStart()
        pokemonObs.subscribe()
    }

    override fun onStop() {
        super.onStop()
        pokemonObs.unsubscribeOn(Schedulers.computation())
    }
}

