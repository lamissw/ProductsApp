package com.example.ainnovatask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.w3c.dom.Text
import android.content.Intent

class ProductDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_details_screen)
//
        val thumbnail = intent.getStringExtra("product_thumbnail")
        val title = intent.getStringExtra("product_title")
        val description = intent.getStringExtra("product_description")
        val brand = intent.getStringExtra("product_brand")
        val category = intent.getStringExtra("product_category")
        val price = intent.getDoubleExtra("product_price", 0.0)
        val rating = intent.getDoubleExtra("product_rating", 0.0)
//
        val productThumbnail = findViewById<ImageView>(R.id.product_thumbnail)
        val productTitle = findViewById<TextView>(R.id.product_title)
        val productDescription = findViewById<TextView>(R.id.product_description)
        val productBrand = findViewById<TextView>(R.id.product_brand)
        val productCategory = findViewById<TextView>(R.id.product_category)
        val productPrice = findViewById<TextView>(R.id.product_price)
        val productRating = findViewById<TextView>(R.id.product_rating)
//
        Glide.with(this).load(thumbnail).into(productThumbnail)
        productTitle.text = title
        productDescription.text = description
        productBrand.text = brand
        productCategory.text = category
        productPrice.text = price.toString()
        productRating.text = rating.toString()

    }
}