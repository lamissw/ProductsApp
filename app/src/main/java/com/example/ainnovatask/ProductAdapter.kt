package com.example.ainnovatask

import android.content.Intent
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
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        val holder = ProductViewHolder(view)
        view.setOnClickListener{
            val position = holder.adapterPosition
            val product = productList[position]
            val intent = Intent(parent.context, ProductDetailsActivity::class.java)
            intent.putExtra("product_thumbnail", product.thumbnail)
            intent.putExtra("product_title", product.title)
            intent.putExtra("product_description", product.description)
            intent.putExtra("product_brand", product.brand)
            intent.putExtra("product_category", product.category)
            intent.putExtra("product_price", product.price)
            intent.putExtra("product_rating", product.rating)
            parent.context.startActivity(intent)
        }
        return holder
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.productName.text = product.title
        holder.productDescription.text = product.description
        Glide.with(holder.itemView).load(product.thumbnail).into(holder.productThumbnail)
    }

    override fun getItemCount() = productList.size
}
