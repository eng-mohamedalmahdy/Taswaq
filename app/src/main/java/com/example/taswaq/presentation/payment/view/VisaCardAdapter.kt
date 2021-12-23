package com.example.taswaq.presentation.payment.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.taswaq.R
import com.example.taswaq.databinding.ListItemPaymentCardBinding
import com.example.taswaq.domain.model.DomainVisa

class VisaCardAdapter(var visaCardList: List<DomainVisa>):
    RecyclerView.Adapter<VisaCardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_payment_card, parent,false)
           )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(visaCardList[position])

    override fun getItemCount(): Int = visaCardList.size

    fun submitList(newList:List<DomainVisa>){
        this.visaCardList = newList
        notifyDataSetChanged()
    }

    class ViewHolder (private val binding:ListItemPaymentCardBinding)
        :RecyclerView.ViewHolder(binding.root){
        fun bind(domainVisa: DomainVisa) {
           with(binding){
               visaNo.text = domainVisa.visaNumber
               visaDate.text = domainVisa.visaOutDate
               cardUsername.text = domainVisa.visaUserName
           }

        }

    }
}