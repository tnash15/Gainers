package com.example.apigainers.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.apigainers.R
import com.example.apigainers.model.Response

class APIAdapter : RecyclerView.Adapter<APIAdapter.StockViewHolder>(){

    private val data = arrayListOf<Response>()

    fun setData(items: List<Response>){
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_activity, parent,false)
        return StockViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(viewHolder: StockViewHolder, position: Int) {
        viewHolder.bind(data[position])
    }

    class StockViewHolder(val view: View): RecyclerView.ViewHolder(view){
        fun bind(data: Response) {
            val tvSymbol = view.findViewById<TextView>(R.id.tvSymbol)
            val tvCompanyName = view.findViewById<TextView>(R.id.tvCompanyName)
            val tvSector = view.findViewById<TextView>(R.id.tvSector)
            tvSymbol.text = data.symbol
            tvCompanyName.text = data.companyName
            tvSector.text = data.sector
        }

    }
}