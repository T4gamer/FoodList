package com.asascompany.foodlist.Model

import com.asascompany.foodlist.R

class FoodInterfaceImp :FoodInterface {
    private val foodItems = mutableListOf(
        FoodData("Cookies", 5.0f,"10 pieces of chocolate Cookies", R.drawable.ic_baseline_menu_24),
        FoodData("Pizza", 15.0f,"normal cheese pizza", R.drawable.ic_baseline_menu_24),
    )

    override fun getFoodList(): List<FoodData> {
        return foodItems
    }

    override fun removeItem() {
        foodItems.removeLast()
    }

    override fun addItem(item: FoodData) {
        foodItems.add(item)
    }
}