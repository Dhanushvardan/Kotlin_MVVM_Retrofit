package com.example.kotlin_mvvm_retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_mvvm_retrofit.databinding.ItemDataBinding

class Adapter(private val d:MutableList<Data>):RecyclerView.Adapter<Adapter.DataViewHolder>() {

    class DataViewHolder(val binding: ItemDataBinding):RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent:ViewGroup,viewType: Int):DataViewHolder{


        val binding = ItemDataBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataViewHolder(binding)


    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.binding.data = d[position]
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return d.size
    }


}