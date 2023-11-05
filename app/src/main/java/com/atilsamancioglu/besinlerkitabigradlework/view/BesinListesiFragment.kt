package com.atilsamancioglu.besinlerkitabigradlework.view

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.atilsamancioglu.besinlerkitabigradlework.R
import com.atilsamancioglu.besinlerkitabigradlework.adapter.FoodRecyclerAdapter
import com.atilsamancioglu.besinlerkitabigradlework.viewModel.FoodListViewModel
import kotlinx.android.synthetic.main.fragment_besin_listesi.besinHataMesaji
import kotlinx.android.synthetic.main.fragment_besin_listesi.besinListRecycler
import kotlinx.android.synthetic.main.fragment_besin_listesi.besinYukleniyor
import kotlinx.android.synthetic.main.fragment_besin_listesi.swipeRefreshLayout


class BesinListesiFragment : Fragment() {
    private lateinit var viewModel: FoodListViewModel
    private var foodRecyclerAdapter = FoodRecyclerAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_besin_listesi, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FoodListViewModel::class.java)
        viewModel.refreshData()

        besinListRecycler.layoutManager = LinearLayoutManager(context)
        besinListRecycler.adapter = foodRecyclerAdapter

        swipeRefreshLayout.setOnRefreshListener {
            besinYukleniyor.visibility= View.VISIBLE
            besinHataMesaji.visibility = View.GONE
            besinListRecycler.visibility = View.GONE

            viewModel.refreshData()
            swipeRefreshLayout.isRefreshing = false
        }

        observeLiveData()

    }

    fun observeLiveData() {
        viewModel.foodList.observe(viewLifecycleOwner, Observer { foodList ->
            foodList.let {
                besinListRecycler.visibility = View.VISIBLE
                foodRecyclerAdapter.updateFoodList(foodList)
            }
        })
        viewModel.foodErrorMessage.observe(viewLifecycleOwner, Observer { error ->
            error?.let {
                if (error) {
                    besinHataMesaji.visibility = View.VISIBLE
                } else {
                    besinHataMesaji.visibility = View.GONE
                }
            }
        })
        viewModel.foodIsLoading.observe(viewLifecycleOwner, Observer { isLoadingCircular ->
            isLoadingCircular?.let {
                if (it) {
                    besinYukleniyor.visibility = View.VISIBLE
                } else {
                    besinYukleniyor.visibility = View.GONE
                }
            }
        })
    }


}