package com.asascompany.foodlist

import androidx.annotation.DrawableRes

data class FoodData (
    val name : String,
    val price : Float,
    val Details : String,
    @DrawableRes val img : Int
        )