package com.sk.nai.kalculator

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_next.*


class NextFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_next, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initInstance(savedInstanceState)
    }

    fun initInstance(savedInstanceState: Bundle?){
        text_view.text = arguments.getString("Result") + arguments.getString("MoreResult")+arguments.getString("MoreMoreResult")
    }

}