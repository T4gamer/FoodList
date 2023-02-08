package com.asascompany.foodlist.Model

import com.asascompany.foodlist.View.Food.FoodData

interface FoodInterface {
    fun getFoodList(): List<FoodData>
    fun removeItem()
    fun addItem(Item:FoodData)
}