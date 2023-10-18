package com.atilsamancioglu.besinlerkitabigradlework.model

import com.google.gson.annotations.SerializedName

data class Food(
    @SerializedName("isim")
    val foodName: String?,
    @SerializedName("kalori")
    val foodCalorie: String?,
    @SerializedName("karbonhidrat")
    val foodCarbohydrate: String?,
    @SerializedName("protein")
    val foodProtein: String?,
    @SerializedName("yag")
    val foodOil: String?,
    @SerializedName("gorsel")
    val foodImageUrl: String?
)