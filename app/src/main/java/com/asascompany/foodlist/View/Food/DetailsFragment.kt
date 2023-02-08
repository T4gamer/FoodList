package com.asascompany.foodlist.View.Food

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.asascompany.foodlist.R
import com.asascompany.foodlist.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment(R.layout.fragment_details) {
    private var _binding : FragmentDetailsBinding? = null
    val binding get() = _binding!!
    val args: DetailsFragmentArgs by navArgs()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDetailsBinding.bind(view)
        binding.itemDetails.text = args.details
        binding.ItemName.text = args.name
        binding.itemPrice.text = args.price.toString()

    }
}