package com.example.csotelo.ashstrolling

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import com.example.csotelo.ashstrolling.core.Ash

import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick


class StrollFragment : Fragment() {

    internal var ash = Ash()
    @BindView(R.id.tvPath)
    internal var tvPath: TextView? = null
    @BindView(R.id.btnClear)
    internal var btnClear: Button? = null
    @BindView(R.id.tvPokemonCaught)
    internal var tvPokemonCaught: TextView? = null

    @OnClick(R.id.btnN, R.id.btnO, R.id.btnE, R.id.btnS)
    fun navClick(btn: Button) {
        tvPath!!.append(btn.text)
        btnClear!!.visibility = View.VISIBLE
    }

    @OnClick(R.id.btnStartPath)
    fun pathClick(btn: Button) {
        val pokemonCaught = ash.catchPokemonInPath(tvPath!!.text.toString())
        tvPokemonCaught!!.setText(pokemonCaught)
    }

    @OnClick(R.id.btnClear)
    fun clearPath(btn: Button) {
        tvPath!!.text = ""
        btnClear!!.visibility = View.INVISIBLE
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater!!.inflate(R.layout.fragment_stroll, container, false)
        ButterKnife.bind(this, rootView)
        return rootView
    }


}
