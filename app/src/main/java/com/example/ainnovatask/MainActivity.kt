package com.example.ainnovatask

import ApiInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response
import android.content.Intent
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = ApiService.buildService(ApiInterface::class.java)

        val username = findViewById<EditText>(R.id.editTextTextUsername)
        val password = findViewById<EditText>(R.id.editTextTextPassword)
        val loginButton = findViewById<Button>(R.id.button)
        loginButton.setOnClickListener {
            val usernameString = username.text.toString()
            val passwordString = password.text.toString()

            val call = retrofit.requestLogin(UserRequest(usernameString, passwordString))
            call.enqueue(object : Callback<UserResponse> {
                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                    if (response.isSuccessful) {
                        val loginResponse = response.body()
                        if (loginResponse != null) {
                            val token = loginResponse.token
                            if (!token.isNullOrBlank()) {
                                navigateToHomeScreen()
                            } else {
                                Toast.makeText(applicationContext, "Invalid login credentials", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            Toast.makeText(applicationContext, "Invalid login credentials", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(applicationContext, "Invalid login credentials", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    //display error message
                }
            })
        }
    }
    private fun navigateToHomeScreen() {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }
}