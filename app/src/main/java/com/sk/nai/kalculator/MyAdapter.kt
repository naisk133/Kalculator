package com.sk.nai.kalculator

import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.zip.Inflater

/**
 * Created by naisk133 on 22/12/2559.
 */
class MyAdapter(val listener: OnItemClickListener?) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val nameText: TextView = itemView.findViewById(R.id.name_text_view) as TextView
        val text1: TextView = itemView.findViewById(R.id.text_view1) as TextView
        val text2: TextView = itemView.findViewById(R.id.text_view2) as TextView

        fun bind(listener: OnItemClickListener?, formula: Formula) {
            nameText?.text = formula.name
            text1?.text = formula.formula
            text2?.text = formula.params.toString()

            itemView.setOnClickListener {
                listener?.onItemClicked(formula)
            }
        }
    }

    override fun getItemCount(): Int {
        return FormulaSingleton.formulas.size//To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        val view = inflater.inflate(R.layout.item_recycler, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        holder?.bind(listener, FormulaSingleton.formulas[position])
    }

    interface OnItemClickListener {
        fun onItemClicked(formula: Formula)
    }
}