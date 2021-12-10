package com.example.taswaq.presentation.cart.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.taswaq.R
import com.example.taswaq.databinding.ListItemCartBinding
import com.example.taswaq.presentation.cart.model.PresentationCartItem

class CartAdapter(
    private val onDeleteCLick: (Int) -> Unit,
    private val onIncCLick: (Int) -> Unit,
    private val onDecCLick: (Int) -> Unit,
    private var cart: List<PresentationCartItem>? = null
) :
    RecyclerView.Adapter<CartAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item_cart, parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        cart?.let {
            holder.bind(it[position], position)
        }
    }

    override fun getItemCount() = cart?.size ?: 0

    fun submitList(newList: List<PresentationCartItem>) {
        cart = newList
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ListItemCartBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cartItem: PresentationCartItem, idx: Int) {
            with(binding) {
                productName.text = cartItem.productName
                productBrand.text = cartItem.productBrand
                productUnitPrice.text = ("\$${cartItem.productUnitPrice}")
                productQty.text = "${cartItem.productQty}"
                productTotal.text = ("\$${cartItem.getTotalPrice()}")
                productInControllerQty.text = ("${cartItem.productQty}")
                Glide.with(root.context)
                    .load(cartItem.productImageUrl)
                    .centerCrop()
                    .placeholder(R.drawable.ic_cart)
                    .into(productThumbnail)

                productInc.setOnClickListener {
                    onIncCLick(cartItem.id)
                    notifyItemChanged(idx)
                }
                productDec.setOnClickListener {
                    onDecCLick(cartItem.id)
                    notifyItemChanged(idx)
                }
                deleteFromCart.setOnClickListener {
                    onDeleteCLick(cartItem.id)
                    notifyItemChanged(idx)
                }
            }
        }
    }
}