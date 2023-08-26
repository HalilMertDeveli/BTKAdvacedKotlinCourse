package com.atilsamancioglu.besinlerkitabigradlework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_besin_detayi.besin_detayi_button


class BesinDetayiFragment : Fragment() {
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
        arguments?.let {
            besinId = BesinDetayiFragmentArgs.fromBundle(it).besinId
            println(besinId)
        }
        besin_detayi_button.setOnClickListener {
            val action = BesinDetayiFragmentDirections.actionBesinDetayiFragmentToBesinListesiFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }


}