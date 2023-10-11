package com.atilsamancioglu.besinlerkitabigradlework.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.atilsamancioglu.besinlerkitabigradlework.model.Food

class FoodDetailViewModel : ViewModel() {
    val foodLiveData = MutableLiveData<Food>()

    fun getDataFromRoom() {
        val banana = Food("Banana", "100", "100", "120", "50", "banana.jpg")
    }
}