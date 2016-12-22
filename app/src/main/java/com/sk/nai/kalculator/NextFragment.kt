package com.sk.nai.kalculator

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_next.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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

    override fun onResume() {
        super.onResume()
        loadDataFromAPI()
    }

    fun initInstance(savedInstanceState: Bundle?) {
        text_view.text = arguments.getString("Result") + arguments.getString("MoreResult") + arguments.getString("MoreMoreResult")

        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        recycler_view.layoutManager = llm

        if (activity is MyAdapter.OnItemClickListener) {
            recycler_view.adapter = MyAdapter(activity as MyAdapter.OnItemClickListener)
        }else{
            recycler_view.adapter = MyAdapter(null)
        }
    }

    fun loadDataFromAPI() {
        APIManager.formulaService.listFormulas().enqueue(object : Callback<List<Formula>> {

            override fun onResponse(call: Call<List<Formula>>?, response: Response<List<Formula>>?) {

                if (response != null && response.isSuccessful) {
                    FormulaSingleton.formulas = response.body()

                    recycler_view.adapter.notifyDataSetChanged()

                    Log.wtf("NextFragment", "Response is Success")

                } else {
                    Log.wtf("NextFragment", "Response is Fail with ${response?.message()}")
                }

            }

            override fun onFailure(call: Call<List<Formula>>?, t: Throwable?) {
                Log.wtf("NextFragment", "No Response")
            }

        })
    }

}