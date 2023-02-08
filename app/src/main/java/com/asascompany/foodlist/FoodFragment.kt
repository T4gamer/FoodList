package com.asascompany.foodlist

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.asascompany.foodlist.databinding.FragmentFoodBinding


class FoodFragment : Fragment(R.layout.fragment_food) {

    private var _binding: FragmentFoodBinding? = null
    private val binding get() = _binding!!
    lateinit private var adapter :FoodAdapter
    private val namesList = mutableListOf(
        FoodData("Cookies", 5.0f,"10 pieces of chocolate Cookies",R.drawable.ic_baseline_menu_24),
        FoodData("Pizza", 15.0f,"normal cheese pizza",R.drawable.ic_baseline_menu_24),
    )



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFoodBinding.bind(view)
        val sharedprefs = SharedPrefs(requireContext())
        adapter = FoodAdapter(sharedprefs)
        adapter.onItemClick = {
            val action = FoodFragmentDirections.actionFoodFragmentToDetailsFragment(it.name,it.price,it.Details)
            findNavController().navigate(action)
        }
        binding.rvFood.adapter = adapter

        //submit the list
        adapter.submitList(namesList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}