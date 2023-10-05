package com.study.fragment_study.part1

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.study.fragment_study.R


class Fragment_B : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val goToFrCbtn: Button = view.findViewById(R.id.toFragmentC)
        val back: Button = view.findViewById(R.id.backBtn)


        goToFrCbtn.setOnClickListener {
            val bundle = bundleOf("text" to "Text from fragment B")
            Navigation.findNavController(view).navigate(R.id.action_fragmentB_to_fragmentC, bundle)
        }

        back.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fragmentB_to_fragmentA)
        }

        }
    }
