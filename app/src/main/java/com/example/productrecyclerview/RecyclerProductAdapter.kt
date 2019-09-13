package com.example.productrecyclerview

import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView


class RecyclerProductAdapter(var context : Context , var list : ArrayList<Product>):
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
        holder.name.text = currentObject.name
        holder.price.text = currentObject.price.toString()

        holder.mAlertDialogBtn.setOnClickListener {
            val mAlertDialog = AlertDialog.Builder(this.context)
            mAlertDialog.setTitle("water bottle")
            mAlertDialog.setMessage("this is a water bottle")
            mAlertDialog.setIcon(R.drawable.bottle_of_water)

            mAlertDialog.setPositiveButton("Add To Cart"){ dialog : DialogInterface?, id : Int ->
                Toast.makeText(this.context , "added" , Toast.LENGTH_SHORT).show()

            }

            mAlertDialog.setNegativeButton("Cancel"){ dialog : DialogInterface?, id : Int ->
                dialog!!.dismiss()
            }

            mAlertDialog.show()

        }
    }


    inner class ProductViewHolder(item: View): RecyclerView.ViewHolder(item){
        val name = item.findViewById<TextView>(R.id.ProductName)
        val price = item.findViewById<TextView>(R.id.productPrice)
        val mAlertDialogBtn = item.findViewById<Button>(R.id.infoBtn)

    }


}