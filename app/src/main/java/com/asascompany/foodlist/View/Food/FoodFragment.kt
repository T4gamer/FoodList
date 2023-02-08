package com.asascompany.foodlist.View.Food

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.asascompany.foodlist.Model.FoodData
import com.asascompany.foodlist.Model.FoodInterfaceImp
import com.asascompany.foodlist.R
import com.asascompany.foodlist.SharedPrefs
import com.asascompany.foodlist.databinding.FragmentFoodBinding


class FoodFragment : Fragment(R.layout.fragment_food) {

    private var _binding: FragmentFoodBinding? = null
    private val binding get() = _binding!!
    lateinit private var adapter : FoodAdapter
    val model = FoodInterfaceImp()

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
        binding.floatingActionButton.setOnClickListener { model.addItem(model.getFoodList().random()) ;adapter.notifyItemInserted(model.getFoodList().lastIndex)}
        //submit the list
        adapter.submitList(model.getFoodList())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}