package com.example.csotelo.ashstrolling.listing


import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import com.example.csotelo.ashstrolling.R
import com.example.csotelo.ashstrolling.core.data.entities.Pokemon
import com.example.csotelo.ashstrolling.utils.TextUtils
import com.github.florent37.picassopalette.PicassoPalette
import com.squareup.picasso.Picasso


class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val pokemonIdTextView: TextView = itemView.findViewById<View>(R.id.tv_pokemon_id) as TextView
    private val pokemonSpriteImageView: ImageView = itemView.findViewById<View>(R.id.iv_pokemon) as ImageView
    private val pokemonNameTextView: TextView = itemView.findViewById<View>(R.id.tv_pokemon) as TextView

    fun bindTo(pokemon: Pokemon) {
        itemView.tag = pokemon.id
        pokemonIdTextView.text = itemView.context.getString(R.string.pokemon_id, TextUtils.toThreeDigitNumber(pokemon.id))
        pokemonNameTextView.text = pokemon.name
        Picasso.with(itemView.context)
                .load(pokemonSpriteUrl(pokemon.id))
                .into(pokemonSpriteImageView, picassoPaletteCallBack(pokemonSpriteUrl(pokemon.id)))
    }

    private fun pokemonSpriteUrl(id: Int): String {
        return POKE_IMAGE_URL_PREFIX + id + POKE_IMAGE_URL_SUFFIX
    }

    private fun picassoPaletteCallBack(spriteUrl: String): PicassoPalette {
        return PicassoPalette.with(spriteUrl, pokemonSpriteImageView).use(PicassoPalette.Profile.MUTED).intoBackground(itemView)
    }

    fun clear() {
        itemView.invalidate()
        pokemonIdTextView.invalidate()
        pokemonNameTextView.invalidate()
        pokemonSpriteImageView.invalidate()
    }

    companion object {
        private val POKE_IMAGE_URL_PREFIX = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"
        private val POKE_IMAGE_URL_SUFFIX = ".png"
    }
}
