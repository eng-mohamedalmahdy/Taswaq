package com.example.taswaq.presentation.myorders

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.taswaq.R
import com.example.taswaq.databinding.FragmentMyOrdersBinding
import com.example.taswaq.presentation.core.BaseFragment

class MyOrdersFragment : BaseFragment<FragmentMyOrdersBinding>() {
    override val layoutId = R.layout.fragment_my_orders
    override val drawerIcon = R.drawable.ic_back
}