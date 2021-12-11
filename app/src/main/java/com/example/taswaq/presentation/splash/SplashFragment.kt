package com.example.taswaq.presentation.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.taswaq.R
import com.example.taswaq.application.OnMotionCompletedListener
import com.example.taswaq.application.postDelayed
import com.example.taswaq.databinding.FragmentSplashBinding
import com.example.taswaq.presentation.core.BaseFragment

class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    override val layoutId = R.layout.fragment_splash
    override val drawerIcon: Int? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val transitionListener = OnMotionCompletedListener { _, _ ->
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
        }
        binding.motionLayout.setTransitionListener(transitionListener)
    }
}