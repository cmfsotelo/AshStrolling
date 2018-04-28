package com.example.csotelo.ashstrolling

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.OnClick


class AboutFragment : Fragment() {

    @OnClick(R.id.tv_author)
    fun linkClick() {
        val uri = Uri.parse(getString(R.string.author_url))
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater!!.inflate(R.layout.fragment_about, container, false)
        ButterKnife.bind(this, rootView)
        return rootView
    }


}
