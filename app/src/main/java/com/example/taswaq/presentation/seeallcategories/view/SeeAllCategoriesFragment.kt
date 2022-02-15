package com.example.taswaq.presentation.seeallcategories.view


import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.taswaq.R
import com.example.taswaq.databinding.FragmentSeeAllCategoriesBinding
import com.example.taswaq.presentation.common.view.CategoriesAdapter
import com.example.taswaq.domain.core.BaseFragment
import com.example.taswaq.presentation.seeallcategories.SeeAllCategoriesViewModel
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel


class SeeAllCategoriesFragment : BaseFragment<FragmentSeeAllCategoriesBinding>() {
    override val layoutId = R.layout.fragment_see_all_categories
    override val drawerIcon: Int = R.drawable.ic_back

    private val viewModel: SeeAllCategoriesViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.getCategoriesList.collect {
                binding.categoriesList.adapter = CategoriesAdapter(it)
            }
        }
    }
}