package com.study.fragment_study.part1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.study.fragment_study.R

class Fragment_C : Fragment() {



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
            text1.setText("")



        val back: Button = view.findViewById(R.id.backBtn)
        val goToFragmentD: Button = view.findViewById(R.id.toFragmentD)


        goToFragmentD.setOnClickListener {

        }

        back.setOnClickListener {

        }
    }
}