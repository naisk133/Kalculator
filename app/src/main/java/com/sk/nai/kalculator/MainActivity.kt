package com.sk.nai.kalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.widget.ListView

class MainActivity : AppCompatActivity(), CalcFragment.OnNextButtonClickListener, MyAdapter.OnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .replace(R.id.container, CalcFragment()).commit()
    }

    override fun onNextButtonClicked(msg: String) {
        val nextFragment = NextFragment()
        val bundle = Bundle()
        bundle.putString("Result", msg)
        bundle.putString("MoreResult", "ok")

        nextFragment.arguments = bundle

        supportFragmentManager.beginTransaction()
                .replace(R.id.container, nextFragment).addToBackStack(null).commit()

    }

    override fun onItemClicked() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, DetailFragment()).addToBackStack(null).commit()
    }
}
