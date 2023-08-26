package com.atilsamancioglu.besinlerkitabigradlework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_besin_listesi.besin_listesi_button


class BesinListesiFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_besin_listesi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        besin_listesi_button.setOnClickListener{
            val action = BesinListesiFragmentDirections.actionBesinListesiFragmentToBesinDetayiFragment(3)
            Navigation.findNavController(it).navigate(action)
        }
    }


}