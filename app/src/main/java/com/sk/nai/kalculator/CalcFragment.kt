package com.sk.nai.kalculator

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_calc.*


class CalcFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_calc, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initInstances(savedInstanceState)
    }

    fun initInstances(savedInstanceState: Bundle?) {

        add_button.setOnClickListener({
            val x = edit_text1.text.toString().toIntCheckedChecked()
            val y = edit_text2.text.toString().toIntCheckedChecked()
            text_view.text = "${x + y}"
        })
        sub_button.setOnClickListener {
            val x = edit_text1.text.toString().toIntCheckedChecked()
            val y = edit_text2.text.toString().toIntCheckedChecked()
            text_view.text = "${x - y}"
        }
        mul_button.setOnClickListener {
            val x = edit_text1.text.toString().toIntCheckedChecked()
            val y = edit_text2.text.toString().toIntCheckedChecked()
            text_view.text = "${x * y}"
        }
        div_button.setOnClickListener {
            val x = edit_text1.text.toString().toIntCheckedChecked()
            val y = edit_text2.text.toString().toIntCheckedChecked()
            text_view.text = if (y == 0) "undefined" else "${x / y}"
        }

        next_button.setOnClickListener {
            myActivityWhichIsImplementsListener.onNextButtonClicked(text_view.text.toString())
        }
    }

    lateinit var myActivityWhichIsImplementsListener: OnNextButtonClickListener

    interface OnNextButtonClickListener {
        fun onNextButtonClicked(msg:String)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnNextButtonClickListener) {
            myActivityWhichIsImplementsListener = context
        }
    }
}
