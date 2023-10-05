package com.study.fragment_study.part1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.navArgs
import com.study.fragment_study.R

class Fragment_C : Fragment() {

    val args : Fragment_CArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__c, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            val text1 : TextView = view.findViewById(R.id.textFromB)
            text1.setText(args.texttext)



        val back: Button = view.findViewById(R.id.backBtn)
        val goToFragmentD: Button = view.findViewById(R.id.toFragmentD)


        goToFragmentD.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fragmentC_to_fragmentD)
        }

        back.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fragmentC_to_fragmentB)
        }
    }
}