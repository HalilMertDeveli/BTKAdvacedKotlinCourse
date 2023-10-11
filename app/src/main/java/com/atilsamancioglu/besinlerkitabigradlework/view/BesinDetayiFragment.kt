package com.atilsamancioglu.besinlerkitabigradlework.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.atilsamancioglu.besinlerkitabigradlework.R
import com.atilsamancioglu.besinlerkitabigradlework.viewModel.FoodDetailViewModel
import com.atilsamancioglu.besinlerkitabigradlework.viewModel.FoodListViewModel
import kotlinx.android.synthetic.main.fragment_besin_detayi.besinImage
import kotlinx.android.synthetic.main.fragment_besin_detayi.besinIsim
import kotlinx.android.synthetic.main.fragment_besin_detayi.besinKalori
import kotlinx.android.synthetic.main.fragment_besin_detayi.besinKarbonhidrat
import kotlinx.android.synthetic.main.fragment_besin_detayi.besinProtein
import kotlinx.android.synthetic.main.fragment_besin_detayi.besinyag


class BesinDetayiFragment : Fragment() {
    private lateinit var foodDetailViewModelInstance: FoodDetailViewModel

    private var besinId  =0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_besin_detayi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        foodDetailViewModelInstance =  ViewModelProviders.of(this).get(FoodDetailViewModel::class.java)
        foodDetailViewModelInstance.getDataFromRoom()


        arguments?.let {
            besinId = BesinDetayiFragmentArgs.fromBundle(it).besinId
            println(besinId)
        }
        observeLiveData()
    }
    fun observeLiveData(){
        foodDetailViewModelInstance.foodLiveData.observe(viewLifecycleOwner, Observer{
            besinIsim.text = it.foodName
            besinKalori.text = it.foodCalorie
            besinKarbonhidrat.text = it.foodCarbohydrate
            besinProtein.text= it.foodProtein
            besinyag.text = it.foodOil

        })
    }


}