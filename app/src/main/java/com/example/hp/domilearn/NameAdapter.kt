package com.example.hp.domilearn

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class NameAdapter(val context: Context, val name: List<Name>): RecyclerView.Adapter<NameAdapter.Holder>() {

    override fun onBindViewHolder(holder: Holder?, position: Int) {
        holder?.bindAd(name[position], context)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.person_name, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return name.count()
    }

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        private val name = itemView?.findViewById<TextView>(R.id.name)

        fun bindAd(PersonName: Name, context: Context) {
            name?.text = PersonName.name
        }
    }
}