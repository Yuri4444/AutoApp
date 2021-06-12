package com.example.autoapp.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.autoapp.data.Auto
import com.example.autoapp.databinding.ItemAutoBinding

class AutoAdapter(private val context: Context,
                  private val clickListener: ClickListener ) : RecyclerView.Adapter<AutoAdapter.ViewHolder>() {
    private val list: MutableList<Auto> = ArrayList()

    interface ClickListener {
        fun onItemSelected(id : String)
    }

    fun setData(listAuto: List<Auto>) {
        list.clear()
        list.addAll(listAuto)
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

    inner class ViewHolder(private val binding: ItemAutoBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                clickListener.onItemSelected(list[adapterPosition].id)
            }
        }

        fun bindData(modelAuto: Auto) {
            Glide.with(context)
                .load(modelAuto.image)
                .into(binding.ivImageAuto)

            binding.tvTitle.text = modelAuto.title
        }

    }
}