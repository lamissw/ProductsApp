package com.example.ainnovatask

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


class ProductAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productName = itemView.findViewById<TextView>(R.id.product_title)
        val productThumbnail = itemView.findViewById<ImageView>(R.id.product_thumbnail)
        val productDescription = itemView.findViewById<TextView>(R.id.product_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_view, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.productName.text = product.title
        holder.productDescription.text = product.description
        Glide.with(holder.itemView).load(product.thumbnail).into(holder.productThumbnail)
    }

    override fun getItemCount() = productList.size
}
