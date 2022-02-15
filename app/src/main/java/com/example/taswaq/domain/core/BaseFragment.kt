package com.example.taswaq.domain.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<B : ViewDataBinding> : Fragment() {

    protected lateinit var binding: B
    abstract val layoutId: Int
    abstract val drawerIcon: Int?
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            layoutId,
            container,
            false
        )
        setupAppBar()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        setupAppBar()
    }

    private fun setupAppBar() {
        if (drawerIcon != null) {
            (activity as AppCompatActivity).supportActionBar?.setHomeAsUpIndicator(drawerIcon!!)
            (activity as AppCompatActivity).supportActionBar?.show()

        } else {
            (activity as AppCompatActivity).supportActionBar?.hide()
        }
    }
}