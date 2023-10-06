package com.atilsamancioglu.besinlerkitabigradlework.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.atilsamancioglu.besinlerkitabigradlework.model.Food

class FoodListViewModel:ViewModel() {
     val hasFoodListChange = MutableLiveData<List<Food>>()
     val hasErrorMessage = MutableLiveData<Boolean>()
     val isLoading = MutableLiveData<Boolean>()


    fun refreshData(){

        val banana = Food("Banana","20","20","20","20","www.halil.com")
        val apple = Food("apple","30","60","99","65","www.yusuf.com")
        val strawberry = Food("strawberry","20","10","15","66","www.food.com")

        val foodList = arrayListOf<Food>(banana,apple,strawberry)

        hasFoodListChange.value = foodList
        hasErrorMessage.value=false
        isLoading.value = false

    }
}