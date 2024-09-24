package com.saveetha.e_commerceapplicationtask.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.saveetha.e_commerceapplicationtask.Models.Product
import com.saveetha.e_commerceapplicationtask.R
import com.squareup.picasso.Picasso

class MyOrdersAdapter(val products: List<Product>):RecyclerView.Adapter<MyOrdersAdapter.Viewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_orders_adapter, parent, false)
        return Viewholder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val item = products[position]
        Picasso.get().load(item.image).into(holder.myOrdersProductImgIV)
        holder.myOrdersProductNameTV.text = item.name
        holder.myOrdersProductPriceTV.text = "₹ ${item.price}"
    }

    inner class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val myOrdersProductImgIV = itemView.findViewById<ImageView>(R.id.myOrdersProductImgIV)
        val myOrdersProductNameTV = itemView.findViewById<TextView>(R.id.myOrdersProductNameTV)
        val myOrdersProductPriceTV = itemView.findViewById<TextView>(R.id.myOrdersProductPriceTV)

    }
}