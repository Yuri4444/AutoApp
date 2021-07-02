package com.example.autoapp.ui.backendless.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.autoapp.databinding.ItemAutoBinding
import com.example.autoapp.data.model.AutoList
import java.util.ArrayList

class AdapterMbaas(private val context: Context) : RecyclerView.Adapter<AdapterMbaas.ViewHolder>() {

    private val list : MutableList<AutoList> = ArrayList()

    fun setData(newList: List<AutoList>?) {
        list.clear()
        if (newList != null) { list.addAll(newList) }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemAutoBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return (holder).bindData(list[position])
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(private val binding : ItemAutoBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(modelAuto : AutoList) {
            Glide.with(context).load(modelAuto.image).into(binding.ivImageAuto)
            binding.tvTitle.text = modelAuto.title
        }
    }
}