package com.atilsamancioglu.besinlerkitabigradlework.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.atilsamancioglu.besinlerkitabigradlework.R
import com.atilsamancioglu.besinlerkitabigradlework.model.Food
import kotlinx.android.synthetic.main.besin_recycler_row.view.isim
import kotlinx.android.synthetic.main.besin_recycler_row.view.kalori

class FoodRecyclerAdapter (val foodList:ArrayList<Food>):RecyclerView.Adapter<FoodRecyclerAdapter.FoodViewHolder>() {
    class FoodViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.besin_recycler_row,parent,false)
        return FoodViewHolder(view)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.itemView.isim.text = foodList[position].foodName
        holder.itemView.kalori.text = foodList[position].foodCalorie
        //image will be added
    }
    @SuppressLint("NotifyDataSetChanged")
    fun updateFoodList(newFoodList:List<Food>){
        foodList.clear()
        foodList.addAll(newFoodList)
        notifyDataSetChanged()
    }
}