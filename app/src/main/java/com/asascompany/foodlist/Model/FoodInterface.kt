package com.asascompany.foodlist.Model

interface FoodInterface {
    fun getFoodList(): List<FoodData>
    fun removeItem()
    fun addItem(Item: FoodData)
}