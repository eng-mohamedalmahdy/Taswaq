package com.example.taswaq.presentation.common.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.taswaq.MainGraphDirections
import com.example.taswaq.R
import com.example.taswaq.databinding.ListItemProductBinding
import com.example.taswaq.presentation.common.model.Product

class ProductsAdapter(private val products: List<Product>) :
    RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_product, parent, false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(products[position])

    override fun getItemCount() = products.size

    inner class ViewHolder(private val binding: ListItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            with(binding) {
                productName.text = product.name
                productPrice.text = ("\$${product.price}")
                Glide
                    .with(root.context)
                    .load(product.imageUrl)
                    .centerCrop()
                    .placeholder(R.drawable.ic_cart)
                    .into(productImage)
                itemView.setOnClickListener {
                    val navController = Navigation.findNavController(itemView)
                    navController.navigate(MainGraphDirections.navigateToProductDetails(product.id))
                }
            }
        }
    }
}