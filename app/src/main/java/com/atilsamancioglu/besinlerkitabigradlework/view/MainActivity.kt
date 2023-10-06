package com.atilsamancioglu.besinlerkitabigradlework.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.atilsamancioglu.besinlerkitabigradlework.R
import com.atilsamancioglu.besinlerkitabigradlework.adapter.FoodRecyclerAdapter
import com.atilsamancioglu.besinlerkitabigradlework.model.Food

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}