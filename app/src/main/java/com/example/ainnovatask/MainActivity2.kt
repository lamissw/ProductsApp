package com.example.ainnovatask

import ApiInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager


class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val recyclerView = findViewById<RecyclerView>(R.id.productRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val retrofit = ApiService.buildService(ApiInterface::class.java)

        val call = retrofit.getProducts()
        call.enqueue(object : Callback<ProductResponse>{
            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                if(response.isSuccessful) {
                    val productResponse = response.body()
                    val productList = productResponse?.products ?: emptyList()
                    val adapter = ProductAdapter(productList)
                    recyclerView.adapter = adapter
                }
                else {
                    Toast.makeText(applicationContext, "Failed to fetch products", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "Failed to fetch products", Toast.LENGTH_SHORT).show()
            }
        })
    }
}