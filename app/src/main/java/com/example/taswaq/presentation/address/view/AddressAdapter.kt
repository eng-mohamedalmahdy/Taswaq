package com.example.taswaq.presentation.address.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.persistableBundleOf
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.taswaq.R
import com.example.taswaq.databinding.ListItemAddressBinding
import com.example.taswaq.domain.model.DomainAddress

class AddressAdapter(var addressList: List<DomainAddress>) :
    RecyclerView.Adapter<AddressAdapter.ViewHolder>() {
    var selectedId = 0


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressAdapter.ViewHolder =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_address, parent, false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(addressList[position], position)

    override fun getItemCount(): Int = addressList.size

    inner class ViewHolder(private val binding: ListItemAddressBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(domainAddress: DomainAddress, position: Int) {
            with(binding) {

                city.text = domainAddress.cityAddress
                street.text = domainAddress.streetAddress
                lat.text = domainAddress.latAddress.toString()
                lang.text = domainAddress.langAddress.toString()


                addressCheckBtn.isChecked = (position == selectedId)
                itemView.setOnClickListener {
                    selectedId = position
                    notifyDataSetChanged()
                }


            }
        }

    }
}