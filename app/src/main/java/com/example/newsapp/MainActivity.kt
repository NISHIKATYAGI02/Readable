package com.example.newsapp

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var  myAdapter: MyAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        val retrofit = null
        Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(apiinterface::class.java)
        val retrofitBuilder = null
        val retrofitData = retrofitBuilder.getProductDate()

        retrofitData.enqueue(object :Callback<mydata?>{
            override fun onResponse(call: Call<mydata?>, response: Response<mydata?>) {
              //if api is successful then do whatever u want too with that data and use the the data of api and show in ur application
                //call is a parameter which hold data of mydata then ---response is come
                var responseBody = response.body() // my data.kt all 4 data was found in it

                val productsList = responseBody?.products!!

                //if(productlist !=null)is ine se bchne k liee yeh !! mark lgya h
                //products=ductlist in it

                myAdapter = MyAdapter(this@MainActivity,productsList)
                recyclerView.adapter = myAdapter
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

            }

            override fun onFailure(call: Call<mydata?>, t: Throwable) {
               // if api call is fails
                // throwable k undr  errors seen
                Log.d("Main Activity", "onFailure: ")
            }
        })
    }
}

private fun Any.enqueue(callback: Callback<mydata?>) {

}

private fun Nothing?.getProductDate() {

}




