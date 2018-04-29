package com.example.csotelo.ashstrolling.listing;


import android.arch.paging.PagedListAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.csotelo.ashstrolling.R;
import com.example.csotelo.ashstrolling.core.data.Pokemon;


import static com.example.csotelo.ashstrolling.AshstrollingApplication.getContext;

public class PokemonAdapter extends PagedListAdapter<Pokemon, PokemonViewHolder> {


    public PokemonAdapter() {
        super(Pokemon.DIFF_CALLBACK);
    }

    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new PokemonViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PokemonViewHolder holder, int position) {
        Pokemon pokemon = getItem(position);

        if (pokemon != null) {
            holder.bindTo(pokemon);
        } else {
            holder.clear();
        }
    }
}
