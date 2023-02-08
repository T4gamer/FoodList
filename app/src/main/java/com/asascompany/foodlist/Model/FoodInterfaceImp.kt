package com.asascompany.foodlist.Model

class FoodInterfaceImp :FoodInterface {
    var foodItems: MutableList<FoodData> = mutableListOf()
//        get() = foodItems
//        set(value) {field=value}

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