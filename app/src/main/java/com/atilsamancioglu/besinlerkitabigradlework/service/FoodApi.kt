package com.atilsamancioglu.besinlerkitabigradlework.service

import com.atilsamancioglu.besinlerkitabigradlework.model.Food
import io.reactivex.Single
import retrofit2.http.GET

interface FoodApi {
    //you need to get http after raw
    //https://raw.githubusercontent.com/atilsamancioglu/btk20-jsonveriseti/master/besinler.json

    //Base URL = https://raw.githubusercontent.com/
    //Data URL = atilsamancioglu/btk20-jsonveriseti/master/besinler.json

    @GET("atilsamancioglu/btk20-jsonveriseti/master/besinler.json")
    fun getFoods():Single<List<Food>>

}