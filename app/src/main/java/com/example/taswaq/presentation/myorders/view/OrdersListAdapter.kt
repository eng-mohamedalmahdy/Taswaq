package com.example.taswaq.presentation.myorders.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.taswaq.R
import com.example.taswaq.databinding.ListItemOrderBinding
import com.example.taswaq.presentation.myorders.model.PresentationOrder

class OrdersListAdapter(private val ordersList: List<PresentationOrder>) :
    RecyclerView.Adapter<OrdersListAdapter.ViewHolder>() {
    class ViewHolder(val binding: ListItemOrderBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(order: PresentationOrder) {
            with(binding) {
                orderDate.text = order.orderDate
                orderStatus.setText(order.orderStatus.textValue)
                orderTotalPrice.text = ("\$${order.price}")
                Glide
                    .with(root.context)
                    .load(order.orderThumbnail)
                    .centerCrop()
                    .placeholder(R.drawable.ic_cart)
                    .into(orderThumbnail)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item_order, parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(ordersList[position])

    override fun getItemCount() = ordersList.size
}