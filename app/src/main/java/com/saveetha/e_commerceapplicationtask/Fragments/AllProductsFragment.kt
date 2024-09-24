package com.saveetha.e_commerceapplicationtask.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saveetha.e_commerceapplicationtask.Adapters.AllProductsAdapter
import com.saveetha.e_commerceapplicationtask.MainActivity
import com.saveetha.e_commerceapplicationtask.Models.AllProductsList
import com.saveetha.e_commerceapplicationtask.R
import com.saveetha.e_commerceapplicationtask.ViewModels.AllProductsViewModel
import com.saveetha.e_commerceapplicationtask.databinding.FragmentAllProductsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllProductsFragment : Fragment() {

    lateinit var binding: FragmentAllProductsBinding

    private val allProductsViewModel: AllProductsViewModel by viewModels()

    private lateinit var adapter: AllProductsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAllProductsBinding.inflate(layoutInflater, container, false)

        val activity = requireActivity() as? MainActivity
        activity?.binding?.toolbar?.title = "All Products"

        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        // Fetch products
        allProductsViewModel.fetchAllProducts()

        allProductsViewModel.products.observe(viewLifecycleOwner) {  products ->
            if (!::adapter.isInitialized) {
                adapter = AllProductsAdapter(products)
                binding.recyclerView.adapter = adapter
                adapter.setOnClickListeners(object : AllProductsAdapter.OnItemClickListener {
                    override fun onItemClick(itemLists: AllProductsList, position: Int) {
                        val productsDetailsFragment = ProductDetailsFragment()
                        val bundle = Bundle().apply {
                            putString("product_name", itemLists.title)
                            putString("product_description", itemLists.description)
                            putString("product_image", itemLists.image)
                            putInt("product_price", itemLists.price?.toInt()!!)
                        }
                        productsDetailsFragment.arguments = bundle
                        replaceFragment(productsDetailsFragment)
                    }

                })
            }

        }

        return binding.root
    }


    fun replaceFragment(fragment: Fragment) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

}