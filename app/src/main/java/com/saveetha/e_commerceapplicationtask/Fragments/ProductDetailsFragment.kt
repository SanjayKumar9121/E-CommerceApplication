package com.saveetha.e_commerceapplicationtask.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.saveetha.e_commerceapplicationtask.MainActivity
import com.saveetha.e_commerceapplicationtask.Models.Product
import com.saveetha.e_commerceapplicationtask.ViewModels.ProductDetailsViewModel
import com.saveetha.e_commerceapplicationtask.databinding.FragmentProductDetailsBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailsFragment : Fragment() {

    lateinit var binding: FragmentProductDetailsBinding

    private val productDetailsViewModel: ProductDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProductDetailsBinding.inflate(layoutInflater, container, false)

        val activity = requireActivity() as? MainActivity
        activity?.binding?.toolbar?.title = "Poduct Details"

        val productName = arguments?.getString("product_name")
        val productDescription = arguments?.getString("product_description")
        val productImage = arguments?.getString("product_image")
        val productPrice = arguments?.getInt("product_price")

        Picasso.get().load(productImage).into(binding.buyerViewProductImgIV)
        binding.buyerViewProductNameTV.text = productName
        binding.buyerViewProductPriceTV.text = productPrice.toString()
        binding.buyerProductDescriptionDetailsTV.text = productDescription

        binding.buyerViewProductOrderBtn.setOnClickListener {
            // Create a Product object
            val product = Product(
                null,
                productName!!,
                productDescription!!,
                productImage!!,
                productPrice!!
            )

            // Use the ViewModel to insert product
            productDetailsViewModel.insertProduct(product)
            Toast.makeText(requireContext(), "Ordered Successfully", Toast.LENGTH_LONG).show()
        }

        return binding.root
    }

}