package com.example.autoapp.ui.detailsBackendlessAuto.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.autoapp.data.model.CollectionList
import com.example.autoapp.databinding.ItemSwipeBinding
import java.util.ArrayList

class SwipeListAdapter(private val context: Context) : RecyclerView.Adapter<SwipeListAdapter.ViewHolder>() {

    val list: MutableList<CollectionList> = ArrayList()

    fun setData(newList: List<CollectionList>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SwipeListAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemSwipeBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SwipeListAdapter.ViewHolder, position: Int) {
        return holder.bindList(list[position])
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(private val binding: ItemSwipeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindList(collectionList: CollectionList) {
            Glide.with(context).load(collectionList.imageCar).into(binding.ivImage)
        }
    }
}