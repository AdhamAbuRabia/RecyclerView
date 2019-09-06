package com.example.productrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerProductAdapter(var context : Context , var list : ArrayList<String>):

    RecyclerView.Adapter<RecyclerProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int ): ProductViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.product_layout , parent , false)
        return ProductViewHolder(view)

    }

    override fun getItemCount(): Int {

        return list.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val currentObject = list[position]
        holder.tv.text = currentObject

    }


    inner class ProductViewHolder(item: View): RecyclerView.ViewHolder(item){
        val tv = item.findViewById<TextView>(R.id.ProductTV)
    }
}