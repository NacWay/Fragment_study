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
import com.study.fragment_study.R

class Fragment_C : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__c, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            parentFragmentManager.setFragmentResultListener("requestKey", this) { requestKey, bundle ->
            val result = bundle.getString("bundleKey")
            val text : TextView= view.findViewById(R.id.textFromB)
            text.setText(result)
        }

        val fragmentB = Fragment_B()
        val fragmentD = Fragment_D()

        val back: Button = view.findViewById(R.id.backBtn)
        val goToFragmentD: Button = view.findViewById(R.id.toFragmentD)

        goToFragmentD.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer, fragmentD)
                addToBackStack(null)
                commit()
            }
        }

        back.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer, fragmentB)
                commit()
            }
        }
    }
}