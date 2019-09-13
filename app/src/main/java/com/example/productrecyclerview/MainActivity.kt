package com.example.productrecyclerview

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.product_layout.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter: RecyclerProductAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val array = arrayListOf<Product>()
        for (i in 0 until 20)
            array.add(Product("ffyy", i, i.toDouble()))

        adapter = RecyclerProductAdapter(this@MainActivity, array)

        ProductList.layoutManager =
            LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)

        ProductList.adapter = adapter
        addStrBtn.setOnClickListener {
            addString(Product())
        }
    }


    fun addString(str: Product) {
        str.name = "asdfg"
        adapter.list.add(str)
        adapter.notifyDataSetChanged()
    }


}
