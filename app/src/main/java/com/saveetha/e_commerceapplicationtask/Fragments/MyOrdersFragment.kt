package com.saveetha.e_commerceapplicationtask.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.saveetha.e_commerceapplicationtask.Adapters.MyOrdersAdapter
import com.saveetha.e_commerceapplicationtask.MainActivity
import com.saveetha.e_commerceapplicationtask.ViewModels.MyOrdersViewModel
import com.saveetha.e_commerceapplicationtask.databinding.FragmentMyOrdersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyOrdersFragment : Fragment() {

    lateinit var binding: FragmentMyOrdersBinding

    private val myOrdersViewModel: MyOrdersViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMyOrdersBinding.inflate(layoutInflater, container, false)

        val activity = requireActivity() as? MainActivity
        activity?.binding?.toolbar?.title = "My Orders"

        binding.ordersRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        myOrdersViewModel.savedProducts.observe(viewLifecycleOwner) { products ->
            if (products != null) {
                binding.noDataFound.visibility = View.GONE
                binding.ordersRecyclerView.visibility = View.VISIBLE
                val adapter = MyOrdersAdapter(products)
                binding.ordersRecyclerView.adapter = adapter
            } else {
                binding.ordersRecyclerView.visibility = View.GONE
                binding.noDataFound.visibility = View.VISIBLE
            }
        }

        return binding.root
    }

}