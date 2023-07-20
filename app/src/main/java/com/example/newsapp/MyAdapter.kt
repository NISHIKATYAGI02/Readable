package com.example.newsapp

import android.app.Activity
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso



class MyAdapter(val context :Activity, val productArrayList: List<Product>) :
RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.eachitem,parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem =
            productArrayList[position]              //holder is holding the ui and view
        holder.title.text = currentItem.title
        //imageView,how to show image in imageview if the image is in form of url,3rd party library
        //picasso library

        Picasso.get().load(currentItem.thumbnail).into(holder.Image);

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var Image: ShapeableImageView


        init {
            title = itemView.findViewById(R.id.ProductTitle)
            Image = itemView.findViewById(R.id.ProductImage)
        }
    }
}

