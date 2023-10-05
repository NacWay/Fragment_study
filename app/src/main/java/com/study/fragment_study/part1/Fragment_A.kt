package com.study.fragment_study.part1


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.study.fragment_study.R


class Fragment_A : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.study.fragment_study.R.layout.fragment__a, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val goToFragmentB: Button = view.findViewById(com.study.fragment_study.R.id.toFragmentB)

       goToFragmentB.setOnClickListener {
           Navigation.findNavController(view).navigate(R.id.action_fragmentA_to_fragmentB)
       }
    }
}