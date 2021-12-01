package com.example.taswaq.presentation.common.view

import android.graphics.Color
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taswaq.presentation.common.model.Category
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.taswaq.R
import com.example.taswaq.databinding.ListItemCategoryBinding


class CategoriesAdapter(var categories: List<Category>? = null) :
    RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item_category, parent, false
        )
    )
    override fun getItemCount(): Int = categories?.size ?: 0


    override fun onBindViewHolder(holder: ViewHolder, position: Int)
            : Unit = categories?.let { holder.bind(it[position]) } ?: Unit




    inner class ViewHolder(private val binding: ListItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            with(binding) {
                categoryName.text = category.name
                categoryColorOverlay.setBackgroundColor(Color.parseColor(category.color))
                Glide
                    .with(root.context)
                    .load(category.imageUrl)
                    .centerCrop()
                    .placeholder(R.drawable.ic_cart)
                    .into(categoryImage)
            }
        }
    }
}